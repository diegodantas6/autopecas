package br.com.autopecas.movimento

import br.com.autopecas.cadastro.Cliente
import br.com.autopecas.controleAcesso.Usuario

class Venda implements Serializable {

	private static final long serialVersionUID = 1

	Date data
	Cliente cliente
	Usuario usuario
	Double valor
	
	static hasMany = [itens: VendaItem]

	static constraints = {

	}
	
}
