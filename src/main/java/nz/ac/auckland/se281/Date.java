package nz.ac.auckland.se281;

public class Date {
  int day;
  int month;
  int year;
  String stringDate;

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
}
