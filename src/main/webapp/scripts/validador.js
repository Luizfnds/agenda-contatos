function validar() {
	
	event.preventDefault();
	
	let form = document.querySelector(".form-novo-contato");
	
	let nome = form.nome.value;
	let telefone = form.telefone.value;
	let email = form.email.value;
	
	form.nome.style = "";
	form.telefone.style = "";
	
	if(nome === "") {
		form.nome.style.border = "solid 1px rgba(255,120,120, 1)";
		form.nome.style.backgroundColor = "rgba(255,240,240, 0.7)";
		form.nome.style;
		console.log(form.nome);
		form.nome.focus();
	} else if (telefone === "") {
		form.telefone.style.border = "solid 1px rgba(255,120,120, 1)";
		form.telefone.style.backgroundColor = "rgba(255,240,240, 0.7)";
		form.telefone.focus();
	} else {
		document.forms["form-novo-contato"].submit();
	}
}