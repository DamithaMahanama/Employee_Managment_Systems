package EmployeeManagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddSalary
 */
@WebServlet("/AddSalary")
public class AddSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSalary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String ot = request.getParameter("ot");
		String excharge = request.getParameter("charge");
		String date = request.getParameter("date");
		
		float msalary;
		
		float fsalary = Float.parseFloat(salary);
		float fot = Float.parseFloat(ot);
		float fexcharge = Float.parseFloat(excharge);
		
		msalary = fsalary + fot*2000 - fexcharge;
		String s = Float. toString(msalary);
		
		int sal = 3;
		sal = Salary.InsertSalary(id,name,salary,ot,excharge, date,s);
		
		

		if (sal == 1) {

			
			RequestDispatcher dis = request.getRequestDispatcher("ViewSalary.jsp");
			dis.forward(request, response);
			System.out.println("Successful");
			
		} else if (sal == 0) {

			
			RequestDispatcher dis2 = request.getRequestDispatcher("AddSalary.jsp");
			dis2.forward(request, response);
			System.out.println("UnSuccessful");
		}
	}

}
