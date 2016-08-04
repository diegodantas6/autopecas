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
    <!-- Gentelella -->
    <asset:stylesheet src="gentelella/gentelella.css"/>
  </head>

  <body class="login">
    <div class="login_wrapper">
      <div class="animate form login_form">
        <section class="login_content">
          <form action='${postUrl}' method='POST' id='loginForm' autocomplete='off'>
            
            <h1>Login</h1>
            
            <g:if test='${flash.message}'>
              <div class='login_message'>${flash.message}</div>
            </g:if>
            
            <div>
              <input type="text" name="j_username" class="form-control" placeholder="Username" required="" />
            </div>
            <div>
              <input type="password" name="j_password" class="form-control" placeholder="Password" required="" />
            </div>
            <div>
              <input type="submit" class="btn btn-default" value="Entrar" />
              <!-- <input type="reset" class="btn btn-default" value="Limpar" /> -->
            </div>
          </form>
        </section>
      </div>
    </div>
  </body>
</html>
