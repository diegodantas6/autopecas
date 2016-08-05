package br.com.autopecas.movimento

import br.com.autopecas.cadastro.Produto

class VendaItem implements Serializable {

	private static final long serialVersionUID = 1

	Produto produto
	Integer quantidade
	Double valor
	Double valorDesconto
	Double valorVenda
	
	static belongsTo = [venda: Venda]

	static constraints = {

	}
	
}
