package br.com.autopecas.controleAcesso

class Permissao implements Serializable {

	private static final long serialVersionUID = 1

	String authority
	String descricao
	PermissaoGrupo grupo

	static constraints = {
		authority blank: false, unique: true
		descricao blank: false
		grupo blank: false
	}
	
	@Override
	int hashCode() {
		authority?.hashCode() ?: 0
	}

	@Override
	boolean equals(other) {
		is(other) || (other instanceof Permissao && other.authority == authority)
	}

}
