package com;
import java.sql.*;
import java.sql.DriverManager;

public class Item {

		public connection connect()
		{
			connection con = null;
			try
			{
				class.forname("com.mysql.jdba.driver");
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","");
				
				System.out.println("successfully connected");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return con;
	}
		
		public String insertItem(String code, String name, String price, String desc)
		{
			try {
				Connection con = connect();
				if (con == null)
				{
				return "Error while connecting to the database";
				}
				String query = " insert into items
						(`itemID`,`itemCode`,`itemName`,`itemPrice`,`itemDesc`)"
						 + " values (?, ?, ?, ?, ?)";
						PreparedStatement preparedStmt = con.prepareStatement(query);
						// binding values
						preparedStmt.setInt(1, 0);
						preparedStmt.setString(2, code);
						preparedStmt.setString(3, name);
						preparedStmt.setDouble(4, Double.parseDouble(price));
						preparedStmt.setString(5, desc);
						preparedStmt.execute();
						con.close();
						output = "Inserted successfully";
			}
			catch (Exception e)
			 {
			 output = "Error while inserting";
			 System.err.println(e.getMessage());
			 }
			return output;
			}
		public String readItems()
		{
		 String output = "";
		 Return output;
		
		try
		{
		 Connection con = connect();
		if (con == null)
		 {
		 return "Error while connecting to the database for reading.";
		 }
		
		
		output = "<table border='1'>"
				+ "<tr><th>Item Code</th><th>Item Name</th><th>Item Price</th>"
				+ "<th>Item Description</th><th>Update</th><th>Remove</th></tr>";
		
		
		
		
		
		String query = "select * from items";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		// iterate through the rows in the result set
		while (rs.next())
		{
		 String itemID = Integer.toString(rs.getInt("itemID"));
		 String itemCode = rs.getString("itemCode");
		 String itemName = rs.getString("itemName");
		 String itemPrice = Double.toString(rs.getDouble("itemPrice")); 
		9
		String itemDesc = rs.getString("itemDesc");
		// Add a row into the html table
		output += "<tr><td>" + itemCode + "</td>";
		output += "<td>" + itemName + "</td>";
		output += "<td>" + itemPrice + "</td>";
		output += "<td>" + itemDesc + "</td>";
		// buttons
		output += "<td><input name='btnUpdate' type='button' value='Update'></td>"
		 + "<td><form method='post' action='items.jsp'>"
		 + "<input name='btnRemove' type='submit' value='Remove'>"
		 + "<input name='itemID' type='hidden' value='" + itemID + "'>"
		 + "</form></td></tr>";
		}
		
	
		}
		catch (Exception e)
		{
		output = "Error while reading the items.";
		 System.err.println(e.getMessage());
		}
		}
			
			
			
			
			
			
			
			
			
		}
		

}

