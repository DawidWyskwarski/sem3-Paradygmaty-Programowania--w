class Time(private var _hour:Int, private var _minutes:Int) {
  hour_=(_hour)
  minutes_=(_minutes)

  def hour:Int = _hour
  def minutes:Int = _minutes

  def hour_=(hour:Int):Unit =
    if hour < 0 || hour >= 24 then
      throw new IllegalArgumentException("hour can't be negative or higher than 24")

    _hour = hour

  def minutes_=(minutes:Int):Unit =
    if minutes < 0 || minutes >= 60 then
      throw new IllegalArgumentException("minutes can't be negative or higher than 60")

    _minutes = minutes

  def before(other:Time):Boolean =
    if _hour > other.hour then
      true
    else if _hour == other.hour && _minutes > other.minutes then
      true
    else
      false

}

var t1 = new Time(23,59)
var t2 = new Time(23,59)

t1.before(t2)