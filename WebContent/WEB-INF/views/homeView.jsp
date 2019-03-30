<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
  <head>
  <jsp:include page="_style.jsp"></jsp:include>
  </head>
  <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
     <jsp:include page="_header.jsp"></jsp:include>
      <h3><%= new Date() %> </h3>
      <p style="color: red;">${downloaded}</p>            
		<!-- #######  YAY, I AM THE SOURCE EDITOR! #########-->
		<h2 style="color: #2e6c80;">Mode d'emploi :</h2>
		<p>le lien ci-dessous vous permet de t&eacute;l&eacute;charger le stock de SOFAREM et de HOMETECH.</p>
		<p>Une fois le t&eacute;l&eacute;chargement r&eacute;alis&eacute; , selon le navigateur , il vous sera permit de l'ouvrir directeement via Excel ou il sera enregistré sur votre espace.&nbsp;</p>
		<h2 style="color: #2e6c80;">Les liens &agrave; votre disposition :</h2>
		<p>&nbsp;</p>
		<ol style="list-style: none; font-size: 14px; line-height: 32px; font-weight: bold;">
			<li style="clear: both;">
				<p><strong><a title="Stock SOFAREM &amp; HOMETECH" 
				href="${pageContext.request.contextPath}/sofarem">Etat de stock de SOFAREM &amp; HOMETECH</a>&nbsp;</strong></p>  
  			</li>
		</ol>           
  </body>
</html>