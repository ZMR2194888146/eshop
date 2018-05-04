<%-- 
    Document   : index
    Created on : 2018-3-19, 15:30:45
    Author     : 18787
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/index.css"/>
        <title>首页</title>
    </head>
    <body onload="isLogin()">
        <table>
            <tr id="header">
                <td class="logo">
                    <h1>ESHOP</h1>
                    <p>www.eshop.shop</p>
                </td>
                <td class="serch">
                    <select>
                        <option value="商品">商品</option>
                        <option value="商铺">商铺</option>
                    </select>
                    <input type="text" name="classfe"/>
                    <button>搜索</button>
                </td>
                <td class="acount">
                    <span id="logouted">
                        <a href="rigster.jsp">注册</a>|
                        <a href="login.jsp">登录</a>
                    </span>
                    <span id="logined">
                        <font>你好！${cookie.username.value}</font><br/>
                        <a href="javascript:;" onclick="logout()">退出登录</a>
                    </span>   
                </td>
            </tr>
            <tr id="table-body">
                <td class="siderbar">
                    <jsp:include page="showGoodsClassify" flush="true"/>
                </td>
                <td id="main" class="content" colspan="2">&nbsp;</td>
            </tr>
        </table>
        <script type="text/javascript" src="js/function.js"></script>
        <script type="text/javascript">
            function isLogin(){
                var logouted = document.getElementById("logouted");
                var logined = document.getElementById("logined");
//                alert(getCookie("username"))
                if(getCookie("username") !== false){
                    logouted.style.display="none";
                    logined.style.display="block";
                }else{
                    logined.style.display="none";
                    logouted.style.display="block";
                }
            }
            function showGoodsById(cid){
                var ajax = new XMLHttpRequest;
                ajax.onreadystatechange=function(){
                    if(ajax.status !==200){
                        return;
                    }
                    var main =  document.getElementById("main");
                    main.innerHTML = ajax.responseText;
                };
                ajax.open("get","QueryGoods?cid="+encodeURI(cid),true);
                ajax.send();
            }
            function logout(){
                document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
                document.cookie = "uid=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
                window.location.href = document.URL;
            }
        </script>
    </body>
</html>
