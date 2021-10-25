<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Student</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

    <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 fixed-top">
      <div class="container">
        <a href="#" class="navbar-brand">Products and Categories</a>

        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navmenu"
        >
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navmenu">
          <ul class="navbar-nav ms-auto">
            <li class="nav-item">
              <a href="/categories/new" class="nav-link">New Category</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <section class="py-5"></section>
<section>
	<div class="container">
		<div class="col-lg-6 offset-lg-3">
			<h1>New Product</h1>
			<form:form action="/products" method="post" modelAttribute="product" class="col">
			    <div class="form-group my-2">
			        <form:label path="name" class="form-label">Name</form:label>
			    </div>
			    <div class="form-group my-2">    
			        <form:errors path="name"/>
			        <form:input path="name" class="form-control"/>
			    </div>
			    <div class="form-group my-2">
			        <form:label path="description" class="form-label">Description</form:label>
			    </div>
			    
			    <div class="form-group my-2">
			        <form:errors path="description"/>
			        <form:input path="description" class="form-control"/>
			    </div>
			    
			    <div class="form-group my-2">
			        <form:label path="price" class="form-label">Price</form:label>
			    </div>
			    
			    <div class="form-group my-2">
			        <form:errors path="price"/>
			        <form:input path="price" class="form-control"/>
			    </div>
			    
			    <div class="text-center">    
			    	<input class="btn btn-primary text-center my-2" type="submit" value="Create"/>
			    </div>
			</form:form>
		</div>	
	</div>
</section>
</body>
</html>