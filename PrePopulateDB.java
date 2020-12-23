package retrievingproductdetailsbyid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PrePopulateDB {

	public static void main(String[] args) {

		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			
			String sqlCreateProductTable = "drop table if exists product; create table product(id int, name varchar(100), details varchar(250))";
			PreparedStatement pst = conn.prepareStatement(sqlCreateProductTable);
			pst.execute();
			System.out.println("product table created");
			
			
			
			String sqlInsertProducts = "insert into product values(?,?,?)";  //check other eclipse jdbc demo for syntax
			pst = conn.prepareStatement(sqlInsertProducts);
			
			pst.setString(1, "101");
			pst.setString(2, "iPhone 12");
			pst.setString(3, "This is the newest generic iPhone model.  Its great!");
			pst.executeUpdate();
			
			pst.setString(1, "102");
			pst.setString(2, "iPhone 12 Pro");
			pst.setString(3, "This is the Pro version of the latest iPhone model.  Its the same but with another camera!");
			pst.executeUpdate();
			
			pst.setString(1, "103");
			pst.setString(2, "iPhone 12 Pro Max");
			pst.setString(3, "This is the max version of the latest iPhone Pro model.  Its the same as the Pro but with a slightly bigger screen!");
			pst.executeUpdate();
			
			pst.setString(1, "104");
			pst.setString(2, "iPhone 12 mini");
			pst.setString(3, "This is the mini version of the newest iPhone model.  Its slightly smaller. Wow how original!");
			pst.executeUpdate();
			
			System.out.println("4 products added to product table");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
