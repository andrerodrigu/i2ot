<%@page import="java.util.List"%>
<%@page import="java.io.FileWriter"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="project.util.NameHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="myBean" scope="session" class="project.util.NameHandler" />
        <jsp:setProperty name="myBean" property="name" />
        <h3 align="center">
            Dados enviados com sucesso!
        </h3>
        <br/>
        <div align="center">
        <a href="index.jsp">Voltar</a>
        </div>
        <%
            FileWriter jsFile;
            JSONObject jsonObj = new JSONObject();
            JSONArray codes = new JSONArray();
            List<String> strList = NameHandler.getCuttedCodes();
            
            for(String iterator : strList){
                codes.add(iterator);
            }
            
            jsonObj.put("Codes:", codes);
            
            jsFile = new FileWriter("C:/Users/André/Documents/testeJavaWeb.json");
            jsFile.write(jsonObj.toJSONString());
            jsFile.close();
            
        %>
    </body>
</html>
