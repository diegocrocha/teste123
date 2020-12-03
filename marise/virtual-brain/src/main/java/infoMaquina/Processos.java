package infoMaquina;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

public class Processos {

    private SystemInfo si = new SystemInfo();
    private OperatingSystem op = si.getOperatingSystem();
    private List<OSProcess> processos = op.getProcesses(10, OperatingSystem.ProcessSort.CPU);
    private List<String> idProcessos = new ArrayList();

    public List<String> printProcessos() {     
        idProcessos.clear();  
        for (OSProcess processo : processos) {
            if(!idProcessos.contains(processo.getName()) ){
                idProcessos.add(processo.getName());
            }
        }
        return idProcessos;
    }
    
    
    
}
