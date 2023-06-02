
<%@page import="Model.Students"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Students s =null;
if(session.getAttribute("data")!=null){
	s = (Students)session.getAttribute("data");
}
else{
	response.sendRedirect("Login.jsp");
}
%>

<form action="StudentController" method="post" enctype="multipart/form-data">
         <table>
    
         <input type="hidden" name="id" value="<%=s.getId()%>">
             <tr> 
              <td><%=s.getImage()%>  <img src="image/<%=s.getImage()%>"height="200px" width="200px"></td>
               </tr>
               
              <tr> 
                <td>First Name :</td>
                 <td><input type="text" name="fname" value="<%=s.getFname()%>"></td>
            </tr>
             <tr>
                <td>Last Name :</td>
                <td><input type="text" name="lname" value="<%=s.getLname()%>"></td>
            </tr>
             <tr>
                <td>Email :</td>
                <td><input type="text" name="email" value="<%=s.getEmail()%>"></td>
            </tr>
            <tr>
                <td>Mobile :</td>
                <td><input type="text" name="mobile" value="<%=s.getMobile()%>"></td>
            </tr>
            <tr>
                <td>Gender :</td>
                <td><input type="text" name="gender" value="<%=s.getGender()%>"></td>
            </tr>
           
            <tr>
                <td>Password :</td>
                <td><input type="text" name="password" value="<%=s.getPassword()%>"></td>
            </tr>
            <td>Upload your photo :</td>
                <td><input type="file" name="image"></td>
            </tr>
            
            <tr>
                <td><input type="submit" name="action" value="update"></td>
            </tr>
              </table>
            </form>

</body>
</html>