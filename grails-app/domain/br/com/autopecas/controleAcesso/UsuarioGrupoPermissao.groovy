package br.com.autopecas.controleAcesso

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.apache.commons.lang.builder.HashCodeBuilder

@ToString(cache=true, includeNames=true, includePackage=false)
class UsuarioGrupoPermissao implements Serializable {

	private static final long serialVersionUID = 1

	UsuarioGrupo grupo
	Permissao permissao

	UsuarioGrupoPermissao(UsuarioGrupo u, Permissao r) {
		this()
		grupo = u
		permissao = r
	}

	@Override
	boolean equals(other) {
		if (!(other instanceof UsuarioGrupoPermissao)) {
			return false
		}

		other.grupo?.id == grupo?.id && other.permissao?.id == permissao?.id
	}

	@Override
	int hashCode() {
		def builder = new HashCodeBuilder()
		if (grupo) builder.append(grupo.id)
		if (permissao) builder.append(permissao.id)
		builder.toHashCode()
	}

	static UsuarioGrupoPermissao get(long grupoId, long permissaoId) {
		criteriaFor(grupoId, permissaoId).get()
	}

	static boolean exists(long grupoId, long permissaoId) {
		criteriaFor(grupoId, permissaoId).count()
	}
	
	private static DetachedCriteria criteriaFor(long grupoId, long permissaoId) {
		UsuarioGrupoPermissao.where {
			grupo == UsuarioGrupo.load(grupoId) &&
			permissao == Permissao.load(permissaoId)
		}
	}

	static UsuarioGrupoPermissao create(UsuarioGrupo grupo, Permissao permissao, boolean flush = false) {
		def instance = new UsuarioGrupoPermissao(grupo, permissao)
		instance.save(flush: flush, insert: true)
		instance
	}

	static void removeAll(UsuarioGrupo u, boolean flush = false) {
		if (u == null) return

		UsuarioGrupoPermissao.where { grupo == u }.deleteAll()

		if (flush) { UsuarioGrupoPermissao.withSession { it.flush() } }
	}

	static constraints = {
		permissao validator: { Permissao r, UsuarioGrupoPermissao ur ->
			if (ur.grupo == null || ur.grupo.id == null) return
			boolean existing = false
			UsuarioGrupoPermissao.withNewSession {
				existing = UsuarioGrupoPermissao.exists(ur.grupo.id, r.id)
			}
			if (existing) {
				return 'userRole.exists'
			}
		}
	}

	static mapping = {
		version false
		permissao lazy: false
	}
}
