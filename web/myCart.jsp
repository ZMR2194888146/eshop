<%-- 
    Document   : myCart
    Created on : 2018-5-5, 22:13:35
    Author     : MENGRU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>我的购物车</title>
        <link type="text/css" rel="stylesheet" href="css/mycart.css"/>
    </head>
    <body onload="isLogin()">
        <div id="main">  
            <h2>我的购物车</h2>
            <table id="maintable">
                <tr class="title">
                    <td class="checkBox" onchange="onSelected('all')"><input type="checkbox" onselect=""/><font>全选</font></td>
                    <td class="img">&nbsp;</td>
                    <td class="gname">商品名</td>
                    <td class="price">价格</td>
                    <td class="number">数量</td>
                    <td class="delete">操作</td>
                </tr>
                <jsp:include page="ShowGoods?uid=${cookie.uid.value}" flush="true"/>
            </table>
            <table><tr><td>&nbsp;</td></tr></table>
            <table id="bottom">
                <tr>
                    <td><input class="checkBox" type="checkbox"/>全选</td>
                    <td><a class="delete" href="javascript:;" onclick="">删除</a></td>
                    <td>已选择<span>&nbsp;</span>件</td>
                    <td class="buttonArea"><a class="button" href="javascript:;">结算</a></td>
                </tr>  
            </table>
        </div>
        <script type="text/javascript" src="js/function.js"></script>
        <script type="text/javascript">
              function isLogin(){
                var maintable = document.getElementById("maintable");
                if(getCookie("uid") === false){      
                    maintable.innerHTML = "你当前尚未登录，请登录后查看";
                }
            }
            function onSelected(str){
                if(str !== "all"){
                    var bottom = document.getElementById("bottom");
                    var checkBox = document.getElementsByTagName("input");
                    for(var i = 0;i < checkBox.length;i++){
                        alert(checkBox[i].value);
                    }
                    
                }  
            }
        </script>
    </body>
</html>
