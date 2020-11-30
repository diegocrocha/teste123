package infoMaquina;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.util.FormatUtil;

public class teste {

    public static void main(String[] args) throws SQLException, IOException, InterruptedException {
        SistemaOperacional sistema = new SistemaOperacional();
        Processador processador = new Processador();
        Disco disc = new Disco();
        Memoria mem = new Memoria();
        Processos processos = new Processos();
        Cpu cpu = new Cpu();
        Leituras lt = new Leituras();

        System.out.println(sistema.getSistemaOperacional());
        System.out.println("------------------------");
        System.out.println(processador.processador.subSequence(0, processador.indiceProcessador));
        System.out.println("------------------------");
        disc.disk();
        System.out.println("------------------------");
        System.out.println("Memória RAM Total: " + FormatUtil.formatBytes(mem.memTotal));
        System.out.println("------------------------");
        System.out.println(FormatUtil.formatBytes(mem.memTotal));
        System.out.println("------------------------");
        System.out.println(mem.usoMemoria());
        System.out.println("------------------------");
        System.out.println(cpu.usoCpu());
        System.out.println("------------------------");
        System.out.println(processos.printProcessos().toString());
        System.out.println("------------------------");
//        while (true) {            
//            System.out.println(cpu.usoCpu());
//         try {
//            Thread.sleep(5000);
//        } catch (Exception e) {
//        }}

//        String hostname = "";
//        hostname = lt.getHostname();
        if (lt.getHostname().equals("6811b44a5f14") || lt.getHostname().equals("60844ea62bb5")) {
            conexao.ConexaoMarise config = new conexao.ConexaoMarise();
            JdbcTemplate con = new JdbcTemplate(config.getDatasource());
            Integer i = 0;
            DecimalFormat df = new DecimalFormat("#.##");
            while (i<10) {
                Double valorCPU = cpu.usoCpu();
                Double valorMemoria = mem.usoMemoria();
                System.out.println("Inserindo dados de CPU\nValor: " + valorCPU.toString());
                con.update("INSERT INTO leituras VALUES (null, ? , NOW(), 1)", df.format(valorCPU).replace(',', '.'));
                System.out.println("Inserindo dados de Memória\nValor: " + valorMemoria);
                con.update("INSERT INTO leituras VALUES (null, ? , NOW(), 2)", df.format(valorMemoria).replace(',', '.'));
                i ++;
                Thread.sleep(1000);
            }
        }
    }
}
