package br.com.autopecas.controleAcesso

class PermissaoGrupo implements Serializable {

	private static final long serialVersionUID = 1

	String nome
	PermissaoGrupoMenu menu

	static constraints = {
		nome blank: false, unique: true
		menu blank: false
	}

}
