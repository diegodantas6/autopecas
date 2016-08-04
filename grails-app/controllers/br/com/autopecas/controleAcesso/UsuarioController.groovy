package br.com.autopecas.controleAcesso

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

class UsuarioController {

	def messageSource
	def mensagemService
	def springSecurityService

	@Secured(["ROLE_CREATE_USUARIO", "ROLE_READ_USUARIO", "ROLE_UPDATE_USUARIO", "ROLE_DELETE_USUARIO"])
	def index() {
	}

	@Secured("ROLE_CREATE_USUARIO")
	def incluir() {

		def listaGrupoUsuario = UsuarioGrupo.list(sort: "nome")

		Usuario novoUsuario = new Usuario()
		novoUsuario.grupo = new UsuarioGrupo()

		render template:"form", model: [usuario: novoUsuario, grupos: listaGrupoUsuario, editable: true]
	}

	@Secured("ROLE_READ_USUARIO")
	def visualizar() {

		Usuario usuario = Usuario.get(params.id)

		render(template:"form", model: [usuario: usuario, editable: false])
	}

	@Secured("ROLE_UPDATE_USUARIO")
	def alterar() {

		def listaGrupoUsuario = UsuarioGrupo.list(sort: "nome")

		Usuario usuario = Usuario.get(params.id)

		render template:"form", model: [usuario: usuario, grupos: listaGrupoUsuario, editable: true]
	}

	@Secured("IS_AUTHENTICATED_FULLY")
	def listar() {

		def lista = Usuario.listOrderByUsername()

		render template: "lista", model:[lista: lista]
	}


	@Secured("IS_AUTHENTICATED_FULLY")
	def salvar(Usuario usuario) {

		def retorno

		boolean erroVersion = false

		boolean incluir = false
		
		try {

			if (params.usuario.id) {

				def old = Usuario.read(params.usuario.id.toLong())

				if (old.version.toLong() > params.usuario.version.toLong()) {

					retorno = mensagemService.getMensagem("O Usuário já foi alterado por outro usuário!\nFavor canecelar esta operação e tentar novamente!", false)

					erroVersion = true
				}
			} else {
				incluir = true

				usuario.clearErrors()
			}

			if (!erroVersion) {
				
				usuario.validate()

				if (usuario.hasErrors()) {

					String mensagem = "Não foi possível salvar!"
					
					usuario.errors.allErrors.each { error ->
						mensagem += '\n' + messageSource.getMessage(error, null)
					}

					retorno = mensagemService.getMensagem(mensagem, false)
				} else {
				
					usuario.save(flush:true)
					
					if (incluir) {
						// ************************************************
						// Incluir as permissoes do grupo no usuario
						// ************************************************
						UsuarioPermissao.removeAll(usuario, true)
						
						List<UsuarioGrupoPermissao> listUsuarioGrupoPermissao = UsuarioGrupoPermissao.findAllByGrupo(usuario.grupo)
			
						for (usuarioGrupoPermissao in listUsuarioGrupoPermissao) {
							UsuarioPermissao.create(usuario, usuarioGrupoPermissao.permissao, true)
						}
					}
	
					retorno = mensagemService.getMensagem("Salvo com sucesso!")
				}

			}

		} catch (Exception e) {
		
			e.printStackTrace()

			retorno = mensagemService.getMensagem("Erro ao tentar salvar!", false)

		}

		render retorno as JSON

	}

	@Secured("ROLE_DELETE_USUARIO")
	def excluir() {

		def retorno

		try {

			Usuario usuario = Usuario.get(params.id)

			UsuarioPermissao.removeAll(usuario, true)

			usuario.delete(flush:true)

			retorno = mensagemService.getMensagem("Excluido com sucesso!")

		} catch (Exception e) {

			retorno = mensagemService.getMensagem("Erro ao tentar excluir!", false)

		}

		render retorno as JSON

	}

}
