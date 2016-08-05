<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${assetPath(src: 'favicon-cloud.ico')}" type="image/x-icon">

    <title>Autopeças</title>

    <!-- Bootstrap -->
    <asset:stylesheet src="bootstrap/bootstrap.css"/>
    <!-- Font Awesome -->
    <asset:stylesheet src="fontawesome/fontawesome.css"/>
    <!-- NProgress -->
    <asset:stylesheet src="nprogress/nprogress.css"/>
    <!-- PNotify -->
    <asset:stylesheet src="pnotify/pnotify.css"/>
    <!-- Jquery Confirm -->
    <asset:stylesheet src="jquery-confirm/jquery-confirm.min.css"/>
    <!-- Jquery Data Tables -->
    <asset:stylesheet src="jquery-dataTables/dataTables.bootstrap.css"/>
    <!-- Select2 -->
    <asset:stylesheet src="select2/select2.min.css"/>
    <!-- Gentelella -->
    <asset:stylesheet src="gentelella/gentelella.css"/>
    <!-- Custom -->
    <asset:stylesheet src="application.css"/>
  </head>

  <body class="nav-md">
  
  	<div id="spinner" class="modal">
	  <asset:image src="spinner.gif" alt="Loading..." />
	</div>
  
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="${createLink(uri: '/')}" class="site_title"><i class="fa fa-paw"></i> <span>Autopeças</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile">
              <div class="profile_pic">
              	<asset:image src="user.jpg" class="img-circle profile_img"/>
              </div>
              <div class="profile_info">
                <span>Bem vindo</span>
                <h2>
                  <sec:loggedInUserInfo field="username" />
                </h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                
                <!--<h3>General</h3>-->
                <div class="clearfix"></div>
                
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-edit"></i> Cadastro <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="${createLink(uri: '/produto/index')}">Produto</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-users"></i> Controle de Acesso <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="${createLink(uri: '/usuario/index')}">Usuário</a></li>
                      <li><a href="${createLink(uri: '/usuarioGrupo/index')}">Grupo Usuário</a></li>
                      <li><a href="${createLink(uri: '/permissaoAcesso/index')}">Permissão Acesso</a></li>
                    </ul>
                  </li>
                </ul>
              </div>

            </div>
            <!-- /sidebar menu -->

          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li role="presentation">
                  <a href="${createLink(controller: 'logout')}">
                    <i class="fa fa-power-off"></i>
                  </a>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
        	<g:layoutBody/>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            Versão: <g:meta name="app.version"/>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <asset:javascript src="jquery/jquery.js"/>
    <!-- Bootstrap -->
    <asset:javascript src="bootstrap/bootstrap.js"/>
    <!-- FastClick -->
    <asset:javascript src="fastclick/fastclick.js"/>
    <!-- NProgress -->
    <asset:javascript src="nprogress/nprogress.js"/>
    <!-- PNotify -->
    <asset:javascript src="pnotify/pnotify.js"/>
    <!-- Jquery Confirm -->
    <asset:javascript src="jquery-confirm/jquery-confirm.min.js"/>
    <!-- Jquery Data Tables -->
    <asset:javascript src="jquery-dataTables/jquery.dataTables.js"/>
    <asset:javascript src="jquery-dataTables/dataTables.bootstrap.js"/>
    <!-- Parsley -->
    <asset:javascript src="parsley/parsley.js"/>
    <asset:javascript src="parsley/i18n/pt-br.js"/>
    <!-- Select2 -->
    <asset:javascript src="select2/select2.full.js"/>
    <asset:javascript src="select2/i18n/pt-br.js"/>
    <!-- Gentelella -->
    <asset:javascript src="gentelella/gentelella.js"/>
    <!-- Custom -->
    <asset:javascript src="application.js"/>

    <g:layoutHead/>

  </body>
</html>
