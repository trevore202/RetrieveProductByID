package retrievingproductdetailsbyid;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FindProductByIDServlet")
public class FindProductByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productid = Integer.parseInt(request.getParameter("productid"));
		response.getWriter().print("Product id: " + productid);
		
		
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			String sql = "select * from Product";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			boolean productFound = false;
			Product product = new Product();
			while (rs.next()) {
				if (productid == Integer.parseInt(rs.getString(1))){
					product.setId(productid);
					product.setName(rs.getString(2));
					product.setDetails(rs.getString(3));
					productFound = true;
					break;
				}
			}
			if (productFound){
				response.getWriter().println(". Product:");
				response.getWriter().println(product.getName() + "\n" + product.getDetails());
			} else {
				response.getWriter().println("\nProduct not found");
			}
			
			 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
