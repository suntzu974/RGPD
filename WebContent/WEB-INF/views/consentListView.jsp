<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="_style.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<div class="container">
  		<h2>Liste des consentements </h2>
  		<p style="color: red;">${errorString}</p>            
  		<table id="listConsents" class="table">
    		<thead>
      			<tr>
				  	<th>Entreprise</th>
  					<th>Siret</th>
  					<th>Adresse</th>
  					<th>Acceptation</th>
  					<th>Signature</th>      			
       			</tr>
    		</thead>
    		<c:forEach items="${consentList}" var="consent" >
          		<tr>
          			<td>
	       				<c:if test="${consent.getCustomer().getName() != null }">
    	         			${consent.getCustomer().getName()}
						</c:if>
       					<c:if test="${consent.getCustomer().getName() == null }">
						      <p style="color:Tomato;"> CR&eacuteATION EN COURS </p>
						</c:if>
					</td>
             		<td>${consent.getSiret()}</td>
             		<td>
	       				<c:if test="${consent.getCustomer().getName() != null }">
      					<address>
					        ${ consent.getCustomer().getStreet() }<br>
        					${ consent.getCustomer().getAddress()}<br>
        					${ consent.getCustomer().getPostcod()},${consent.getCustomer().getTown()}<br>
      					</address>
						</c:if>
    				</td>
    			    <td>
        			<ul>
          				<li>
            				Conditions g&eacuten&eacuterales d'utilsations
            				<c:if test="${consent.getUsingGeneralConditions() == true}">
              						<b style="color:MediumSeaGreen;">Oui</b>
							</c:if>
            				<c:if test="${consent.getUsingGeneralConditions() == false}">
	              					<b style="color:Tomato;">Non</b>
							</c:if>
          				</li>
          				<li>
             				Newsletters
            				<c:if test="${consent.getNewsletters() == true}">
              						<b style="color:MediumSeaGreen;">Oui</b>
							</c:if>
            				<c:if test="${consent.getNewsletters() == false}">
	              					<b style="color:Tomato;">Non</b>
							</c:if>
          				</li>
          				<li>
             				Offres commerciales par E-mail
            				<c:if test="${consent.getCommercialOffersByMail() == true}">
              						<b style="color:MediumSeaGreen;">Oui</b>
							</c:if>
            				<c:if test="${consent.getCommercialOffersByMail() == false}">
	              					<b style="color:Tomato;">Non</b>
							</c:if>
          				</li>
          				<li>
             				Offres commerciales par SMS
            				<c:if test="${consent.getCommercialOffersBySms() == true}">
              						<b style="color:MediumSeaGreen;">Oui</b>
							</c:if>
            				<c:if test="${consent.getCommercialOffersBySms() == false}">
	              					<b style="color:Tomato;">Non</b>
							</c:if>
             				
          				</li>
          				<li>
             				Offres commerciales par courier postal
            				<c:if test="${consent.getCommercialOffersByPost() == true}">
              						<b style="color:MediumSeaGreen;">Oui</b>
							</c:if>
            				<c:if test="${consent.getCommercialOffersByPost() == false}">
	              					<b style="color:Tomato;">Non</b>
							</c:if>
          				</li>
        			</ul>
    				</td>
    				<td><img src="data:image/jpg;base64,${consent.getSignature()}" width=75 height=75></td>    				
          		</tr>
       		</c:forEach>
  		</table>
	</div>	
     <jsp:include page="_footer.jsp"></jsp:include>
     <script>
function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("listConsents");
  switching = true;
  //Set the sorting direction to ascending:
  dir = "asc"; 
  /*Make a loop that will continue until
  no switching has been done:*/
  while (switching) {
    //start by saying: no switching is done:
    switching = false;
    rows = table.getElementsByTagName("TR");
    /*Loop through all table rows (except the
    first, which contains table headers):*/
    for (i = 1; i < (rows.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /*Get the two elements you want to compare,
      one from current row and one from the next:*/
      x = rows[i].getElementsByTagName("TD")[n];
      y = rows[i + 1].getElementsByTagName("TD")[n];
      /*check if the two rows should switch place,
      based on the direction, asc or desc:*/
      if (dir == "asc") {
        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
          //if so, mark as a switch and break the loop:
          shouldSwitch= true;
          break;
        }
      } else if (dir == "desc") {
        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
          //if so, mark as a switch and break the loop:
          shouldSwitch = true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /*If a switch has been marked, make the switch
      and mark that a switch has been done:*/
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      //Each time a switch is done, increase this count by 1:
      switchcount ++;      
    } else {
      /*If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again.*/
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
</script>
</body>
</html>