package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

@Component
public class MenuItemDaoSqlImpl implements MenuItemDao {

	public MenuItemDaoSqlImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		List<MenuItem> menuItemListAdmin = new ArrayList<>();
		Connection con = ConnectionHandler.getConnection();
		Statement statement;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			preparedStatement = con.prepareStatement("SELECT * FROM truyum.menu_item;");

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// System.out.println(resultSet.getInt(1)+ "--" + resultSet.getString(2) + "--"
				// +resultSet.getDouble(3)+"--"+resultSet.getString(4) + "--" +
				// resultSet.getDate(5) + "--"
				// +resultSet.getString(6)+"--"+resultSet.getString(7));
				// menuListAdmin.add( new
				// MenuItem(resultSet.getLong(1),resultSet.getString(2),resultSet.getFloat(3),resultSet.getBoolean(4),resultSet.getDate(5),resultSet.getString(6),resultSet.getBoolean(7)));
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong(1));
				menuItem.setName(resultSet.getString(2));
				menuItem.setPrice(resultSet.getFloat(3));
				if (resultSet.getString(4).equalsIgnoreCase("yes")) {
					menuItem.setActive(true);
				} else {
					menuItem.setActive(false);
				}

				menuItem.setDateOfLaunch(resultSet.getDate(5));
				menuItem.setCategory(resultSet.getString(6));
				if (resultSet.getString(7).equalsIgnoreCase("yes")) {
					menuItem.setFreeDelivery(true);
				} else {
					menuItem.setFreeDelivery(false);
				}
				menuItemListAdmin.add(menuItem);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return menuItemListAdmin;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		List<MenuItem> menuItemListCustomer = new ArrayList<>();
		Connection con = ConnectionHandler.getConnection();
		Statement statement;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			preparedStatement = con.prepareStatement(
					"SELECT * FROM menu_item\r\n" + "where me_active='yes' and me_date_of_launch<CURDATE();");

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// System.out.println(resultSet.getInt(1)+ "--" + resultSet.getString(2) + "--"
				// +resultSet.getDouble(3)+"--"+resultSet.getString(4) + "--" +
				// resultSet.getDate(5) + "--"
				// +resultSet.getString(6)+"--"+resultSet.getString(7));
				// menuListAdmin.add( new
				// MenuItem(resultSet.getLong(1),resultSet.getString(2),resultSet.getFloat(3),resultSet.getBoolean(4),resultSet.getDate(5),resultSet.getString(6),resultSet.getBoolean(7)));
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong(1));
				menuItem.setName(resultSet.getString(2));
				menuItem.setPrice(resultSet.getFloat(3));
				if (resultSet.getString(4).equalsIgnoreCase("yes")) {
					menuItem.setActive(true);
				} else {
					menuItem.setActive(false);
				}

				menuItem.setDateOfLaunch(resultSet.getDate(5));
				menuItem.setCategory(resultSet.getString(6));
				if (resultSet.getString(7).equalsIgnoreCase("yes")) {
					menuItem.setFreeDelivery(true);
				} else {
					menuItem.setFreeDelivery(false);
				}
				menuItemListCustomer.add(menuItem);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return menuItemListCustomer;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		
		
		
			Connection con = ConnectionHandler.getConnection();
			Statement statement;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				
		           String query="update menu_item\r\n" + 
		           		"set me_name=?, me_price=?,  me_active=?,  me_date_of_launch=?,  me_category=?, me_free_delivery=?\r\n" + 
		           		"where me_id=?;";
		           
					preparedStatement = con.prepareStatement(query);
					preparedStatement.setString(1,menuItem.getName());
					preparedStatement.setFloat(2,menuItem.getPrice());
					if(menuItem.isActive()) {
						preparedStatement.setString(3,"yes");
					}
					else {
						preparedStatement.setString(3,"no");
					}
					
					preparedStatement.setString(4,new SimpleDateFormat("yyyy-MM-dd").format(menuItem.getDateOfLaunch()));
					preparedStatement.setString(5, menuItem.getCategory());
					if(menuItem.isFreeDelivery()) {
						preparedStatement.setString(6,"yes");
					}
					else {
						preparedStatement.setString(6,"no");
					}
					
					preparedStatement.setInt(7,(int) menuItem.getId());
					int record = preparedStatement.executeUpdate();
					if(record>0) {
						System.out.println("Updated in DB");
					}
					else {
						System.out.println("Not updated");
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (resultSet != null) {
							resultSet.close();
						}

						if (preparedStatement != null) {
							preparedStatement.close();
						}
						if (con != null) {
							con.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		Connection con = ConnectionHandler.getConnection();
		Statement statement;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		MenuItem menuItem = new MenuItem();
		try {
           String query="SELECT * FROM menu_item where me_id="+menuItemId+";";
			preparedStatement = con.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				menuItem.setId(resultSet.getLong(1));
				menuItem.setName(resultSet.getString(2));
				menuItem.setPrice(resultSet.getFloat(3));
				if (resultSet.getString(4).equalsIgnoreCase("yes")) {
					menuItem.setActive(true);
				} else {
					menuItem.setActive(false);
				}

				menuItem.setDateOfLaunch(resultSet.getDate(5));
				menuItem.setCategory(resultSet.getString(6));
				if (resultSet.getString(7).equalsIgnoreCase("yes")) {
					menuItem.setFreeDelivery(true);
				} else {
					menuItem.setFreeDelivery(false);
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return menuItem ;
	
	}

	public void editMenuItem(MenuItem menuItem) {
		Connection con = ConnectionHandler.getConnection();
		Statement statement;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			
	           String query="update menu_item\r\n" + 
	           		"set me_name=?, me_price=?,  me_active=?,  me_date_of_launch=?,  me_category=?, me_free_delivery=?\r\n" + 
	           		"where me_id=?;";
	           
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1,menuItem.getName());
				preparedStatement.setFloat(2,menuItem.getPrice());
				if(menuItem.isActive()) {
					preparedStatement.setString(3,"yes");
				}
				else {
					preparedStatement.setString(3,"no");
				}
				
				preparedStatement.setString(4,new SimpleDateFormat("yyyy-MM-dd").format(menuItem.getDateOfLaunch()));
				preparedStatement.setString(5, menuItem.getCategory());
				if(menuItem.isFreeDelivery()) {
					preparedStatement.setString(6,"yes");
				}
				else {
					preparedStatement.setString(6,"no");
				}
				
				preparedStatement.setInt(7,(int) menuItem.getId());
				int record = preparedStatement.executeUpdate();
				if(record>0) {
					System.out.println("Updated in DB");
				}
				else {
					System.out.println("Not updated");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (resultSet != null) {
						resultSet.close();
					}

					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		
		

	}

}
