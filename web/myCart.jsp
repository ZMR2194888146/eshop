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
        <link rel="shortcut icon" href="https://www.aboy.site/wp-content/uploads/2018/05/ABoy.png"/>
    </head>
    <body onload="isLogin()">
        <div id="main">  
            <h2>我的购物车</h2>
            <table id="maintable">
                <tr class="title">
                    <td class="checkBox" onchange="onSelected('all')"><input type="checkbox" onselect=""/><font style="font-size: 8pt;">全选</font></td>
                    <td class="img">&nbsp;</td>
                    <td class="gname"><font style="font-size: 8pt;">商品名</font></td>
                    <td class="price"><font style="font-size: 8pt;">价格</font></td>
                    <td class="number"><font style="font-size: 8pt;">数量</font></td>
                    <td class="delete"><font style="font-size: 8pt;">操作</font></td>
                </tr>
                <jsp:include page="ShowGoods?uid=${cookie.uid.value}" flush="true"/>
            </table>
            <table><tr><td>&nbsp;</td></tr></table>
            <table id="bottom">
                <tr>
                    <td><input class="checkBox" type="checkbox"/>全选</td>
                    <td><a class="delete" href="javascript:;" onclick="">删除</a></td>
                    <td>已选择：<span id="num">0</span>&nbsp;件</td>
                    <td>总计：<span id="money">0</span>&nbsp;元</td>
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
                    var count = 0;
                    var price = 0;
                    var number = document.getElementById("num");
                    var Money = document.getElementById("money");
                    var Price = document.getElementsByClassName("box");
                    var singleGoodsNumber = document.getElementsByClassName("account");
                    for(var i = 0;i < Price.length;i++){
                        if(Price[i].checked){
                            price = price + singleGoodsNumber[i].value * Price[i].value;
                            count++;
                        }  
                    }
                   number.innerHTML = count.toString();
                   Money.innerHTML = price.toString();
                }  
            }
            function deleteGoods(gid){
                happenChange(gid,2,0);
            }
            function modifyGoodsNum(content,gid){
                var num = parseInt(pacontent.innerHTML);
                if(num !== 0){
                    happenChange(gid,num + 1);
                }else{
                   deleteGoods(gid);
                }   
            }
            function addGoods(content,gid){
                var num = parseInt(content.nextSibling.value);
                happenChange(gid,1,num + 1);
            }
            function reduceGoods(content,gid){
                var num = content.previousSibling.value;
                if(num !== 1){
                   happenChange(gid,1,num - 1);
                }else{
                    happenChange(gid,2,0);
                }
            }
            function happenChange(gid,type,num){
                uid = getCookie("uid");  
                console.log(uid);
                var ajax = new XMLHttpRequest;
                ajax.open("POST","ShopingCart",true);
                ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
                ajax.onreadystatechange = function(){
                    if(ajax.status !== 200) return;
                    var rs = parseInt(ajax.responseText);
                    if(rs === 1){
                       window.location.reload();
                    }
                };
                if(type === 1){
                    ajax.send("uid="+ uid + "&gid=" + gid + "&RT=alterNum&goodsNumber=" + num); 
                }else{
                    ajax.send("uid="+ uid + "&gid=" + gid + "&RT=delGoods&goodsNumber=1"); 
                }  
            }
        </script>
    </body>
</html>
