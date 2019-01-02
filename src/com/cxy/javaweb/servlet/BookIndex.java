package com.cxy.javaweb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxy.javaweb.dao.BookInfoDao;
import com.cxy.javaweb.dao.IBookInfoDao;
import com.cxy.javaweb.entity.BookInfo;

/**
 * Servlet implementation class BookIndex
 */
@WebServlet("/BookIndex")
public class BookIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		IBookInfoDao iBookInfoDao = new BookInfoDao();//BookInfoDaoMysql
		BookInfo[] bookInfos = iBookInfoDao.select(new BookInfo("Programming"));
		StringBuilder strBuilder = new StringBuilder();
		for(BookInfo bookInfo : bookInfos) {
			strBuilder.append(bookInfo.getBookName());
		}
		response.getWriter().append(strBuilder.toString());
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
