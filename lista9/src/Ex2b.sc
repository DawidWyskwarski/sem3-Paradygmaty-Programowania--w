import scala.compiletime.uninitialized

class Time {

  private var minutesFromMidnight: Int = uninitialized

  def this(hour: Int, minute: Int) = {
    this()
    if (hour < 0 || hour >= 24) throw new IllegalArgumentException("hour can't be negative or higher than 24")
    if (minute < 0 || minute >= 60) throw new IllegalArgumentException("minutes can't be negative or higher than 60")
    minutesFromMidnight = 60*hour + minute
  }

  def getMinutesFromMidnight:Int = minutesFromMidnight

  def hour:Int = minutesFromMidnight/60
  def minutes:Int = minutesFromMidnight%60

  def hour_=(hour:Int):Unit =
    if hour < 0 || hour >= 24 then
      throw new IllegalArgumentException("hour can't be negative or higher than 24")

    minutesFromMidnight = hour*60 + minutes

  def minutes_=(minutes:Int):Unit =
    if minutes < 0 || minutes >= 60 then
      throw new IllegalArgumentException("minutes can't be negative or higher than 60")

    minutesFromMidnight = hour*60 + minutes

  def before(other:Time):Boolean =
    hour > other.hour || ( hour == other.hour && minutes > other.minutes )
}

var t1 = new Time(1,40)
var t2 = new Time(1,20)

t1.minutes
