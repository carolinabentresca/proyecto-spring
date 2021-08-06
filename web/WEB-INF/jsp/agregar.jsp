<%-- 
    Document   : agregar
    Created on : 14/05/2021, 19:04:15
    Author     : EXO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </head>
    <body>
     <div class="container mt-4 col-lg-4">
      <div class="card border-info"> 
        <div class="card-header bg-info">
         <h1>Agregar Nuevo Registro</h1>
        </div>
        <div class="card-body">
        <form method="POST">
            <label>ID</label>
            <input type="text" name="id" placeholder="id" required="required" class="form-control" />
            <label>NOMBRE</label>
            <input type="text" name="nombre" placeholder="nombre" required="required" class="form-control" />
            <label>EMAIL</label>
            <input type="email" name="email" placeholder="email" required="required"  class="form-control"/>
            <br/>
            <input type="submit" value="Agregar" class="btn btn-warning"/>
            <br/>
            <br/> 
            <a href="index.htm" class="btn btn-warning">Regresar</a>
        </form>
       </div>
      </div>
     </div>
    </body>
</html>
