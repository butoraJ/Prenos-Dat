<html>
<style>
#div_psw {
  position: absolute;
  left: 50%;
  top: 50%;
  width: 450px;
  height: 600px;
  background-color: #3f6477;
  text-align: center;
  margin-left: -225px; /*half width*/
  margin-top: -300px; /*half height*/
  border-radius: 25px;
  /*border: 1px solid */
}
#div_tab {
  position: absolute;
  left: 50%;
  top: 50%;
  width: 400px;
  height: 300px;
  text-align: center;
  margin-left: -200px; /*half width*/
  margin-top: -40px; /*half height*/
  /*border: 1px solid*/ 
}
#div_tabH {
  position: absolute;
  left: 50%;
  top: 50%;
  width: 400px;
  height: 50px;
  text-align: center;
  margin-left: -200px; /*half width*/
  margin-top: -80px; /*half height*/
}
#div_logintext {
  width: 350px;
  height: 50px;
  margin: 0 auto;
  /* border: 1px solid ; */
  font-size: 32px;
  font-family: verdana, Geneva, Tahoma, sans-serif;
  margin-top: 30px;
  margin-bottom: 15px;
  color: #FFFFFF;
  border-radius: 30px;
}
#div_zmen {
  width: 300px;
  height: 100px;
  margin: 0 auto;
  /*border: 1px solid ; */
  font-size: 16px;
  font-family: verdana, Geneva, Tahoma, sans-serif;
  color: #FFFFFF;
  line-height: 150%;
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
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 300px;
    margin-left: 50px;
}

    td, th {
    border: 1px solid #DDDDDD;
    text-align: center;
    padding: 8px;
    color: #DDDDDD;
}

    tr:nth-child(odd) {
    background-color: #355463;
}
    tr:nth-child(even) {
    background-color: #4a768c;
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
             Všetci užívatelia
      </div>
      
      <form method="post" action="http://localhost:8080/user/up/">
            <div id="div_zmen"  style="margin-top: 2px">
            	Zadaj ID: <input type="text" name="id" style="float: right" required>
                <br>
                Nové meno: <input type="text" name="name" style="float: right" required>
                <br>
                Nové heslo: <input type="password" name="pswNew" style="float: right" required>
            	<br><button type="submit" style="width:100px; height:30px; border-radius: 15px; margin-top:5px ">Zmeň</button>
            </div>
	</form>
      
      <div id="div_tabH">
          <table>
        <tr style="background-color: #273e4a">
            <th style="width: 100px"> ID </th>
            <th>Meno užívateľa</th>
        </tr>
         </table>
         </div>

         <div id="div_tab" style="overflow:auto;">
         <table>
        <tr>
        <#list listUser as itemList>
            <tr><td style="width: 100px">${itemList.id}</td><td>${itemList.name}</td>
                
        </#list>
        </tr>
        
        </table>
        </div>
      
        
     </div>
     
     <div id="div_bot">
    </div>
    
  </body>
</html>

