function cost() {
	var itemname = document.getElementById("itemname").value;
	var yes = document.getElementById("yes").checked;
	var no = document.getElementById("no").checked;
	var a = 0;
	if (itemname.length <= 0) {
		alert("please enter valid name");
		document.getElementById("demo1").style.color = "red";
		a = 1;
	}
	if ((yes == false) && (no == false)) {
		alert("please click active option");
		document.getElementById("demo2").style.color = "red";
		a = 1;
	}
	/*if (a == 0)
		confirm("If you click ok item saved to the menu item successfully");*/

}