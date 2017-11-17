class CorrupcaoAvancada {
	
	private var tipo : String = ""
	private var valor : Float = 0.0f
	private var frequencia : Int = 0
	
	constructor(t : String , v : Float){
		this.tipo = t
		this.valor += v
		this.frequencia ++		
	}
	
	/*fun getNome() : String{
		return nome
	}*/
	
	fun getValorA () : Float {
		return this.valor
	}
	
	fun getTipo() : String{
		return tipo
	}
	
	fun getFrequencia() : Int{
		return frequencia
	}
	
	fun imprimeCorrupcaoAvancada(): String{
		return "Corrupção: ${this.tipo} Valor = ${this.valor} Frequencia = ${this.frequencia}"
	}
}