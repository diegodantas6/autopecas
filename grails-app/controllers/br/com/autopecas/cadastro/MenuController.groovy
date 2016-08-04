package br.com.autopecas.cadastro

import grails.plugin.springsecurity.annotation.Secured

@Secured("IS_AUTHENTICATED_FULLY")
class MenuController {

	def index() {
	}

}
