package org.tektutor;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import java.sql.*;

@SpringBootApplication
@RestController
public class App {
    private String msg = "";

    public static void main ( String[] args ) {
        ApplicationContext ctx = SpringApplication.run(App.class,args);
    }

    private String getGreetingMsgFromDB() {
      try {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection (
            "jdbc:mysql://mysql:3306/tektutor","root","root@123"
        );

        Statement stmnt = conn.createStatement();
        
        ResultSet rs = stmnt.executeQuery ( "SELECT * FROM greeting" );

        while( rs.next() ) {
            msg = rs.getString(1);
        }
      } catch( Exception e ) { e.printStackTrace(); }

        return msg;
    }
    
    @RequestMapping("/")
    public String sayHello() {
        //return "Hello World !";
        return getGreetingMsgFromDB();
    }

}
