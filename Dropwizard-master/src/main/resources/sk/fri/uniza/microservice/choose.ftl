<html>
  <style>
    /* CSS Document */
body {
  /* pozadie */
  background-color: #ffffff;
}
#div_back {
  position: absolute;
  background-color: #ffffff;
  left: 50%;
  top: 50%;
  width: 900px;
  height: 600px;
  margin-left: -450px; /*half width*/
  margin-top: -300px; /*half height*/
}
#div_top{
  width: 100%;
  height: 50px;
  background-color:#3f6477;
  position: fixed;
  top:0;
  left: 0;
} 
#div_bot {
  position: fixed;
  bottom: 0;
  width: 100%;
  height: 50px;
  background-color: #3f6477;
  left: 0;
}
#div_btn {
  background-color: #ef8555;
  width: 400px;
  height: 60px;
  margin: 0 auto;
  margin-top: 35px;
  text-align: center;
  vertical-align: middle;
  line-height: 60px;
   border-radius: 30px;
   font-family: verdana, Geneva, Tahoma, sans-serif;
   font-size: 25px;
   transition-duration: 0.4s;
}

#div_btn:hover {
    background-color: #3f6477;
}
a {
    text-decoration: none;
}
a:link {
    color: #FFFFFF;
}
a:visited {
    color: #FFFFFF;
}
a:hover {
    color: #ef8555;
}

  </style>
  <head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <meta name="generator" content="PSPad editor, www.pspad.com">
  <title></title>
  </head>
  <body>
    <div id="div_top">
     
    </div>
    <div id="div_back">

      <a href="http://localhost:8080/control/temp">
      <div id="div_btn" style="margin-top: 130px">
        Teploty
      </div>
      </a>

      <a href="http://localhost:8080/control/pressure">
      <div id="div_btn">
        Tlak
      </div>
        </a>

        
       <a href="http://localhost:8080/control/level">
      <div id="div_btn">
        Výška hladiny
      </div>
      </a>

      
       <a href="http://localhost:8080/user">
      <div id="div_btn">
        Všetci užívatelia
      </div>
      </a>
    </div>

    <div id="div_bot">
     
    </div>
  </body>
</html>
