class Pojazd(private val _producent:String, private val _model:String) {
  private var _rok:Int = -1
  private var _rejestracja:String = ""

  def this(producent:String, model:String, rok:Int) =
    this(producent,model)
    _rok = rok

  def this(producent:String, model:String, rejestracja:String) =
    this(producent,model)
    _rejestracja = rejestracja

  def this(producent:String, model:String, rejestracja:String, rok:Int) =
    this(producent, model)
    _rejestracja = rejestracja
    _rok = rok

  def producent:String = _producent
  def model:String = _model
  def rok:Int = _rok
  def rejestracja:String = _rejestracja

  def rejestracja_=(rejestracja:String) =
    _rejestracja = rejestracja
}