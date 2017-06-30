<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cost Form</title>
<script src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#txtNumItems").on("blur", function() {
		$.post("CostServlet", $("#frmCost").serialize(), function(data) {
			$("#divResult").html("$" + data);
		});
	})
});

</script>
</head>
<body>

<form id="frmCost" method="post" action="CostServlet">
	Number of Items: <input id="txtNumItems" type="text" name="numItems"/><br/>
	<input type="submit" value="Calculate Cost"/>
</form>
<div id="divResult">
</div>

</body>
</html>