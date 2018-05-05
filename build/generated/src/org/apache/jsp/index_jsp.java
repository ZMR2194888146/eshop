package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/index.css\"/>\n");
      out.write("        <title>首页</title>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"isLogin()\">\n");
      out.write("        <table>\n");
      out.write("            <tr id=\"header\">\n");
      out.write("                <td class=\"logo\">\n");
      out.write("                    <h1>ESHOP</h1>\n");
      out.write("                    <p>www.eshop.shop</p>\n");
      out.write("                </td>\n");
      out.write("                <td class=\"serch\">\n");
      out.write("                    <select>\n");
      out.write("                        <option value=\"商品\">商品</option>\n");
      out.write("                        <option value=\"商铺\">商铺</option>\n");
      out.write("                    </select>\n");
      out.write("                    <input type=\"text\" name=\"classfe\"/>\n");
      out.write("                    <button>搜索</button>\n");
      out.write("                </td>\n");
      out.write("                <td class=\"acount\">\n");
      out.write("                    <span id=\"logouted\">\n");
      out.write("                        <a href=\"rigster.jsp\">注册</a>|\n");
      out.write("                        <a href=\"login.jsp\">登录</a>\n");
      out.write("                    </span>\n");
      out.write("                    <span id=\"logined\">\n");
      out.write("                        <font>你好！");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cookie.username.value}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</font><br/>\n");
      out.write("                        <a href=\"javascript:;\" onclick=\"logout()\">退出登录</a>\n");
      out.write("                    </span>   \n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr id=\"table-body\">\n");
      out.write("                <td class=\"siderbar\">\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "showGoodsClassify", out, true);
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td id=\"main\" class=\"content\" colspan=\"2\">&nbsp;</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/function.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function isLogin(){\n");
      out.write("                var logouted = document.getElementById(\"logouted\");\n");
      out.write("                var logined = document.getElementById(\"logined\");\n");
      out.write("                if(getCookie(\"username\") !== false){\n");
      out.write("                    logouted.style.display=\"none\";\n");
      out.write("                    logined.style.display=\"block\";\n");
      out.write("                }else{\n");
      out.write("                    logined.style.display=\"none\";\n");
      out.write("                    logouted.style.display=\"block\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function showGoodsById(cid){\n");
      out.write("                var ajax = new XMLHttpRequest;\n");
      out.write("                ajax.onreadystatechange=function(){\n");
      out.write("                    if(ajax.status !==200){\n");
      out.write("                        return;\n");
      out.write("                    }\n");
      out.write("                    var main =  document.getElementById(\"main\");\n");
      out.write("                    main.innerHTML = ajax.responseText;\n");
      out.write("                };\n");
      out.write("                ajax.open(\"get\",\"QueryGoods?cid=\"+encodeURI(cid),true);\n");
      out.write("                ajax.send();\n");
      out.write("            }\n");
      out.write("            function logout(){\n");
      out.write("                document.cookie = \"username=; expires=Thu, 01 Jan 1970 00:00:00 GMT\";\n");
      out.write("                document.cookie = \"uid=; expires=Thu, 01 Jan 1970 00:00:00 GMT\";\n");
      out.write("                window.location.href = document.URL;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
