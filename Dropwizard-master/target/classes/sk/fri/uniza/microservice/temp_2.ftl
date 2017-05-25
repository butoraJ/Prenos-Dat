
<html>
<style>
#div_psw {
  position: absolute;
  left: 50%;
  top: 50%;
  width: 400px;
  height: 600px;
  background-color: #3f6477;
  text-align: center;
  margin-left: -200px; /*half width*/
  margin-top: -300px; /*half height*/
  border-radius: 25px;
  /*border: 1px solid */
}
#div_logintext {
  width: 300px;
  height: 50px;
  margin: 0 auto;
  /* border: 1px solid ; */
  font-size: 32px;
  font-family: verdana, Geneva, Tahoma, sans-serif;
  margin-top: 30px;
  margin-bottom: 15px;
  color: #FFFFFF;
}
#div_centrovany {
  font-size: 16px;
  font-family: verdana, Geneva, Tahoma, sans-serif;
  margin-top: 10px;
  color: #CCFFFF;
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

<script>
        function myFunction() {
            var str1 = "http://localhost:8080/temp/";
            var str2 = document.getElementById("userInput").value;
            var res = str1.concat(str2);
            if(str2!=""){
                window.location.href=res;
            }
        }
        function myFunction2() {
            var str1 = "http://localhost:8080/temp/";
            window.location.href=str1;
        }
        function myFunction3() {
            var str1 = "http://localhost:8080/temp/delete/";
            var str2 = document.getElementById("userDelete").value;
            var res = str1.concat(str2);
            if(str2!=""){
                window.location.href=res;
            }
        }
        function myFunction4() {
            var str1 = "http://localhost:8080/temp/delete/";
            window.location.href=str1;
        }
    </script>

  <head>
  <meta http-equiv="content-type" content="text/html; charset=utf-8">
  <title></title>
  </head>
  <body>
      <div id="div_top">
    </div>
    
     <div id="div_psw">
      <div id="div_logintext">
             Teplota
      </div>
      
        
        <div id="div_centrovany" style="margin-top: 5px;">
            Zadaj id teploty, ktorú chceš vypísať
        </div>
        
        <div id="div_centrovany">
            <input type="text" id="userInput" required>
            <button onclick="myFunction()" >Zobraz</button>
        </div>
        <br>

        <div id="div_centrovany" style="margin-top: 5px;">
            Zobraz všetky teploty
        </div>
        <div id="div_centrovany">
            <button onclick="myFunction2()"  >Zobraz</button> 
        </div>
        <br>

        <div id="div_centrovany" style="margin-top: 5px;">
            Zadaj id teploty, ktorú chcete vymazať
        </div>
        <div id="div_centrovany">
            <input type="text" id="userDelete" required>
            <button onclick="myFunction3()">Vymaž</button> 
        </div>
        <br>

        <div id="div_centrovany" style="margin-top: 5px;">
            Vymazať vsetky teploty
        </div>
        <div id="div_centrovany">
            <button onclick="myFunction4()">Vymaž</button> 
        </div>
        <br>

        <div id="div_centrovany" style="margin-top: 5px;">
            Pridajte novú teplotu
        </div>

        <form method="post" action="http://localhost:8080/temp/new/">
            <div  style="margin-top: 2px;">
                <input type="text" name="temp" required>
            	<button type="submit">Pridaj</button>
            </div>
	</form>
        
        <form id="div_centrovany" method="post" action="http://localhost:8080/temp/up" style="margin-top: 25px; line-height: 150%">
            <div  style="margin-top: 2px">
                Uprav ID: <br>
            	<input type="text" name="id" required  style="width: 60%"> 
                <br>
                Nová teplota: <br>
                <input type="text" name="temp" required  style="width: 60%"> 
                <br>
                <input type="submit" value="Upraviť" style="margin-top:5px">
            </div>
	</form>

        
     </div>
     
     <div id="div_bot">
    </div>
    
  </body>
</html>

