<%-- 
    Document   : goodinfo
    Created on : 2018-4-28, 14:22:50
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品详情</title>
        <link href="css/goodsInfo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <table id="content">
            <tr>
                <td>
                    <h1>商品详情</h1>
                    <jsp:include page="GoodsInfo?${param.gid}"/>  
                </td>
            </tr>
        </table>
    <script type="text/javascript" src="js/function.js"></script>
    <script type="text/javascript">
        function addtioncart(goodsid){
            var showScreen = document.getElementById("showScreen");
            var addButton = document.getElementById("addcart");
            if(getCookie("uid")){
                uid = getCookie("uid");  
                console.log(uid);
                var ajax = new XMLHttpRequest;
                ajax.open("POST","ShopingCart",true);
                ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
                ajax.onreadystatechange = function(){
                    if(ajax.status !== 200) return;
                    var rs = parseInt(ajax.responseText);
                    if(rs === 1){
                        showScreen.style.color = "green";
                        showScreen.innerHTML = "加入购物车成功！";
                        addButton.innerHTML = "查看购物车";
                        addButton.setAttribute("onclick","myCart(" + uid + ")");
                    }
                };
                ajax.send("uid="+ uid + "&gid=" + goodsid + "&RT=addGoods");
            }else{
                showScreen.style.color = "red";
                showScreen.innerHTML = "你登录后加入购物车的物品才会被保存";
            }
        } 
        function myCart(uid){
            window.open("myCart.jsp?uid="+uid);
        }
    </script>
    </body>
</html>
