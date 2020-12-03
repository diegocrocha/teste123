package infoMaquina;

import conexao.ConexaoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class Leituras {

    private Map<Integer, Integer> SetupMaquina_idSetupMaquina;

    public Leituras() {
        this.SetupMaquina_idSetupMaquina = new HashMap<Integer, Integer>();
    }
    
    public void insertLeitura(String componente, Double valorLeitura) throws SQLException{
        conexao.ConexaoBD con = new ConexaoBD();
        
        Integer erroLeitura = 0;
        Integer idSetupMaquina = 0;
        
        switch (componente.toUpperCase()) {
            case "CPU":
                idSetupMaquina = SetupMaquina_idSetupMaquina.get(600);
                break;
            case "DISCO":
                idSetupMaquina = SetupMaquina_idSetupMaquina.get(601);
                break;
            case "MEMORIA":
                idSetupMaquina = SetupMaquina_idSetupMaquina.get(603);
                break;
            default:
                break;
        }
        
        if(valorLeitura > 80){
            erroLeitura = 1;
        }
        
        String insert = String.format("INSERT INTO [dbo].[Leitura] VALUES ('%s', %d, GETDATE(), %d)",
                formatLeitura(valorLeitura), idSetupMaquina, erroLeitura);
        
        con.getStmt().execute(insert);
    }
    
    public void idSetupMaquina(Integer funcionario) throws SQLException{
        conexao.ConexaoBD con = new ConexaoBD();
        String select = String.format("SELECT idSetupMaquina, Componentes_idComponentes FROM [dbo].[SetupMaquina] WHERE Maquina_idMaquina = (SELECT idMaquina FROM [dbo].[Maquina] WHERE Funcionario_idFuncionario = %d)", funcionario);
        ResultSet resultadoSelect = con.getStmt().executeQuery(select);
        while(resultadoSelect.next()){
            Integer componente = resultadoSelect.getInt("Componentes_idComponentes");
            Integer idSetupMaquina = resultadoSelect.getInt("idSetupMaquina");
            
            SetupMaquina_idSetupMaquina.put(componente, idSetupMaquina);
        }
    }
    
    public String formatLeitura(Double dado){
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(dado).replace(",", ".");
    }
    
}
