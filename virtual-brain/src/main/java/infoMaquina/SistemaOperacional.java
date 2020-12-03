package infoMaquina;

import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public class SistemaOperacional {
    private SystemInfo si = new SystemInfo();
    private OperatingSystem op = si.getOperatingSystem();
    
    private String sistemaOperacional = op.toString();

    public String getSistemaOperacional() {
        return sistemaOperacional;
        }

}

    
