package com.cxy.javaweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.cxy.javaweb.entity.BookInfo;

public class BookInfoDao implements IBookInfoDao{
	
	private Connection con = null;
	Statement stm = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	@Override
	public boolean insert(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BookInfo[] select(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		ArrayList<BookInfo> bookInfos = new ArrayList<BookInfo>();
		Connection con;
		
		try {
			
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/bookdb", "postgres", "1");
			String sql = "select * from bookInfo where bookName like ?";//select *from bookInfo where bookName + "=" + bookInfo
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "%"+bookInfo.getBookName()+"%");
			rs = pst.executeQuery();
			
			while(rs.next()) {
				bookInfos.add(new BookInfo(rs.getString("bookName")));
			}
			rs.close();
			con.close();
		}catch(Exception e) {
			bookInfos.add(new BookInfo(e.toString()));
		}
		
		return bookInfos.toArray(new BookInfo[0]);
	}

}
