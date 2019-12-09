function enterClicked() {
	// TODO
	// alert("Enter clicked!")
	var newLine = null;
	var span = null;
	var ul = null;
	var value = parseFloat(document.getElementById('input').value);
	newLine = document.createElement("li");
	newLine.setAttribute("class","list-group-item")
	newLine.setAttribute("value",value)

	span = document.createElement("span");
	span.setAttribute("class","badge")

	span.innerHTML = document.getElementsByClassName("list-group-item").length+1;
	newLine.innerHTML = value;
	ul = document.getElementById("stack");
	ul.appendChild(newLine);
	newLine.appendChild(span);
	document.getElementById('input').value='';
}

function add(){
	if(document.getElementsByClassName("list-group-item").length>1){
		var lastElement = document.getElementById('stack').lastElementChild;
		var lastElementValue = lastElement.value;
		document.getElementById('stack').removeChild(lastElement);

		lastElement = document.getElementById('stack').lastElementChild;
		lastElementValue += lastElement.value;
		document.getElementById('stack').removeChild(lastElement);

		var newLine = null;
		var span = null;
		var ul = null;
		newLine = document.createElement("li");
		newLine.setAttribute("class","list-group-item")
		newLine.setAttribute("value",lastElementValue)

		span = document.createElement("span");
		span.setAttribute("class","badge")

		span.innerHTML = document.getElementsByClassName("list-group-item").length+1;
		newLine.innerHTML = lastElementValue;
		ul = document.getElementById("stack");
		ul.appendChild(newLine);
		newLine.appendChild(span);
	}
}

function subtract(){
	if(document.getElementsByClassName("list-group-item").length>1){
		var lastElement = document.getElementById('stack').lastElementChild;
		var lastElementValue = lastElement.value;
		document.getElementById('stack').removeChild(lastElement);

		lastElement = document.getElementById('stack').lastElementChild;
		lastElementValue = lastElement.value - lastElementValue;
		document.getElementById('stack').removeChild(lastElement);

		var newLine = null;
		var span = null;
		var ul = null;
		newLine = document.createElement("li");
		newLine.setAttribute("class","list-group-item")
		newLine.setAttribute("value",lastElementValue)

		span = document.createElement("span");
		span.setAttribute("class","badge")

		span.innerHTML = document.getElementsByClassName("list-group-item").length+1;
		newLine.innerHTML = lastElementValue;
		ul = document.getElementById("stack");
		ul.appendChild(newLine);
		newLine.appendChild(span);
	}
}

function multiply(){
	if(document.getElementsByClassName("list-group-item").length>1){
		var lastElement = document.getElementById('stack').lastElementChild;
		var lastElementValue = lastElement.value;
		document.getElementById('stack').removeChild(lastElement);

		lastElement = document.getElementById('stack').lastElementChild;
		lastElementValue = lastElementValue * lastElement.value;
		document.getElementById('stack').removeChild(lastElement);

		var newLine = null;
		var span = null;
		var ul = null;
		newLine = document.createElement("li");
		newLine.setAttribute("class","list-group-item")
		newLine.setAttribute("value",lastElementValue)

		span = document.createElement("span");
		span.setAttribute("class","badge")

		span.innerHTML = document.getElementsByClassName("list-group-item").length+1;
		newLine.innerHTML = lastElementValue;
		ul = document.getElementById("stack");
		ul.appendChild(newLine);
		newLine.appendChild(span);
	}
}

function divide(){
	if(document.getElementsByClassName("list-group-item").length>1){
		var lastElement = document.getElementById('stack').lastElementChild;
		var lastElementValue = lastElement.value;
		document.getElementById('stack').removeChild(lastElement);

		lastElement = document.getElementById('stack').lastElementChild;
		lastElementValue = lastElement.value / lastElementValue;
		document.getElementById('stack').removeChild(lastElement);

		var newLine = null;
		var span = null;
		var ul = null;
		newLine = document.createElement("li");
		newLine.setAttribute("class","list-group-item")
		newLine.setAttribute("value",lastElementValue)

		span = document.createElement("span");
		span.setAttribute("class","badge")

		span.innerHTML = document.getElementsByClassName("list-group-item").length+1;
		newLine.innerHTML = lastElementValue;
		ul = document.getElementById("stack");
		ul.appendChild(newLine);
		newLine.appendChild(span);
	}
}