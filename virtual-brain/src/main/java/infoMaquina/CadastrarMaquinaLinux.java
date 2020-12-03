package infoMaquina;

import conexao.ConexaoBD;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastrarMaquinaLinux {

    private String user;
    private List<String> itens;
    private String hostName;
    private String marcaModeloMaquina;
    private String sistemaOperacionalMaquina;
    private String processadorMaquina;
    private Double discoMaquina;
    private Double memoriaRamMaquina;
    private Integer funcionario_idFuncionario;

    public CadastrarMaquinaLinux() throws IOException {
        this.user = "";
        this.itens = new ArrayList<>();
        infoMaquinaLinux("lscpu");
        infoMaquinaLinux("lshw");
        infoMaquinaLinux("lsblk");
        infoMaquinaLinux("hostnamectl");
        this.hostName = recuperarDadosLinux("Static hostname");
        this.marcaModeloMaquina = recuperarDadosLinux("Icon name");
        this.sistemaOperacionalMaquina = recuperarDadosLinux("Operating System");
        this.processadorMaquina = recuperarDadosLinux("Model name");
        this.discoMaquina = discoMaquina();
        this.memoriaRamMaquina = memoriaRamMaquina();
    }

    public CadastrarMaquinaLinux(Integer funcionario_idFuncionario) throws IOException {
        this.user = "";
        this.itens = new ArrayList<>();
        infoMaquinaLinux("lscpu");
        infoMaquinaLinux("lshw");
        infoMaquinaLinux("lsblk");
        infoMaquinaLinux("hostnamectl");
        this.hostName = recuperarDadosLinux("Static hostname");
        this.marcaModeloMaquina = recuperarDadosLinux("Icon name");
        this.sistemaOperacionalMaquina = recuperarDadosLinux("Operating System");
        this.processadorMaquina = recuperarDadosLinux("Model name");
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

    private void infoMaquinaLinux(String comand) throws IOException {
        InputStream in = Runtime.getRuntime().exec(comand).getInputStream();
        Scanner scan = new Scanner(in);
        while (scan.hasNext()) {
            itens.add(scan.nextLine());
        }
    }

    public String recuperarDadosLinux(String contains) {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).contains(contains)) {
                String[] split = itens.get(i).split(":");
                return split[1].trim();
            }
        }
        return null;
    }

    public Double discoMaquina() throws IOException {
        InputStream in = Runtime.getRuntime().exec("cat /proc/meminfo").getInputStream();
        Scanner scan = new Scanner(in);
        while (scan.hasNext()) {
            if (scan.nextLine().contains("MemTotal")) {
                String[] split = scan.nextLine().split(":");
                String[] disco = split[1].trim().split(" ");
                return Double.valueOf(disco[0].trim()) / 1024;
            }
        }
        return null;
    }

    public Double memoriaRamMaquina() {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).contains("xvda    202")) {
                String[] split = itens.get(i).split(":");
                String[] splitRam = split[1].trim().split(" ");
                String[] ram = splitRam[8].trim().split("G");

                return Double.valueOf(ram[0]);
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
