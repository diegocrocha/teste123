package infoMaquina;

import conexao.ConexaoBD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastrarMaquina {

    private String user;
    private List<String> itens;
    private String hostName;
    private String marcaModeloMaquina;
    private String sistemaOperacionalMaquina;
    private String processadorMaquina;
    private Double discoMaquina;
    private Double memoriaRamMaquina;
    private Integer funcionario_idFuncionario;

    public CadastrarMaquina() throws IOException {
        this.user = "";
        this.itens = new ArrayList<>();
        infoMaquinaWindows();
        this.hostName = recuperarDadosWindows("Nome do host");
        this.marcaModeloMaquina = recuperarDadosWindows("Modelo do sistema");
        this.sistemaOperacionalMaquina = recuperarDadosWindows("Nome do sistema operacional");
        this.processadorMaquina = recuperarDadosWindows("[01]");
        this.discoMaquina = discoMaquina();
        this.memoriaRamMaquina = memoriaRamMaquina();
    }

    public CadastrarMaquina(Integer funcionario_idFuncionario) throws IOException {
        this.user = "";
        this.itens = new ArrayList<>();
        infoMaquinaWindows();
        this.hostName = recuperarDadosWindows("Nome do host");
        this.marcaModeloMaquina = recuperarDadosWindows("Modelo do sistema");
        this.sistemaOperacionalMaquina = recuperarDadosWindows("Nome do sistema operacional");
        this.processadorMaquina = recuperarDadosWindows("[01]");
        this.discoMaquina = discoMaquina();
        this.memoriaRamMaquina = memoriaRamMaquina();
        this.funcionario_idFuncionario = funcionario_idFuncionario;
    }

    public void CadastrarNovaMaquina() throws SQLException {
        ConexaoBD con = new ConexaoBD();

        con.getStmt().execute(String.format("INSERT INTO [dbo].[Maquina] VALUES ('%s', '%s', '%s', '%s', '%s', %s, '%s')",
                this.hostName, this.marcaModeloMaquina, this.sistemaOperacionalMaquina, this.processadorMaquina,
                this.memoriaRamMaquina, this.funcionario_idFuncionario, this.discoMaquina));

    }

    private void infoMaquinaWindows() throws IOException {
        InputStream in = Runtime.getRuntime().exec("systeminfo").getInputStream();
        Scanner scan = new Scanner(in);
        while (scan.hasNext()) {
            itens.add(scan.nextLine());
        }
    }
    
    public String recuperarDadosWindows(String contains) {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).contains(contains)) {
                String[] split = itens.get(i).split(":");
                return split[1].trim();
            }
        }
        return null;
    }

    public Double discoMaquina() throws IOException {
        InputStream in = Runtime.getRuntime().exec("fsutil volume diskfree c:").getInputStream();
        Scanner scan = new Scanner(in);
        while (scan.hasNext()) {
            if (scan.nextLine().contains("Total de bytes")) {
                String[] split = scan.nextLine().split(":");
                return ((Double.valueOf(split[1].trim()) / 1024) / 1024) / 1024;
            }
        }
        return null;
    }

    public Double memoriaRamMaquina() {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).contains("Mem¢ria f¡sica total")) {
                String[] split = itens.get(i).split(":");
                String[] splitRam = split[1].trim().split(" ");
                return Double.valueOf(splitRam[0]);
            }
        }
        return null;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getFuncionario_idFuncionario() {
        return funcionario_idFuncionario;
    }

    public void setFuncionario_idFuncionario(Integer funcionario_idFuncionario) {
        this.funcionario_idFuncionario = funcionario_idFuncionario;
    }

}
