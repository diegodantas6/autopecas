package br.com.autopecas.controleAcesso

class Empresa implements Serializable {
	
	private static final long serialVersionUID = 1

	String nome
	
	static constraints = {
		nome blank: false, unique: true
	}
	
}
