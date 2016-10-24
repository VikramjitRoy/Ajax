<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX JsonArray Example</title>
<link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
<style type="text/css">
table, td, th
{
border:1px solid green;
font-family: 'Oxygen', sans-serif;
}
th
{
background-color:green;
color:white;
}
body
{
	text-align: center;
}
.container
{
	margin-left: auto;
	margin-right: auto;
	width: 40em;
}
h4
{
	font-family: 'Oxygen', sans-serif;
	color:#1E90FF;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#tablediv").hide();
     $("#showTable").click(function(event){
    	 
           $.get('PopulateTable',function(responseJson) {
        	   
        	   if(responseJson!=null){
            	   $("#countrytable").find("tr:gt(0)").remove();
            	   var table1 = $("#countrytable");
            	   console.log(responseJson);
	               $.each(responseJson, function(key,value) { 
	               		   var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
	                       rowNew.children().eq(0).text(value['CustomerName']); 
	                       rowNew.children().eq(1).text(value['ContactName']); 
	                       rowNew.children().eq(2).text(value['Address']); 
	                       rowNew.children().eq(3).text(value['City']); 
	                       rowNew.children().eq(4).text(value['PostalCode']); 
	                       rowNew.children().eq(5).text(value['Country']); 
	                       rowNew.appendTo(table1);
	               });
                }
            });
            $("#tablediv").toggle();          
	 });      
});
</script>
</head>
<body class="container">

<input type="button" value="Show Table" id="showTable"/>
<br/>
<br/>
<div id="tablediv">
<table cellspacing="0" id="countrytable"> 
    <tr> 
       	<th scope="col">Postal Code</th>
        <th scope="col">Address</th>
        <th scope="col">Customer Name</th>
        <th scope="col">Customer Name</th> 
        <th scope="col">City</th> 
         
        <th scope="col">Country</th>          
    </tr> 
</table>
</div>
</body>
</html>