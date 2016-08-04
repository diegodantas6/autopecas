package br.com.autopecas.util

import grails.transaction.Transactional

class MensagemService {

	static transactional = false
	
	def getMensagem(String mensagem) {

		def retorno = [:]

		retorno["mensagem"] = mensagem
		retorno["tipo"] = true

		return retorno
	}

	def getMensagem(String mensagem, Boolean tipo) {

		def retorno = [:]

		retorno["mensagem"] = mensagem
		retorno["tipo"] = tipo

		return retorno
	}
}
