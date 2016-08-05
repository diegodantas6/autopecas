package br.com.autopecas.cadastro

class Cliente implements Serializable {

	private static final long serialVersionUID = 1

	String nome
	String telefone

	static constraints = {
		nome blank: false, unique: true
	}
	
}
