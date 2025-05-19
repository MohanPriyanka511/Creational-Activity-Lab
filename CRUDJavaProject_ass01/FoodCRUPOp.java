package com.CAL_01Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FoodCRUPOp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cal01","root","");
			Scanner sc = new Scanner(System.in);
			int chs;
			int ch,n;
			String categary;
			do {
			System.out.println("Enter Choise : \n1. Insert \n2. Display \n3. Update \n4. Delete \nEnter your Choise : ");
			chs = sc.nextInt();
			switch (chs) {
			case 1: 
				PreparedStatement ps = con.prepareStatement("INSERT INTO food(name, price, categary) VALUES (?,?,?)");
				System.out.print("Enter Food Name: ");
				String name = sc.next();
				ps.setString(1, name);
				System.out.print("Enter Food Price: ");
				float price = sc.nextFloat();
				ps.setFloat(2, price);
				System.out.print("Enter Food Categary: 1. Vegetarian 2. Non-vegetarian\nselect your choice:(1/2): ");
				int catChoice = sc.nextInt();
				if(catChoice == 1) {					
					categary = "Vegetarian";
				}
				else {
					categary = "Vegetarian";
				}
				ps.setString(3, categary);
				int i = ps.executeUpdate();
				System.out.println("Data inserted");
				break;
			case 2:
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from food");
				while(rs.next()) {
					System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
				}
				break;
			case 3:
				System.out.println("What do want to update:\n1. Name\n2. Price\n3.Categary\nEnter Your Choice:(1/2/3): ");
				ch = sc.nextInt();
				switch(ch) {
				case 1:
					ps = con.prepareStatement("UPDATE food SET name=? WHERE id = ?");
					System.out.println("Enter the id :");
					int i1 = sc.nextInt();
					System.out.println("Enter the name : ");
					String str = sc.next();
					ps.setString(1, str);
					ps.setInt(2, i1);
					n = ps.executeUpdate();
					break;
				case 2:
					ps = con.prepareStatement("UPDATE food SET price=? WHERE id = ?");
					System.out.println("Enter the id :");
					int i2 = sc.nextInt();
					System.out.println("Enter the price : ");
					float nprice = sc.nextFloat();
					ps.setFloat(1, nprice);
					ps.setInt(2, i2);
					n = ps.executeUpdate();
					break;
				case 3:
					ps = con.prepareStatement("UPDATE food SET categary=? WHERE id = ?");
					System.out.println("Enter the id :");
					int i3 = sc.nextInt();
					System.out.print("Enter Food Categary: 1. Vegetarian 2. Non-vegetarian\nselect your choice:(1/2): ");
					int newcat = sc.nextInt();
					if(newcat == 1) {					
						categary = "Vegetarian";
					}
					else {
						categary = "Non-Vegetarian";
					}
					ps.setString(1, categary);
					ps.setInt(2, i3);
					n = ps.executeUpdate();
					break;
					
				}
				System.out.println("Updation successfuly");
				break;
			case 4:
				ps = con.prepareStatement("DELETE FROM food WHERE id = ?");
				System.out.println("Enter Id :");
				int i2 = sc.nextInt();
				ps.setInt(1, i2);
				ps.executeUpdate();
				System.out.println("Record deleted Successfuly ");
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + chs);
			}
			
			System.out.println("Press 0 to contineu : ");
			chs = sc.nextInt();
			}while(chs == 0);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}