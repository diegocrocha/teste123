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

/**
 *
 * @author Gabriel Bezerra
 */
public final class ConexaoBD {
    
    Connection con;
    Statement stmt;

    public ConexaoBD() throws SQLException {
        this.con = DriverManager.getConnection(conexao());
        this.stmt = con.createStatement();
    }
    
    public String conexao() throws SQLException {

        String conexaoURL = "jdbc:sqlserver://grupo4.database.windows.net;database=virtual;user=adimin;password=#Gfgrupo4";
        return conexaoURL;
    }

    public Connection getCon() {
        return con;
    }

    public Statement getStmt() {
        return stmt;
    }
    
    

}
