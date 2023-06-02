
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



 
         <table>
         <h3> Welcome to your Home Page <%=s.getFname() %></h3>
         
          <input type="hidden" name="id" value="<%=s.getId()%>">
             
               <tr> 
             <td><img src="image/<%=s.getImage()%>"height="200px" width="200px"></td>
               </tr>
               
             <tr> 
                <td>First Name : <%=s.getFname() %></td>
               </tr>
               
             <tr>
                <td>Last Name : <%=s.getLname() %></td>
                 </tr>
                 
             <tr>
                <td>Email : <%=s.getEmail() %></td>
              </tr>
              
            <tr>
                <td>Mobile : <%=s.getMobile() %></td>
                </tr>
                
             <tr>
                <td>Gender : <%=s.getGender() %></td>
                </tr>
           
            <tr>
                <td>Password :  <%=s.getPassword()%></td>
              </tr>
             
               <tr>
               <form action="StudentController" method="post">
               <input type="hidden" name="id" value="<%=s.getId()%>">
                <td><input type="submit" name="action" value="edit"></td>
                
                  <td><a class="nav-link" href="Logout.jsp">Logout</a></td>
                
            </tr>
           
           
              </table>
            </form>


</body>
</html>