package br.com.autopecas.cadastro

class Produto implements Serializable {

	private static final long serialVersionUID = 1

	String nome
	String localidade
	String codigoBarras
	Integer quantidade
	Double precoAtacado
	Double precoVarejo
	Double precoAtacadista

	static constraints = {
		nome blank: false, unique: true
	}
	
}
