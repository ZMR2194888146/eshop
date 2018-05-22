<%-- 
    Document   : login
    Created on : 2018-3-25, 20:01:59
    Author     : 18787
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/acount.css"/>
        <link rel="shortcut icon" href="https://www.aboy.site/wp-content/uploads/2018/05/ABoy.png"/>
        <c:if test="${cookie.username.value != null}">
            <meta http-equiv="refresh" content="0;URL='http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}'"/>
        </c:if>
        <title>用户登录</title>
    </head>
    <body>
        <table id="box">
            <tr>
                <td>
                    <table id="form">
                        <tr>
                            <td colspan="3" class="title">用户登录</td>
                        <form action="#">
                            <tr>
                                <td class="item">用户名:</td>
                                <td class="values">
                                    <input id="username" type="text"/>
                                </td>
                                <td>
                                    <font>输入用户名</font>
                                </td>
                            </tr>
                            <tr>
                                <td class="item">密码:</td>
                                <td class="values">
                                    <input id="password" type="password"/>
                                </td>
                                <td>
                                    <font>输入用户账户密码</font>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="3"><font style="color: red;text-align: center;" id="showScren">&nbsp;</font></td>
                            </tr>
                            <tr>
                                <td colspan="3" id="submit-rigster">
                                    <button type="button" onclick="goLogin()">登录</button>
                                    <a href="rigster.jsp">没有账号，去注册</a>
                                    <a href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}">返回首页</a>
                                </td>
                            </tr>
                        </form>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
         <script type="text/javascript">
            function goLogin(){
                var username = document.getElementById("username");
                var password = document.getElementById("password");
                var text = document.getElementById("showScren");
                if(username.value !== "" || password.value !== ""){                                          
                    var ajax = new XMLHttpRequest();
                    ajax.open("post","Persion",true);
                    ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
                    ajax.onreadystatechange = function(){   
                        if(ajax.status !== 200) return;
                        var rs = parseInt(ajax.responseText);
                        if(rs === 1){
                            text.innerHTML = "登录成功，正在为你跳转到首页";
                            setTimeout(function(){
                                 window.location = "http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/";
                            },3000);
                        }else if(rs === 2){
                            text.innerHTML = "账号或密码错误，请重新输入";
                        }else if(rs === 3){
                            text.innerHTML = "账号或密码错误";
                        }else{
                            text.innerHTML = "发生未知错误";
                        }
                    };
                    ajax.send("username="+username.value+"&password=" + password.value + "&type=login");
                }else{
                    text.innerHTML = "表单填写不完整";
                }
            }
        </script>
    </body>
</html>
