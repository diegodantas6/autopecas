package br.com.autopecas.controleAcesso

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

class UsuarioGrupoController {

	def mensagemService
	def messageSource
	def springSecurityService

//	@Secured([
//		"ROLE_CREATE_USUARIO_GRUPO",
//		"ROLE_READ_USUARIO_GRUPO",
//		"ROLE_UPDATE_USUARIO_GRUPO",
//		"ROLE_DELETE_USUARIO_GRUPO"
//	])
    def index() { 
	}
	
	@Secured("IS_AUTHENTICATED_FULLY")
	def listar(){
		
		def lista = UsuarioGrupo.list(sort: "nome")
		render(template:"lista", model:[lista: lista])

	}
	
	@Secured("ROLE_CREATE_USUARIO_GRUPO")
	def incluir(){
		
		UsuarioGrupo novoUsuarioGrupo = new UsuarioGrupo()
		render(template:"form", model: [usuarioGrupo: novoUsuarioGrupo, editable: true])
	}
	
	@Secured("ROLE_READ_USUARIO_GRUPO")
	def visualizar(){
		
		UsuarioGrupo usuarioGrupo = UsuarioGrupo.get(params.id)
		render(template:"form", model: [usuarioGrupo: usuarioGrupo, editable: false])
		
	}

	@Secured("ROLE_UPDATE_USUARIO_GRUPO")
	def alterar(){
		
		UsuarioGrupo usuarioGrupo = UsuarioGrupo.get(params.id)
		render(template:"form", model: [usuarioGrupo: usuarioGrupo, editable: true])
		
	}
	
	@Secured("IS_AUTHENTICATED_FULLY")
	def salvar(UsuarioGrupo usuarioGrupo){
		
		def retorno

		boolean erroVersion = false

		try {

			if (params.usuarioGrupo.id) {
				
				def old = Permissao.read(params.usuarioGrupo.id.toLong())
				
				if (old.version.toLong() > params.usuarioGrupo.version.toLong()) {

					retorno = mensagemService.getMensagem("O Ramo Atividade já foi alterado por outro usuário!\nFavor canecelar esta operação e tentar novamente!", false)

					erroVersion = true
				}
			}

			if (!erroVersion) {

				if (usuarioGrupo.hasErrors()) {

					String mensagem = "Não foi possível salvar!"
					
					usuarioGrupo.errors.allErrors.each { error ->
						mensagem += '\n' + messageSource.getMessage(error, null)
					}

					retorno = mensagemService.getMensagem(mensagem, false)
				} else {

					usuarioGrupo.save(flush:true)

					retorno = mensagemService.getMensagem("Salvo com sucesso!")
				}

			}

		} catch (Exception e) {

			retorno = mensagemService.getMensagem("Erro ao tentar salvar!", false)

		}

		render retorno as JSON
	}
	
	@Secured("ROLE_DELETE_USUARIO_GRUPO")
	def excluir(){

		def retorno

		try {

			UsuarioGrupo usuarioGrupo = UsuarioGrupo.get(params.id)

			usuarioGrupo.delete(flush:true)

			retorno = mensagemService.getMensagem("Excluido com sucesso!")
		} catch (Exception e) {

			retorno = mensagemService.getMensagem("Erro ao tentar excluir!", false)
		}

		render retorno as JSON

	}
	
}
