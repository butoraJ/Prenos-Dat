
<html>
<style>
html { 
  background: url(https://theappsolutions.com/images/articles/105/SmartHome.jpg) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
#div_psw {
 
  position: absolute;
  left: 50%;
  top: 50%;
  width: 300px;
  height: 350px;
  background-color: rgb(255,255,255);
  text-align: center;
  margin-left: -150px; /*half width*/
  margin-top: -175px; /*half height*/
  border-radius: 25px;
}
#div_logintext {
  width: 300px;
  height: 50px;
  margin: 0 auto;
  /* border: 1px solid ; */
  font-size: 30px;
  font-family: verdana, Geneva, Tahoma, sans-serif;
  margin-top: 30px;
}
#div_logintextfield {
  width: 300px;
  height: 200px;
  margin: 0 auto;
  /* border: 1px solid ; */
  font-size: 24px;
  font-family: verdana, Geneva, Tahoma, sans-serif;
  margin-top: 15px;
}
</style>

  <head>
  <meta http-equiv="content-type" content="text/html; charset=utf-8">
  <title></title>
  </head>
  <body>
     <div id="div_psw">
      <div id="div_logintext">
             Login
      </div>
      <div id="div_logintextfield">
      
      

        
        <form method="post" action="http://localhost:8080/user/login">
            <div  style="margin-top: 2px;">
                Meno: <br>
            	<input type="text" name="name" required  style="width: 60%"> 
                <br>
                Heslo: <br>
                <input type="password" name="psw" required  style="width: 60%"> 
            	<br>
                <br>
                <input type="submit" value="Prihlásiť sa" style="width: 60%; margin-right: 2%; height:30px; border-radius: 15px">
            </div>
	</form>
        
        <form method="get" action="http://localhost:8080/login/sign">
                <input type="submit" value="Zaregistruj sa" style="width: 60%; margin-right: 2%; height:30px; border-radius: 15px">
	</form>
        
        
        
      </div>
     </div>
  </body>
</html>
