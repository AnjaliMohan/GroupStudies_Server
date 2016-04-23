
    package com;
    import javax.servlet.http.*;
    import javax.servlet.*;
    import java.io.*;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.Statement;

    public class donateBooks extends HttpServlet{
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost/test";

        static final String USER = "root";
        static final String PASS = "";

        public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
            String book_id=request.getParameter("book_id")
            String user_id=request.getParameter("user_id");
            String book_name=request.getParameter("book_name");
            String selection_year=request.getParameter("selection_year");
            String publisher_name=request.getParameter("publisher_name");
            String author_name=request.getParameter("author_name");
            String edition_no=request.getParameter("edition_no");
            String book_availaility=request.getParameter("book_availability");
            String notes=request.getParameter("notes");



            Connection conn=null;
            Statement smt=null;
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                //query to update the row in donatebooks table
                String sql = "INSERT INTO donatebooks VALUES("+book_id+","+user_id+","+book_name+","+selection_year+","+publisher_name+","+author_name+","+edition_no+","+book_availaility+","+notes+")";
                smt = conn.createStatement();
                smt.executeQuery(sql);
            }
            catch (Exception e)
            {
                System.out.println("Error adding book to database")
            }

        }


    }

