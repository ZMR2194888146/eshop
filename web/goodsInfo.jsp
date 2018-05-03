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
    <script type="text/javascript">
        function addtioncart(goodsid){
            alert(goodsid);
        }            
    </script>
    </body>
</html>
