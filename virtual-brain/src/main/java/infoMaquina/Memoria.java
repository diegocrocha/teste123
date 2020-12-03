package infoMaquina;

import java.text.DecimalFormat;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.VirtualMemory;
import oshi.util.FormatUtil;

public class Memoria {
    private SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer hardware = si.getHardware();    
    private GlobalMemory memory = hardware.getMemory();
    private long mem = memory.getTotal();
    private VirtualMemory vm = memory.getVirtualMemory();
    private double memUsage;
    
    String memoriaVirtual = vm.toString();
    long memTotal = mem;
    
    public double usoMemoria(){
        try {
            memUsage = Double.valueOf(100 - (memory.getAvailable() * 100) / (memory.getTotal()));
            if (memUsage > 0) {
                Log.errosLog("AVISO: ", "MEMORIA ACIMA DE 80% ");
            }else if (memUsage > 60) {
                Log.errosLog("CRITICO: ", "MEMORIA ACIMA DE 60% ");
            }
        } catch (Exception e) {
        }
        return memUsage;
    }
}
