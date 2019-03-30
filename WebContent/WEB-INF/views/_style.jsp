<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <meta charset="UTF-8">
  	<!-- Theme Made By www.w3schools.com - No Copyright -->
  	<title>RAV-X3 APACHE TOMCAT Server</title>
  	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  	<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	<style>
  	body {font-family: Arial, Helvetica, sans-serif;}
	form {border: 3px solid #f1f1f1;}
	
	form.product input[type=text] {
    	padding: 10px;
    	font-size: 17px;
    	border: 1px solid grey;
    	float: left;
    	width: 80%;
    	background: #f1f1f1;
	}

	form.product button {
    	float: left;
    	width: 20%;
    	padding: 10px;
    	background: #2196F3;
    	color: white;
    	font-size: 17px;
    	border: 1px solid grey;
    	border-left: none;
    	cursor: pointer;
	}

	form.product button:hover {
    	background: #0b7dda;
	}

	form.product::after {
    	content: "";
    	clear: both;
    	display: table;
	}
 	
 	h2 {
    	font-size: 24px;
      	text-transform: uppercase;
      	color: #303030;
      	font-weight: 600;
      	margin-bottom: 30px;
  	}
  	h4 {
    	font-size: 19px;
      	line-height: 1.375em;
      	color: #303030;
      	font-weight: 400;
      	margin-bottom: 30px;
  	}
  	.navbar {
    overflow: hidden;
    background-color: #333;
    font-family: Arial, Helvetica, sans-serif;
}

.navbar a {
    float: left;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.dropdown {
    float: left;
    overflow: hidden;
}

.dropdown .dropbtn {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
    font-family: inherit;
    margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {
    background-color: #ddd;
}

.dropdown:hover .dropdown-content {
    display: block;
}  
  table {
    	border-spacing: 0;
 		border: 1px solid black;
    	width: 100%;
    	border: 1px solid #ddd;
	}

	th {
    	cursor: pointer;
	}

	th, td {
    	text-align: left;
    	padding: 16px;
	}

	tr:nth-child(even) {
    	background-color: #f2f2f2
	}
	input[type=text], input[type=password] {
    	width: 100%;
    	padding: 12px 20px;
    	margin: 8px 0;
    	display: inline-block;
    	border: 1px solid #ccc;
    	box-sizing: border-box;
	}

	button {
    	background-color: #4CAF50;
    	color: white;
    	padding: 14px 20px;
    	margin: 8px 0;
   	 	border: none;
    	cursor: pointer;
    	width: 100%;
	}

	button:hover {
    	opacity: 0.8;
	}

	.cancelbtn {
    	width: auto;
    	padding: 10px 18px;
    	background-color: #f44336;
	}


	.container {
    	padding: 16px;
	}	

	span.psw {
    	float: right;
    	padding-top: 16px;
	}


/* Change styles for span and cancel button on extra small screens */

  @keyframes slide {
    0% {
      opacity: 0;
      transform: translateY(70%);
    } 
    100% {
      opacity: 1;
      transform: translateY(0%);
    }
  }
  @-webkit-keyframes slide {
    0% {
      opacity: 0;
      -webkit-transform: translateY(70%);
    } 
    100% {
      opacity: 1;
      -webkit-transform: translateY(0%);
    }
  }
  @media screen and (max-width: 768px) {
    .col-sm-4 {
      text-align: center;
      margin: 25px 0;
    }
    .btn-lg {
        width: 100%;
        margin-bottom: 35px;
    }
  }
  @media screen and (max-width: 480px) {
    .logo {
        font-size: 150px;
    }
  }
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}

  </style>
