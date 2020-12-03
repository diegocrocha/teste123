package infoMaquina;

import java.io.IOException;
import java.sql.SQLException;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

public class teste {

    public static void main(String[] args) throws SQLException, IOException {
        
        SystemInfo si = new SystemInfo();
        OperatingSystem op = si.getOperatingSystem();
        SistemaOperacional sistema = new SistemaOperacional();
        Processador processador = new Processador();
        Disco disc = new Disco();
        Memoria mem = new Memoria();
        Processos processos = new Processos();
        Cpu cpu = new Cpu();
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
        
//        Integer x = 0;
//        while (x < 10) {            
//            System.out.println(cpu.usoCpu());
//         try {
//            Thread.sleep(500);
//            x++;
//        } catch (Exception e) {
//        }}
        
//        lt.insertCpu(lt.formatCpu(cpu.usoCpu()));
        System.out.println(op);
        System.out.println("------------------------");
        System.out.println(disc.getDiskPercent(0) + "%");
        System.out.println("------------------------");
        System.out.println(disc);

    }
}
