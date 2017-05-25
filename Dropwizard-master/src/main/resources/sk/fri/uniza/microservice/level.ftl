<html>
<style>
#div_psw {
  position: absolute;
  left: 50%;
  top: 50%;
  width: 450px;
  height: 200px;
  background-color: #3f6477;
  text-align: center;
  margin-left: -225px; /*half width*/
  margin-top: -100px; /*half height*/
  border-radius: 25px;
  /*border: 1px solid */
}


#div_logintext {
  width: 400px;
  height: 350px;
  margin: 0 auto;
  /* border: 1px solid ; */
  font-size: 32px;
  font-family: verdana, Geneva, Tahoma, sans-serif;
  margin-top: 55px;
  color: #FFFFFF;
  border-radius: 30px;
}


#div_top{
  width: 100%;
  height: 50px;
  background-color:#3f6477;
  position: fixed;
  top:0;
  left: 0;
} 
#div_bot{
  position: fixed;
  bottom: 0;
  width: 100%;
  height: 50px;
  background-color: #3f6477;
  left: 0;
}

</style>



  <head>
  <meta http-equiv="content-type" content="text/html; charset=utf-8">
  <title></title>
  </head>
  <body>
      <div id="div_top">
    </div>
    
     <div id="div_psw">
     
     
      <div id="div_logintext">
            ID:${level.id}
            <br>
            Hladina rieky: ${level.content} cm
      </div>
      
      
        
     </div>
     
     <div id="div_bot">
    </div>
    
  </body>
</html>


