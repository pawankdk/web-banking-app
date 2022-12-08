<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!--This tag is used for using spring mvc form tags-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html lang ="en">
    <head>
        
        <!--All required meta tags-->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        
        <!--Title logo-->
        <link rel="shortcut icon" href="https://cdn.dribbble.com/users/5976/screenshots/2097186/open-uri20150608-11-mq4tbp">

        <!--Title Name-->
        <title>Core Banking System : Edit Account Details</title>
        
        <!-- All styles -->
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.Js, then Bootstrap JS -->
        
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
    
        
        
        <!--Css Code for dashboard-->
        <style>
            
            body 
            {
                margin-top: 50px;
            }
            
            html, body, #wrapper, #page-wrapper {height: 100%; overflow: hidden;}
            #wrapper 
            {
                padding-left: 0;    
            }
            #page-wrapper 
            {
                width: 100%;        
                padding: 0;
                background-color: #fff;
            }
            @media(min-width:768px) 
            {
                #wrapper 
                
                {
                    padding-left: 225px;
                }
                #page-wrapper 
                {
                    padding: 22px 10px;
                }
            }
            
            /* Top Navigation */
            .top-nav 
            {
                padding: 0 15px;
            }
            .top-nav>li 
            {
                display: inline-block;
                float: left;
            }
            .top-nav>li>a 
            {
                padding-top: 20px;
                padding-bottom: 20px;
                line-height: 20px;
                color: #fff;
            }
            .top-nav>li>a:hover,
            .top-nav>li>a:focus,
            .top-nav>.open>a,
            .top-nav>.open>a:hover,
            .top-nav>.open>a:focus 
            {
                color: #fff;
                background-color: #1a242f;
            }
            .top-nav>.open>.dropdown-menu 
            {
                float: left;
                position: absolute;
                margin-top: 0;
                
                border: 1px solid rgba(0,0,0,.15);
                border-top-left-radius: 0;
                border-top-right-radius: 0;
                background-color: #fff;
                -webkit-box-shadow: 0 6px 12px rgba(0,0,0,.175);
                box-shadow: 0 6px 12px rgba(0,0,0,.175);
            }
            .top-nav>.open>.dropdown-menu>li>a 
            {
                white-space: normal;
            }
            
            /* Side Navigation */
            @media(min-width:768px) 
            {
                .side-nav {
                    position: fixed;
                    top: 60px;
                    left: 225px;
                    width: 225px;
                    margin-left: -225px;
                    border: none;
                    border-radius: 0;
                    border-top: 1px rgba(0,0,0,.5) solid;
                    overflow-y: auto;
                    background-color: #222;
                    
                    /*background-color: #5A6B7D;*/
                    bottom: 0;
                    overflow-x: hidden;
                    padding-bottom: 40px;
                }
                .side-nav>li>a 
                {
                    width: 225px;
                    border-bottom: 1px rgba(0,0,0,.3) solid;
                }
                .side-nav li a:hover,
                .side-nav li a:focus 
                {
                    outline: none;
                    background-color: #1a242f !important;
                }
            }
            .side-nav>li>ul 
            {
                padding: 0;
                border-bottom: 1px rgba(0,0,0,.3) solid;
            }
            .side-nav>li>ul>li>a 
            {
                display: block;
                padding: 10px 15px 10px 38px;
                text-decoration: none;
                
                /*color: #999;*/
                color: #fff;    
            }
            .side-nav>li>ul>li>a:hover 
            {
                color: #fff;
            }
            .navbar .nav > li > a > .label 
            {
              -webkit-border-radius: 50%;
              -moz-border-radius: 50%;
              border-radius: 50%;
              position: absolute;
              top: 14px;
              right: 6px;
              font-size: 10px;
              font-weight: normal;
              min-width: 15px;
              min-height: 15px;
              line-height: 1.0em;
              text-align: center;
              padding: 2px;
            }
            .navbar .nav > li > a:hover > .label 
            {
              top: 10px;
            }
            .navbar-brand 
            {
                padding: 5px 15px;
                width: 50px;
            }
            .navbar-brand>img
            {
                width: 50px;
            }
            
            /*To make side display fixed in a position all different for each and every design*/
            .well
            {
                top: -40px;
                height: 645px;
            }
            
            /*Form css part*/
            .container-fluid
            {
                background-color:rgba(255, 255, 255,0.2);
                margin-top: 45px;
                color: #000;
                font-weight: bold;
            }
/*            .form-withdraw
            {
                padding: 20px 30px;
            }*/
            
        </style>
        
        <!--JavaScript code for this dashboard page-->
        <script>
            
            $(function()
            {
                $('[data-toggle="tooltip"]').tooltip();
                $(".side-nav .collapse").on("hide.bs.collapse", function() 
                {                   
                    $(this).prev().find(".fa").eq(1).removeClass("fa-angle-right").addClass("fa-angle-down");
                });
                $('.side-nav .collapse').on("show.bs.collapse", function() 
                {                        
                    $(this).prev().find(".fa").eq(1).removeClass("fa-angle-down").addClass("fa-angle-right");        
                });
            });
            
        </script>
        
    </head>
    <body>
        
        <div id="throbber" style="display:none; min-height: 120px;"></div>
        <div id="noty-holder"></div>
        <div id="wrapper">
            
            <!--Navigation-->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                
                 <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    
                    <!--Logo part-->
                    <a class="navbar-brand" href="#">
                        <img src="https://cdn.dribbble.com/users/5976/screenshots/2097186/open-uri20150608-11-mq4tbp" alt="LOGO">
                    </a>
                </div>
                 
                <!-- Top Menu Items -->
                <ul class="nav navbar-right top-nav">
                    <li><a href="#" data-placement="bottom" data-toggle="tooltip" href="#" data-original-title="Stats"><i class="fa fa-bar-chart-o"></i>
                        </a>
                    </li>            
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessionScope.username}<b class="fa fa-angle-down"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="editprofile"><i class="fa fa-fw fa-user"></i> Edit Profile</a></li>
                            <li><a href="changepassword"><i class="fa fa-fw fa-cog"></i> Change Password</a></li>
                            <li class="divider"></li>
                            <li><a href="logout"><i class="fa fa-fw fa-power-off"></i> Logout</a></li>
                        </ul>
                    </li>
                </ul>
                        
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li>
                            <a href="createnewaccount"><i class="fa fa-fw fa-user-plus"></i>  Open New Account</a>
                        </li>
                        <li>
                            <a href="deleteaccount"><i class="fa fa-fw fa-paper-plane-o"></i> Close Account</a>
                        </li>
                        <li>
                            <a href="withdraw"><i class="fa fa-fw fa fa-question-circle"></i> Withdraw</a>
                        </li>
                        <li>
                            <a href="deposit"><i class="fa fa-fw fa fa-question-circle"></i> Deposit</a>
                        </li>
                        <li>
                            <a href="fundtransfer"><i class="fa fa-fw fa fa-question-circle"></i> Fund Transfer</a>
                        </li>
                        <li>
                            <a href="searchbyname"><i class="fa fa-fw fa fa-question-circle"></i> Search By Name</a>
                        </li>
                        <li>
                            <a href="listallaccounts"><i class="fa fa-fw fa fa-question-circle"></i> List All Accounts</a>
                        </li>
                    </ul>
                </div>
            </nav> 
               <!--Side dashboard which display other functions layout-->
            <div id="page-wrapper">
                <div class="container-fluid">
                    
                    <div class="row" id="main" >
                        <div class="col-sm-12 col-md-12 well" id="content">
                            
                            <!--Deposit form--> 
                            
                            <div class="container-fluid" style="  width: 40%;">
                            <h2 class="title text-center">EDIT ACCOUNT DETAILS</h2>
                            <h3 class="title text-center">Please edit Account details.</h3>
                            <br>

                                <!--Making form is started from here-->
                               <form:form class="form-editaccount" method="POST" modelAttribute="editaccountdetails" action="editAccountProcess">
                                  <div class="form-label-group">
                                    <label for="accNo">Account Number</label>
                                    <form:input type="text" id="accNo" path="accNo" name="accNo" class="form-control" readonly="true" value='<%= request.getParameter("accNo")%>' placeholder="Account Number" minlength="1" required="required"/>
                                  </div>
                                  
                                  <div class="form-label-group">
                                    <label for="name">Account Name</label>
                                    <form:input type="text" id="name" class="form-control" path="name" name="name" value='<%= request.getParameter("name")%>' placeholder="Account Name" minlength="1" required="required"/>
                                  </div>
                                  
                                  <div class="form-label-group">
                                    <label for="address">Address</label>
                                    <form:input type="text" id="address" class="form-control" path="address" name="address" value='<%= request.getParameter("address")%>' placeholder="Address" minlength="1" required="required"/>
                                  </div>
                                  
                                  <div class="form-label-group">
                                    <label for="amount">Amount</label>
                                    <form:input type="text" id="amount" class="form-control" path="amount" name="amount" value='<%= request.getParameter("amount")%>' readonly="true" placeholder="Ammount" minlength="1" required="required"/>
                                  </div>
                                  
                                  <br>
                                  <div class="form-label-group">
                                    <label for="accType">Account Type</label>
                                    <form:input type="text" id="accType" class="form-control" path="accType" name="accType" value='<%= request.getParameter("accType")%>' readonly="true"/>
                                  </div>
                                  
                                  <hr style="border-color: #000; ">
                                  <br>
                                  <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Update Account</button>

                               </form:form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>