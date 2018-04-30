<%-- 
    Document   : index
    Created on : 2018-3-19, 15:30:45
    Author     : 18787
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/index.css"/>
        <title>首页</title>
    </head>
    <body>
        <table>
            <tr id="header">
                <td class="logo">
                    <h1>EBOOK</h1>
                    <p>www.ebook.shop</p>
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
                    <a href="rigster.jsp">注册</a>
                    <a href="login.jsp">登录</a>
                </td>
            </tr>
            <tr id="table-body">
                <td class="siderbar">
                    <jsp:include page="showGoodsClassify" flush="true"/>
                </td>
                <td id="main" class="content" colspan="2">&nbsp;</td>
            </tr>
        </table>
        <script type="text/javascript">
            function showGoodsById(cid){
                var ajax = new XMLHttpRequest;
                ajax.onreadystatechange=function(){
                    if(ajax.status !==200){
                        return;
                    }
                    var main =  document.getElementById("main");
                    main.innerHTML = ajax.responseText;
                }
                ajax.open("get","QueryGoods?cid="+encodeURI(cid),true);
                ajax.send();
            }
        </script>
    </body>
</html>
