

//$(document).ready(function(){
//	loadAuth();
//});


// Source : https://www.w3schools.com/js/js_ajax_http_send.asp
function loadAuth() {
	document.getElementById("nodesContenu").innerHTML = "";
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("authContenu").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "authentification.html", true);
	  xhttp.send();
}

function loadNodes(){
	document.getElementById("authContenu").innerHTML = "";
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("nodesContenu").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "nodes.html", true);
	  xhttp.send();
}

// Btn : Submit Form Auth
/*$("#submitAuthForm").click(function() {

    // Get the text from the two inputs.
    var uname = $("#email").val();
    var pass = $("#pwd").val();

    // Ajax POST request.
    $.ajax({
        type: 'POST',
        url: './ServletAuth',
        data: {"email": email, "pwd": pwd},
        success: function( data ) {
            $( "#result" ).html( data );
        }
    });

});  */


