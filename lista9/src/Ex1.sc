class Time(private var _hour:Int) {
  hour_=(_hour)
  
  def hour:Int = _hour
  def hour_=(newHour:Int):Unit =
    _hour = if hour<0 then 0 else hour
}

var t = new Time(-1)
t.hour
