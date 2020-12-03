package infoMaquina;

import conexao.ConexaoBD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

/**
 *
 * @author Gabriel Bezerra
 */
public class Leituras {
    ConexaoBD config = new ConexaoBD();
    Connection con;
    Statement stmt;
    DecimalFormat df = new DecimalFormat("#.##");
    Memoria mem = new Memoria();
    Cpu cpu = new Cpu();
    Cpu teste = new Cpu();

    public Leituras() throws SQLException {
        this.con = DriverManager.getConnection(config.conexao());
        this.stmt = con.createStatement();
    }
    
    public String getHostname() throws IOException{
        Process proc = Runtime.getRuntime().exec("hostname");  
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        return stdInput.readLine();
    }
    
    public String formatMemoria(Double mem){
        return df.format(mem).replace(',', '.');
    }
    
    public String formatCpu(Double cpu){
        return df.format(cpu).replace(',', '.');
    }
    
    private Integer getIdSetupMaquina() throws IOException, SQLException{
        
        
        ResultSet hostname = stmt.executeQuery(String.format("SELECT idSetupMaquina FROM [dbo].[SetupMaquina] WHERE Maquina_idMaquina = (SELECT idMaquina FROM [dbo].[Maquina] WHERE hostnameMaquina = '%s')", getHostname()));
        Integer maquina = null;
        
        while(hostname.next()){
            maquina = hostname.getInt("idSetupMaquina");
        }
        return maquina;
    }
    
    public Boolean insertMem(String mem) throws IOException, SQLException{
       return stmt.execute(String.format("INSERT INTO [dbo].[Leitura](valorLeitura, SetupMaquina_idSetupMaquina) VALUES (%s, %d);", mem, getIdSetupMaquina())); 
    } 
    
    public Boolean insertCpu(String cpu) throws IOException, SQLException{
       return stmt.execute(String.format("INSERT INTO [dbo].[Leitura](valorLeitura, SetupMaquina_idSetupMaquina) VALUES (%s, %d);", cpu, getIdSetupMaquina())); 
    } 
}
