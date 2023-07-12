<%@ page  import="java.util.*,com.nt.model.Employee" %>


<%
//read request attrobute value
List<Employee> list=(List<Employee>)request.getAttribute("empDate");
//read request param value
String desg=request.getParameter("desg");

%>

<h1 style="color:red;text-align: center">Employee Details belonging to Desg::<%= desg %></h1>

<%
   if(list!=null || list.size()!=0){  %>
   <table border="1" align="center" bgcolor="cyan">
   <tr><th>eno</th><th>ename</th><th>desg</th><th>salary</th><th>grossSalary</th><th>netSalary</th></tr>
   <%
     for(Employee emp:list){ %>
     <tr>
     <td><%= emp.getEno() %></td>
     <td><%= emp.getEname() %></td>
     <td><%= emp.getJob() %></td>
     <td><%= emp.getSalary() %></td>
     <td><%= emp.getGrossSalary() %></td>
     <td><%= emp.getNetSalary() %></td>
     </tr>
   <%
     }
   %>
   </table>
   <% }
else{ %>
      <h1 style="color: red;text-align: center">Records not found</h1>
      <% }
       %>
       
       <center> <a href="JavaScript:doprint()">print</a></center>
       
       <script language="JavaScript">
           function doPrint() {
        	   frames.focus();
        	   frames.print();
		}
       </script>"