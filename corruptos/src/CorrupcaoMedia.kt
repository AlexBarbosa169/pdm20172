class CorrupcaoMedia {
	private var tipo : String = ""
	private var valor : Float = 0.0f
	
	constructor(t : String , v : Float){
		this.tipo = t
		this.valor = v
	}
	
	fun getValorM () : Float {
		return this.valor
	}
		
	fun imprimeCorrupcao():String {
		return "Corrupção: ${this.tipo} = ${this.valor}"
	}
}