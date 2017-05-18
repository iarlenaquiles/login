$("#login").click(function() {
	window.location = 'login.html';
});

$("#logout").click(function() {
	$.post('logout', function(resposta) {
		window.location = 'login.html';
	});
});

$("#formTarefa").submit(function(event) {
	var dados = $(this).serialize();
	$.post('salvar', dados, function(resposta) {
		if(resposta == "sucesso"){
			$("#mensagem").html("<div class='alert alert-success'><strong>Salvo com Sucesso!</strong></div>").fadeOut(3000);
			$("#tarefa").val("");
		}else{
			$("#mensagem").html("<div class='alert alert-danger'><strong>Já existe na lista de tarefas!</strong></div>").fadeOut(3000);
		}
		
	});
	event.preventDefault();
	$.get("getlistatarefas", function(resposta) {
		$("#listaTarefas").html(resposta);
	});
});

$(window).on("load", function() {
	$.get("getlistatarefas", function(resposta) {
		$("#listaTarefas").html(resposta);
	});
});

$(document).on("click", "#excluir", function() { 
	var nometarefa = $(this).attr('nometarefa');
	$.post('excluir', {nometarefa:nometarefa}, function(resposta){
		if(resposta == "sucesso"){
			$("#mensagemExclusao").html("<div class='alert alert-success'><strong>Excluído com Sucesso!</strong></div>").fadeOut(3000);
		}
	});
	
	$.get("getlistatarefas", function(resposta) {
		$("#listaTarefas").html(resposta);
	});
});

$(document).on("click", "#editar", function() { 
	var nometarefa = $(this).attr('nometarefa');
	$("#tarefa").val(nometarefa);
	
	$.post('excluir', {nometarefa:nometarefa}, function(resposta){
	});
	
	$.get("getlistatarefas", function(resposta) {
		$("#listaTarefas").html(resposta);
	});
});