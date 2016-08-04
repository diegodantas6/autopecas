import br.com.autopecas.controleAcesso.Permissao
import br.com.autopecas.controleAcesso.PermissaoGrupo
import br.com.autopecas.controleAcesso.PermissaoGrupoMenu
import br.com.autopecas.controleAcesso.Usuario
import br.com.autopecas.controleAcesso.UsuarioGrupo
import br.com.autopecas.controleAcesso.UsuarioGrupoPermissao
import br.com.autopecas.controleAcesso.UsuarioPermissao

class BootStrap {

    def init = { servletContext ->
		
		String create = "Incluir"
		String read = "Visualizar"
		String update = "Alterar"
		String delete = "Excluir"

		// Controle Acesso
		PermissaoGrupoMenu controleAcesso = new PermissaoGrupoMenu(nome: "Controle de Acesso").save()

		PermissaoGrupo usuario = new PermissaoGrupo(menu: controleAcesso, nome: "Usuário").save()
		new Permissao(authority: "ROLE_CREATE_USUARIO", descricao: create, grupo: usuario).save()
		new Permissao(authority: "ROLE_READ_USUARIO", descricao: read, grupo: usuario).save()
		new Permissao(authority: "ROLE_UPDATE_USUARIO", descricao: update, grupo: usuario).save()
		new Permissao(authority: "ROLE_DELETE_USUARIO", descricao: delete, grupo: usuario).save()

		PermissaoGrupo usuarioGrupo = new PermissaoGrupo(menu: controleAcesso, nome: "Grupo Usuário").save()
		new Permissao(authority: "ROLE_CREATE_USUARIO_GRUPO", descricao: create, grupo: usuarioGrupo).save()
		new Permissao(authority: "ROLE_READ_USUARIO_GRUPO", descricao: read, grupo: usuarioGrupo).save()
		new Permissao(authority: "ROLE_UPDATE_USUARIO_GRUPO", descricao: update, grupo: usuarioGrupo).save()
		new Permissao(authority: "ROLE_DELETE_USUARIO_GRUPO", descricao: delete, grupo: usuarioGrupo).save()

		PermissaoGrupo permissaoAcesso = new PermissaoGrupo(menu: controleAcesso, nome: "Permissão Acesso").save()
		Permissao permissao = new Permissao(authority: "ROLE_UPDATE_PERMISSAO_ACESSO", descricao: update, grupo: permissaoAcesso).save()

		// Cadastro
		PermissaoGrupoMenu cadastro = new PermissaoGrupoMenu(nome: "Cadastro").save()

		PermissaoGrupo produto = new PermissaoGrupo(menu: cadastro, nome: "Produto").save()
		new Permissao(authority: "ROLE_CREATE_ATIVIDADE", descricao: create, grupo: produto).save()
		new Permissao(authority: "ROLE_READ_ATIVIDADE", descricao: read, grupo: produto).save()
		new Permissao(authority: "ROLE_UPDATE_ATIVIDADE", descricao: update, grupo: produto).save()
		new Permissao(authority: "ROLE_DELETE_ATIVIDADE", descricao: delete, grupo: produto).save()
		
		// UsuarioGrupo
		UsuarioGrupo adminGrupo = new UsuarioGrupo(nome: "Admin").save()
		
		// UsuarioGrupoPermissao
		new UsuarioGrupoPermissao(grupo: adminGrupo, permissao: permissao).save()
		
		// Usuario
		Usuario admin = new Usuario(username: "admin", password: "123", grupo: adminGrupo).save()
		
		// UsuarioPermissao
		new UsuarioPermissao(usuario: admin, permissao: permissao).save()
		
    }
    def destroy = {
    }
}
