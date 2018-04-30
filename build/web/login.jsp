<%-- 
    Document   : login
    Created on : 2018-3-25, 20:01:59
    Author     : 18787
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/acount.css"/>
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
                                    <input type="text" name="username"/>
                                </td>
                                <td>
                                    <font>输入用户名</font>
                                </td>
                            </tr>
                            <tr>
                                <td class="item">密码:</td>
                                <td class="values">
                                    <input type="password" name="passwd"/>
                                </td>
                                <td>
                                    <font>输入用户账户密码</font>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="3" id="submit-rigster">
                                    <button>登录</button>
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
    </body>
</html>
