

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class servlet2
 */
@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		out.print("<h1>The last five transactions are:</h1>");
		out.print("<table><tr><th>Transaction_id</th><th>Transaction_date</th><th>Credit_amt</th><th>Debit_amt</th><th>Balance_amount</th></tr>");
		out.print("<th>Available_Balance:</th>");
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hcl2","root","Bhavithra28!");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(" select * from transfer order by transaction_id asc limit 5,5 ");
			while(rs.next())
			{
				out.println("<tr><td>");
				out.println(rs.getInt(1));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(2));
				out.println("</td>");
				out.print("<td>");
				out.print(rs.getInt(3));
				out.println("</td>");
				out.print("<td>");
				out.print(rs.getInt(4));
				out.println("</td>");
				out.print("<td>");
				out.print(rs.getInt(5));
				out.println("</td>");
				out.println("</tr>");
				
			}
			ResultSet rs1=stmt.executeQuery(" select Balance_amount from transfer limit 9,1");
			while(rs1.next())
			{
				out.println("<tr><td>");
				out.println(rs.getInt(5));
				out.println("</td>");
				out.println("</tr>");
				
			}
			
		}catch(Exception l) {
			System.out.println(l);
		}
		out.print("</table>");
		}
		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
