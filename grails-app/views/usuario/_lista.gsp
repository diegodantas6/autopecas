<div class="x_content">
	<table id="example"	class="table table-striped table-bordered jambo_table">
		<thead>
			<tr class="headings">
				<th style="width: 50%;">Nome</th>
				<th style="width: 50%;">Grupo</th>
				<th style="width: 80px;">Ações</th>
			</tr>
		</thead>

		<tbody>
			<g:each status="i" var="usuario" in="${lista}">
				<tr class="${ (i % 2) == 0 ? 'even pointer' : 'odd pointer'}">
					<td class=" ">
						${usuario.username}
					</td>
					<td class=" ">
						${usuario.grupo.nome}
					</td>
					<td class="last">
						<a href="javascript: visualizar(${usuario.id})"><i class="fa fa-eye" data-toggle="tooltip" title="Visualizar"></i></a>
						&nbsp;&nbsp;
						
						<a href="javascript: alterar(${usuario.id})"><i class="fa fa-pencil" data-toggle="tooltip" title="Alterar"></i></a>
						&nbsp;&nbsp;

						<a href="javascript: excluir(${usuario.id})"><i class="fa fa-minus-circle" data-toggle="tooltip" title="Excluir"></i></a>
					</td>
				</tr>
			</g:each>
		</tbody>

	</table>
</div>
