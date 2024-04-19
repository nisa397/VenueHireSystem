package nz.ac.auckland.se281;

public class Date {
  private int day = 0;
  private int month = 0;
  private int year = 0;
  private String stringDate = "";

  public Date(int day, int month, int year, String stringDate) {
    this.day = day;
    this.month = month;
    this.year = year;
    this.stringDate = stringDate;
  }

  // Method checks whether this date is past the inputted date
  public boolean pastDate(Date other) {
    // Year is after this year
    if (this.year > other.year) {
      return true;
    }
    // Year is the same but month is after this month
    if (this.year == other.year && this.month > other.month) {
      return true;
    }
    // Year is before this year or month is before this month or day is this before today
    else if (this.year < other.year || this.month < other.month || this.day < other.day) {
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(this.stringDate, other.stringDate);
      return false;
    }

    return true;
  }

  public int getDay() {
    return this.day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getMonth() {
    return this.month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public String getStringDate() {
    return this.stringDate;
  }

  public void setStringDate(String stringDate) {
    this.stringDate = stringDate;
  }

  public int getYear() {
    return this.year;
  }

  public void setYear(int year) {
    this.year = year;
  }
}
