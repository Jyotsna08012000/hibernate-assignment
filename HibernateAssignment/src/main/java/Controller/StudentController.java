package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Dao.StudentDao;
import Model.Students;





/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, maxFileSize = 1024 * 1024 * 512, maxRequestSize = 1024 * 1024 * 512)
public class StudentController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private String extractfilename(Part file) {
	    String cd = file.getHeader("content-disposition");
	    System.out.println(cd);
	    String[] items = cd.split(";");
	    for (String string : items) {
	        if (string.trim().startsWith("filename")) {
	            return string.substring(string.indexOf("=") + 2, string.length()-1);
	        }
	    }
	    return "";
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equalsIgnoreCase("register")) {
			
			String savePath = "C:\\Users\\hp\\eclipse-workspace\\HibernateAssignment\\src\\main\\webapp\\image";   
			File fileSaveDir=new File(savePath);
	        if(!fileSaveDir.exists()){
	            fileSaveDir.mkdir();
	        }
	        Part file1 = request.getPart("image");
		 	String fileName=extractfilename(file1);
		    file1.write(savePath + File.separator + fileName);
		    String filePath= savePath + File.separator + fileName ;
		    
		    String savePath2 = "C:\\Users\\hp\\eclipse-workspace\\HibernateAssignment\\src\\main\\webapp\\image";
	        File imgSaveDir=new File(savePath2);
	        if(!imgSaveDir.exists()){
	            imgSaveDir.mkdir();
	        }

			Students s = new Students();
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setMobile(Long.parseLong(request.getParameter("mobile")));
			s.setGender(request.getParameter("gender"));
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			s.setImage(fileName);
			System.out.println(s);
			new StudentDao().insertStudent(s);
			request.setAttribute("msg", "data registerd");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("login")) {
			Students s = new Students();
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			Students s1 = new StudentDao().StudentLogin(s);
			if(s1==null) {
				request.setAttribute("msg1", "password is incorrect");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("data", s1);
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			}
		}else if (action.equalsIgnoreCase("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			List<Students> s = new StudentDao().getStudentById(id);
			request.setAttribute("data", s);
			request.getRequestDispatcher("Edit.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("update")){
			
			String savePath = "C:\\Users\\hp\\eclipse-workspace\\HibernateAssignment\\src\\main\\webapp\\image";   
			File fileSaveDir=new File(savePath);
	        if(!fileSaveDir.exists()){
	            fileSaveDir.mkdir();
	        }
	        Part file1 = request.getPart("image");
		 	String fileName=extractfilename(file1);
		    file1.write(savePath + File.separator + fileName);
		    String filePath= savePath + File.separator + fileName ;
		    
		    String savePath2 = "C:\\Users\\hp\\eclipse-workspace\\HibernateAssignment\\src\\main\\webapp\\image";
	        File imgSaveDir=new File(savePath2);
	        if(!imgSaveDir.exists()){
	            imgSaveDir.mkdir();
	        }
	        Students s = new Students();
	        s.setId(Integer.parseInt(request.getParameter("id")));
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setMobile(Long.parseLong(request.getParameter("mobile")));
			s.setGender(request.getParameter("gender"));
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			s.setImage(fileName);
			System.out.println(s);
			new StudentDao().EditStudent(s);
			response.sendRedirect("Home.jsp");
	}	
}
}
