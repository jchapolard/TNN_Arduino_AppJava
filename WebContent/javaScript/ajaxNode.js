
//Récupération des Données des nodes

$(document).ready(function(){
	
//});
//$(document).on("click", "#somebutton", function() {			          // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
	var i = 1;
	var timeInterval = 10000;
	getData();
	ajouteLigne();
	setInterval(function(){
		i++
//		$("#somediv").text(i);
		ajouteLigne();
		getData();
	}, timeInterval);
});

function getData(){
	$.get("servletNodes", function(responseJson) {              // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
        var $select = $("#someselect");                           // Locate HTML DOM element with ID "someselect".
        $select.find("option").remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
        $.each(responseJson, function(key, value) {               // Iterate over the JSON object.
            $("<option>").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
        });
    });
}

function ajouteLigne() {
	$.get("servletNodes", function(responseJson) {              // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
        var $table = $("#TableA");
        var tableA = document.getElementById("TableA");
        var i = 0;
        var j = 1;
        
        $table.find("THEAD").remove();
        $table.find("th").remove();    
        $table.find("tr").remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
        $table.find("td").remove();

        // TD Head
        var thead = document.createElement("THEAD");
        var trHead = document.createElement("TR");
        var thHead = document.createElement("TH");
        var title = ["Number", "id", "Name", "Value", "Last Up Date", "Total hours"];
        var i;
        for(i = 0;i<title.length;i++){
        	var thName = "myTh"+ i;
        	var thHead = document.createElement("TH");
        	thHead.innerHTML = title[i];
        	trHead.appendChild(thHead);
        	thead.appendChild(trHead);
    		if(tableA != null) tableA.appendChild(thead);
        }
        
        
        $.each(responseJson, function(key, value) {               // Iterate over the JSON object.
        	
//        	console.log("1key " + key + " has value " + value);
        	i++;
            var trName = "myTr"+ i;
                       
        	var tr = document.createElement("TR");
        	tr.setAttribute("id", trName);
        	var tBody = document.createElement("TBODY");
      	    tBody.appendChild(tr);
      	    if(tableA != null) tableA.appendChild(tBody);
      	    
      	    // Td : Number
      	    var tdNumber = document.createElement("TD");
      	    tdNumber.innerHTML = j;
			var docTdNumber = document.getElementById(trName);
			if(docTdNumber != null) docTdNumber.appendChild(tdNumber);
      	    
      	    // Td : id
      	    var tdId = document.createElement("TD");
			var id = document.createTextNode(key);
			tdId.appendChild(id);
			var docTrName = document.getElementById(trName);
			if(docTrName != null) docTrName.appendChild(tdId);
    		
			var name;
			var valeur;
			var time;
			var totalTime; // Temporaire
    		JSON.parse(value, (key1, value1) => {
    		
//        		console.log("2key " + key1 + " has value " + value1); // 2key 0 has value {"name":"Frigo","id":2,"status":"on"}
        		if(key1 === "dev_id" || key1 === "name"){
        			//console.log("3key " + key + " has value " + value1);
            		name = document.createTextNode(value1);
        		}
        		if(key1 === "vibration" || key1 === "status"){
//        			console.log("4key " + key1 + " has value " + value1);
            		valeur = document.createTextNode(value1);
        		}
        		if(key1 === "time") {
        			time = document.createTextNode(value1);
        		}
        	});
    		
    		j++;
    		// Td : Name
    		var tdName = document.createElement("TD");
    		tdName.appendChild(name);
    		var docTdName = document.getElementById(trName);
    		if(docTdName != null) docTdName.appendChild(tdName);
    		
    		// Td : Value
    		var tdValeur = document.createElement("TD");
    		tdValeur.appendChild(valeur);
    		var docTdValeur = document.getElementById(trName);
    		if(docTdValeur != null) docTdValeur.appendChild(tdValeur);
    		
    		// Td : Date
    		var tdDate = document.createElement("TD");
    		/*var a = new Date();
    		var year = a.getFullYear();
            var month = ("0" + (a.getMonth() + 1)).slice(-2); 
            var day = ("0" + a.getDate()).slice(-2); 
            var hour = ("0" + a.getHours()).slice(-2);
            var minute = ("0" + a.getMinutes()).slice(-2);
            var second = ("0" + a.getSeconds()).slice(-2);
    		var strDate = year+""+month+""+day + " " + hour	+":"+ minute +":"+ second;
    		
    		var date = document.createTextNode(strDate);
    		tdDate.appendChild(date); */
    		tdDate.appendChild(time);
    		var docDate = document.getElementById(trName);
    		if(docDate != null) docDate.appendChild(tdDate);
    		 
    		// Td Total Hours
    		totalTime = document.createTextNode("---");
    		var tdTotalHour = document.createElement("TD");
    		//var strTotalHour = hour	+":"+ minute +":"+ second;
    		//var tdTotalHour = document.createTextNode(strTotalHour);
    		//tdTotalHour.appendChild(totalHour);
    		tdTotalHour.appendChild(totalTime);
    		var docTotalHour = document.getElementById(trName);
    		if(docTotalHour != null) docTotalHour.appendChild(tdTotalHour);
        });
    });
	
}
