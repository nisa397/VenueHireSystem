package nz.ac.auckland.se281;


public class Date{
  int day;
  int month;
  int year;
  String stringDate;
  public Date(int day, int month, int year,  String stringDate){
    this.day=day;
    this.month=month;
    this.year=year;
    this.stringDate=stringDate;
  }

  public boolean pastDate(Date other ){

    if (this.year>other.year){
      return true;
    }

    if (this.year==other.year && this.month>other.month){
      return true;
    }

    else if (this.year < other.year || this.month<other.month || this.day<other.day){
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(this.stringDate, other.stringDate);
      return false;
    }

    return true;
  }
}