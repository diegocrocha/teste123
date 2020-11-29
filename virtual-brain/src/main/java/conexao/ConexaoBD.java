/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Gabriel Bezerra
 */
public class ConexaoBD {
//    private BasicDataSource datasource;
    
    /**
     *
     * @throws java.sql.SQLException
     */
    public String conexao() throws SQLException{
         String conexaoURL = "jdbc:sqlserver://grupo4.database.windows.net;database=virtual;user=adimin;password=#Gfgrupo4";
         return conexaoURL;
//      this.datasource = new BasicDataSource();;
//        this.datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        this.datasource.setUrl("jdbc:sqlserver://grupo4.database.windows.net;database=virtual");        
//        this.datasource.setUsername("adimin");
//        this.datasource.setPassword("#Gfgrupo4");
            
    }
            
    /**
     *
     * @return
     */
//    public BasicDataSource getDatasource(){
//        return datasource;
//    }
}
