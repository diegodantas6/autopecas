package br.com.autopecas.controleAcesso

class UsuarioGrupo implements Serializable {

	private static final long serialVersionUID = 1
	
	String nome
	
    static constraints = {
		nome blank: false, unique: true
    }
	
}
