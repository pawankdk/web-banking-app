<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!--This tag is used for using spring mvc form tags-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <!-- Required meta tags -->
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.Js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://use.fontawesome.com/bac272c58a.js"></script>
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

    <!--Title logo-->
    <link rel="shortcut icon" href="https://cdn.dribbble.com/users/5976/screenshots/2097186/open-uri20150608-11-mq4tbp">
    
    <!--Title Name-->
    <title>Core Banking System : Edit User</title>
    
    <!--CSS code for this login Form-->
    <style>
        body
        {
            background: url(https://i.pinimg.com/474x/55/29/61/552961a23a049125e9cd2ca90d1c9825.jpg);
        }
        .container-fluid
        {
            background-color:rgba(255, 255, 255,0.2);
            margin-top: 100px;
            color: #fff;
            font-weight: bold;
        }
        .form-signin
        {
            padding: 20px 30px;
        }
        .pass-type
        {
            color: red;
            font-size: x-small;
            font-weight: bold;
        }

    </style>

</head>
<body>
    
    <div class="container-fluid" style="  width: 40%;">
        <h2 class="title text-center">Edit User</h2>
        <h3 class="title text-center">Please Edit user.</h3>
            <!--Making form is started from here-->
            <form:form class="form-editUser" method="POST" modelAttribute="editprofile" action="editUserProcess">
                <div class="form-label-group">
                <label for="uname">User Id</label>
                <form:input type="text" id="uid" path="uid" name="uid" class="form-control" value="${sessionScope.userid}" readonly="true" placeholder="User Id" minlength="1" required="required"/>
              </div>
              <div class="form-label-group">
                <label for="uname">User Name</label>
                <form:input type="text" id="uname" path="uname" name="uname" class="form-control" value="${sessionScope.username}" placeholder="User Name" minlength="1" required="required"/>
              </div>

              <div class="form-label-group">
                <label for="upassword">Password</label>
                <form:input type="password" id="upassword" class="form-control" path="upassword" value="${sessionScope.userpassword}" name="upassword" readonly="true" placeholder="Password" minlength="8" maxlength="14" required="required"/>
              </div>
                
              <div class="pass-type">
                <label> </label>
              </div>   
                
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Update User </button>
              
              <hr style="border-color: #fff; ">
            </form:form>
</div>
</body>
</html>

