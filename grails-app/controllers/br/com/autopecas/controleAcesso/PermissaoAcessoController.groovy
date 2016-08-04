package br.com.autopecas.controleAcesso

import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

import org.codehaus.groovy.grails.web.json.JSONArray
import org.codehaus.groovy.grails.web.json.JSONObject


@Secured("ROLE_UPDATE_PERMISSAO_ACESSO")
class PermissaoAcessoController {
	
	def mensagemService

	def index() {
		def grupos = UsuarioGrupo.listOrderByNome()
		
		render view: "index", model: [grupos: grupos] 
	}

	private String getTreeViewDataSemGrupoMenu( UsuarioGrupo usuarioGrupo ) {

		JSONArray retorno = new JSONArray()

		List listPermissaoGrupo = PermissaoGrupo.listOrderByNome()

		for (permissaoGrupo in listPermissaoGrupo) {

			JSONObject itemAux = getJsonItemByPermissaoGrupo(permissaoGrupo)

			JSONArray retornoAuxItems2 = new JSONArray()

			List listPermissao = Permissao.findAllByGrupo(permissaoGrupo, [sort: "descricao"])

			for (permissao in listPermissao) {

				retornoAuxItems2.add(getJsonItemByPermissao(permissao, usuarioGrupo))
			}

			itemAux.putAt("items", retornoAuxItems2)

			retorno.add(itemAux)
		}

		return retorno.toString().replaceAll("\"", "")
	}

	private String getTreeViewDataComGrupoMenu( UsuarioGrupo usuarioGrupo ) {

		JSONArray retorno = new JSONArray()

		List listPermissaoGrupoMenu = PermissaoGrupoMenu.listOrderByNome()

		for (permissaoGrupoMenu in listPermissaoGrupoMenu) {

			JSONObject retornoAux = getJsonItemByPermissaoGrupoMenu(permissaoGrupoMenu)

			JSONArray retornoAuxItems1 = new JSONArray()

			List listPermissaoGrupo = PermissaoGrupo.findAllByMenu(permissaoGrupoMenu, [sort: "nome"])

			for (permissaoGrupo in listPermissaoGrupo) {

				JSONObject itemAux = getJsonItemByPermissaoGrupo(permissaoGrupo)

				JSONArray retornoAuxItems2 = new JSONArray()

				List listPermissao = Permissao.findAllByGrupo(permissaoGrupo, [sort: "descricao"])

				for (permissao in listPermissao) {

					retornoAuxItems2.add(getJsonItemByPermissao(permissao, usuarioGrupo))
				}

				itemAux.putAt("items", retornoAuxItems2)

				retornoAuxItems1.add(itemAux)
			}

			retornoAux.putAt("items", retornoAuxItems1)

			retorno.add(retornoAux)
		}

		return retorno.toString().replaceAll("\"", "")
	}

	private JSONObject getJsonItemByPermissao(Permissao permissao, UsuarioGrupo usuarioGrupo) {

		JSONObject jPermissao = new JSONObject()

		jPermissao.putAt("id", "'" + permissao.id + "'")
		jPermissao.putAt("text", "'" + permissao.descricao + "'")

		if ( UsuarioGrupoPermissao.findByGrupoAndPermissao(usuarioGrupo, permissao) == null ) {

			jPermissao.putAt("checked", false)
		} else {

			jPermissao.putAt("checked", true)
		}

		return jPermissao
	}

	private JSONObject getJsonItemByPermissaoGrupo(PermissaoGrupo permissaoGrupo) {

		JSONObject jPermissaoGrupo = new JSONObject()

		jPermissaoGrupo.putAt("id", "'" + permissaoGrupo.id + "r'")
		jPermissaoGrupo.putAt("text", "'" + permissaoGrupo.nome + "'")
		jPermissaoGrupo.putAt("spriteCssClass", "'folder'")
		jPermissaoGrupo.putAt("expanded", false)

		return jPermissaoGrupo
	}

	private JSONObject getJsonItemByPermissaoGrupoMenu(PermissaoGrupoMenu permissaoGrupoMenu) {

		JSONObject jPermissaoGrupoMenu = new JSONObject()

		jPermissaoGrupoMenu.putAt("id", "'" + permissaoGrupoMenu.id + "m'")
		jPermissaoGrupoMenu.putAt("text", "'" + permissaoGrupoMenu.nome + "'")
		jPermissaoGrupoMenu.putAt("spriteCssClass", "'rootfolder'")
		jPermissaoGrupoMenu.putAt("expanded", true)

		return jPermissaoGrupoMenu
	}

	def carregaTreeView() {

		Long idUserGroup = Long.valueOf( params.id )

		if (idUserGroup > 0L) {

			UsuarioGrupo usuarioGrupo = UsuarioGrupo.get( idUserGroup );

			//String retorno = getTreeViewDataSemGrupoMenu( usuarioGrupo )
			String retorno = getTreeViewDataComGrupoMenu( usuarioGrupo )

			render template: "form", model: [retorno: retorno]
		} else {

			render template: "form", model: [retorno: "{}"]
		}
	}

	def save() {

		def retorno

		UsuarioGrupo usuarioGrupo = UsuarioGrupo.get(params.grupoUsuario)

		if (usuarioGrupo == null) {
			
			retorno = mensagemService.getMensagem("Favor serlecionar o Grupo Usuário!", false)

		} else {

			UsuarioGrupoPermissao.removeAll(usuarioGrupo, true)

			List usuarios = Usuario.findAllByGrupo(usuarioGrupo)

			for (usuario in usuarios) {

				UsuarioPermissao.removeAll(usuario, true)
			}

			String[] permissoes = params.result.toString().split(",")

			for (idPermissao in permissoes) {

				if (isInteger(idPermissao)) {

					Permissao permissao = Permissao.get(idPermissao)

					UsuarioGrupoPermissao.create(usuarioGrupo, permissao, true)

					for (usuario in usuarios) {

						UsuarioPermissao.create(usuario, permissao, true)
					}
				}
			}

			retorno = mensagemService.getMensagem("Salvo com sucesso!")
		}

		render retorno as JSON
	}

	private boolean isInteger(String string) {
		try {
			Integer.parseInt(string)
			return true
		} catch (Exception e) {
			return false
		}
	}
}
