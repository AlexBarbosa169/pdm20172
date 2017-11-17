//Alex Sandro 20151370375

import java.util.*

fun main(args: Array<String>) {

	var usuarios = ArrayList<Usuario>()

	var user = Usuario("Alex")
	var user1 = Usuario("Jo�o")
	var user2 = Usuario("Jos�")

//	Adicionando usuarios a lista de usuarios
	usuarios.add(user)
	usuarios.add(user1)
	usuarios.add(user2)

//	Povoando corrup��es do usuario Alex 
	user.addCorrupIni("N�o devolveu troco excedido!")
	user.addCorrupIni("Guardou carteira achada na rua!")
	user.addCorrupIni("N�o devolveu troco excedido!")

	user.addCorrupMedia("Ativa", 3450.30f)
//	user.addCorrupMedia("Passiva",7450.30f)
	user.addCorrupMedia("Ativa", 5450.30f)

//	Povoando corrup��es do usuario Joao		
	user1.addCorrupIni("Guardou carteira achada na rua!")

	user1.addCorrupMedia("Ativa", 1150.30f)
//	user1.addCorrupMedia("Passiva",3450.30f)
//	user1.addCorrupMedia("Sistematica",3450.30f)

	user1.addCorrupAvancada("Ativa", 100f)
	user1.addCorrupAvancada("Ativa", 200f)
	user1.addCorrupAvancada("Passiva", 300f)
	user1.addCorrupAvancada("Sistematica", 400f)

//	Povoando corrup��es do usuario Jos�

	user2.addCorrupIni("Guardou carteira achada na rua!")

	user2.addCorrupMedia("Ativa", 3450.30f)
	user2.addCorrupMedia("Ativa", 3850.30f)
	user2.addCorrupMedia("Ativa", 450.30f)

	user2.addCorrupAvancada("Ativa", 1000f)
	user2.addCorrupAvancada("Ativa", 2000f)
	user2.addCorrupAvancada("Passiva", 3000f)
	user2.addCorrupAvancada("Sistematica", 4500f)
	user2.addCorrupAvancada("Sistematica", 4400f)
	user2.addCorrupAvancada("Sistematica", 2200f)

/*
 	//Listar as Corrup��es do usuario Alex
	println(user.getListIni())
	println(user.getListMed())
	println(user.getListAva())

	//Listar as Corrup��es do usuario Jo�o
	println(user1.getListIni())
	println(user1.getListMed())
	println(user1.getListAva())

	//Listar as Corrup��es do usuario Jos�
	println(user2.getListIni())
	println(user2.getListMed())
	println(user2.getListAva())
*/


	do {
		println("----------------- Sou Corrupto :( --------------\n")
		println("1---------------- Listar Usu�rios ---------------")
		println("2 ------- Listar Maior corrupto iniciante -------")
		println("3 ------- Listar Maior corrupto Mediano ---------")
		println("4 ------- Listar Maior corrupto Avan�ado --------")
		println("0 --------------- Zero para Sair ----------------\n")

		var e = Scanner(System.`in`)
		var scape = e.nextInt()

		when (scape) {
			0 -> println("----------------- Saiu! ----------------")
			1 -> {
				println("Lista dos Usuarios cadastrados\n")
				for (u in usuarios) {
					println(u.imprimeUsuario())
				}
			}
			2 -> {
				fun inicianteMaisCorrupto(): Usuario {
					var m = usuarios.get(0)
					for (u in usuarios) {
						if (u.getListIni().count() > m.getListIni().count()) {
							m = u
						}
					}
					return m
				}
				println("Corrupto Iniciante com mais atos corruptiveis: ${inicianteMaisCorrupto().imprimeDadosUsuario()}\n")
			}
			3 -> {
				fun medianoMaisCorrupto(): Usuario {
					var m = usuarios.get(0)
					for (u in usuarios) {
						if (u.getListMed().count() > m.getListMed().count()) {
							m = u
						}
					}
					return m
				}
				println("Corrupto Mediano com mais atos corruptiveis: ${medianoMaisCorrupto().imprimeDadosUsuario()}\n")
			}

			4 -> {
				fun avancadoMaisCorrupto(): Usuario {
					var m = usuarios.get(0)
					for (u in usuarios) {
						if (u.getListAva().count() > m.getListAva().count()) {
							m = u
						}
					}
					return m
				}
				println("Corrupto Avan�ado com mais atos corruptiveis: ${avancadoMaisCorrupto().imprimeDadosUsuario()}\n")
			}

			else -> println("nenhum")
		}


	} while (scape != 0) // y is visible here!

	println("Saiu!")


}
