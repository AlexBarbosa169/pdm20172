class Usuario{			
		private var nome : String = "Alex"
		private var renda : Float = 0f
		private var listaIniciante = ArrayList<String>() 
		private var listaMedia = ArrayList<CorrupcaoMedia>()				
		private var listaAvancada2 : HashMap<String,CorrupcaoAvancada> = hashMapOf()
	
	constructor(n : String){
		this.nome = n		
	}
	
	fun getNome() : String{
		return nome
	}
	
	fun getRenda() : Float{
		return renda
	}
	
	fun addCorrupIni(descricao : String){
		listaIniciante.add(descricao)
	}
	
	fun addCorrupMedia(descricao : String , valor : Float){		
		//listaMedia.add(CorrupcaoMedia(descricao, valor))
		var c = CorrupcaoMedia(descricao,valor)
		this.renda += valor
		listaMedia.add(c)
	}
	
	fun addCorrupAvancada(descricao : String , valor : Float){				
		if(listaAvancada2.contains(descricao)){				
			listaAvancada2.replace(descricao, CorrupcaoAvancada(descricao, valor))
			this.renda += valor
		}else{			
			listaAvancada2.put(descricao, CorrupcaoAvancada(descricao, valor))
			this.renda += valor
		}
			
	}
	
	fun calcRenda() : Float{
		var v : Float = 0f
				for(c in listaMedia)
					v += c.getValorM()
				
				for(c2 in listaAvancada2)
					v += c2.value.getValorA()
		return v
	}		
	
	fun getListIni() : String{
		var texto = "--- Lista das Corrupções Iniciais ---\n"
		for(ini in listaIniciante){
			texto += "------------${ini}------------\n\n";
		}
		return texto
	}
	
	fun getListMed() : String{
		var texto = "--- Lista das Corrupções Médias ---\n\n"
		for(med in listaMedia){
			texto += "------------------${med.imprimeCorrupcao()}--------------- \n\n"
		}			
		return texto
	}
	
	fun getListAva() : String{
		var texto = "--- Lista das Corrupções Avançadas ---\n"
		for(ava in listaAvancada2){
			texto += "---------------- ${ava.value.imprimeCorrupcaoAvancada()} -----------------\n\n"
		}			
		return texto
	}
	
	fun imprimeDadosUsuario() : String{
		var texto = " ----- Usuario = ${this.getNome()} Renda = ${this.calcRenda()}\n -----"		
		return texto
	}
	
	fun imprimeUsuario() : String{
		var texto = "Usuario = ${this.getNome()} Renda = ${this.calcRenda()}\n "
		texto += "${getListIni()} + ${getListMed()} + ${getListAva()}"
		return texto
	}
			
}