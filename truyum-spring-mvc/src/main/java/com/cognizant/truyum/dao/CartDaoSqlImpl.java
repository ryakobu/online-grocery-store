package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
@Component
public class CartDaoSqlImpl implements CartDao {

	public CartDaoSqlImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		Connection con = ConnectionHandler.getConnection();
		Statement statement;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			preparedStatement = con.prepareStatement("insert into cart(ct_us_id,ct_me_id)values(?,?);");
			preparedStatement.setString(1, String.valueOf(userId));
			preparedStatement.setString(2, String.valueOf(menuItemId));
			int record = preparedStatement.executeUpdate();
			if (record > 0) {
				System.out.println("cart tabele in DB updated");
			} else {
				System.out.println("cart tabele in DB not updated");
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

	@SuppressWarnings("resource")
	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		// TODO Auto-generated method stub
		Cart cart=new Cart(new ArrayList<MenuItem>(),0);
		List<MenuItem> items=cart.getMenuItemList();
		Connection con = ConnectionHandler.getConnection();
		Statement statement;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String query="select m.me_id,m.me_name,m.me_price,m.me_active,m.me_date_of_launch,m.me_category,m.me_free_delivery from menu_item m,cart c,user u\r\n" + 
					"where m.me_id=c.ct_me_id and u.us_id=c.ct_us_id and c.ct_us_id=?;";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, String.valueOf(userId));
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
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
				items.add(menuItem);
				
				
			}
			
			
			query="select sum(m.me_price) from menu_item m,cart c,user u\r\n" + 
					"where m.me_id=c.ct_me_id and u.us_id=c.ct_us_id and c.ct_us_id=?;";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, String.valueOf(userId));
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				cart.setTotal(resultSet.getDouble(1));
				System.out.println(cart.getTotal());
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
		
		cart.setMenuItemList(items);
		
	}
		return cart;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		Connection con = ConnectionHandler.getConnection();
		Statement statement;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String query="delete from cart\r\n" + 
					"where ct_us_id=? and ct_me_id=?\r\n" + 
					"limit 1;";
			
			
			
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1,String.valueOf(userId));
			preparedStatement.setString(2,String.valueOf(menuItemId));
			int record = preparedStatement.executeUpdate();
			if (record > 0) {
				System.out.println("cart tabele in DB updated");
		} else {
				System.out.println("cart tabele in DB not updated");
			}
		}catch (Exception e) {
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
