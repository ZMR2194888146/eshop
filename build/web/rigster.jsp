<%-- 
    Document   : rigster
    Created on : 2018-3-25, 19:32:18
    Author     : 18787
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/acount.css"/>
        <title>注册</title>
    </head>
    <body>
        <table id="box">
            <tr>
                <td>
                    <table id="form">
                        <tr>
                            <td colspan="3" class="title">用户注册</td>
                        <form action="Register" method="post">
                            <tr>
                                <td class="item">用户名:</td>
                                <td class="values">     
                                    <input id="username" type="text" name="username"/>
                                </td>
                                <td>
                                    <font>输入邮箱、或便于记忆的字符串</font>
                                </td>
                            </tr>
                            <tr>
                                <td class="item">密码:</td>
                                <td class="values">
                                    <input id="password" type="password"/>
                                </td>
                                <td>
                                    <font>输入6-24位密码，包括数字、字母的组合</font>
                                </td>
                            </tr>
                            <tr>
                                <td class="item">确认密码:</td>
                                <td class="values">
                                    <input id="passwordagain" type="password" />
                                </td>
                                <td>
                                    <font>确认密码</font>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="3"><font style="color: red;text-align: center;" id="showScren">&nbsp;</font></td>
                            </tr>
                            <tr>
                                <td colspan="3" id="submit-rigster">
                                    <button onclick="goRigester()" type="button">注册</button>
                                    <a href="login.jsp">已有账号，去登录</a>
                                    <a href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}">返回首页</a>
                                </td>
                            </tr>
                        </form>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <script type="text/javascript" src="javascript/json2.js"></script>
        <script type="text/javascript">
            function goRigester(){
                var username = document.getElementById("username");
                var password = document.getElementById("password");
                var passwordagain = document.getElementById("passwordagain");
                var text = document.getElementById("showScren");
                if(username.value !== "" || password.value !== "" || passwordagain.value !== ""){
                    if(password.value === passwordagain.value ){                        
                        var msg = "{'username':'" + username.value + "','password':'"+password.value + "'}";                       
                        var ajax = new XMLHttpRequest();
                        ajax.onreadystatechange = function(){                           
                           if(ajax.status !== 200) return;
                           var rs = ajax.responseText;
                           alert(rs)
                           var json = JSON.parse(rs);
                           if(json.status === 1){
                               text.innerHTML = "注册成功，正在为你跳转到首页";
                               setTimeout(function(){
                                   window.location = "http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/";
                               },3000);
                           }else{
                                text.innerHTML = "服务器发生错误";
                           }
                       };
                       ajax.open("post","Persion",true);
                       ajax.send("msg="+msg);
                    }else{
                        text.innerHTML = "密码不一致";
                    }
                }else{
                    text.innerHTML = "表单填写不完整";
                }
            }
        </script>
    </body>
</html>
