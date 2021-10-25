<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products and Categories</title>
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
              <a href="/products/new" class="nav-link">New Product</a>
            </li>
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
		<h1 class="text-center"><c:out value="${product.name}"/></h1>
		<div class="row">
		<div class="col">
			<h3>Categories:</h3>
			<ul>
			<c:forEach items="${categories_product}" var="category">
					<li><c:out value="${category.name}"/></li>
			</c:forEach>
			</ul>
		</div>
		<div class="col">
				<form action="/products/${product.id}/addCategory" method="post" class="col">
				   	 <div class="form-group my-2">
				        <label for="category_id" class="form-label">Category</label>
				    </div>
			        <select name="category_id">
					    <c:forEach var="category" items="${categories_all}" >
					        <option value="${category.id}" label="${category.name}"/>
					    </c:forEach>
					</select>
					
					<input class="btn btn-primary text-center my-2" type="submit" value="Add"/>
				</form>
		</div>
		</div>
	</div>
</section>  



</body>
</html>