package infoMaquina;

import conexao.ConexaoBD;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetupMaquina {
    
    Integer idSetupMaquina;
    Integer statusComponente;
    Integer componentesIdComponentes;
    Integer maquinaIdMaquina;

    public SetupMaquina() {
        this.statusComponente = 0;
    }
    
    public void insertSetupMaquina() throws SQLException{
        ConexaoBD con = new ConexaoBD();

        con.getStmt().execute(String.format("INSERT INTO [dbo].[SetupMaquina] VALUES (%d, %d, %d)",
                this.statusComponente, this.componentesIdComponentes, this.maquinaIdMaquina));

    }

    public Integer componenteIdComponentes(String componente){
        switch (componente.toUpperCase()) {
            case "CPU":
                return this.componentesIdComponentes = 600;
            case "DISCO":
                return this.componentesIdComponentes = 601;
            case "RAM":
                return this.componentesIdComponentes = 603;
            default:
                break;
        }
        return null;
    }
    
    public Integer statusComponentes(){
        return this.statusComponente = 1;
    }
    
    public Integer idSetupMaquina() throws SQLException{
        conexao.ConexaoBD con = new ConexaoBD();
        ResultSet ultimo = con.getStmt().executeQuery("SELECT @@IDENTITY as 'idSetupMaquina'");
        while (ultimo.next()) {
            return this.idSetupMaquina = ultimo.getInt("idSetupMaquina");
        }
        return null;
    }

    public Integer idMaquina(Integer maquinaIdMaquina) {
        return this.maquinaIdMaquina = maquinaIdMaquina;
    }
}
