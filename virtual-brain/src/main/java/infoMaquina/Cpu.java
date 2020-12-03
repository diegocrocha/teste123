package infoMaquina;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

public class Cpu {
    private SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer hardware = si.getHardware();    
    private CentralProcessor cpu = hardware.getProcessor();
    private long ticks[] = new long[CentralProcessor.TickType.values().length];
    private double cpuUsage;
    
    public double usoCpu(){
        try {
            cpuUsage = (cpu.getSystemCpuLoadBetweenTicks(ticks) * 100);
            ticks = cpu.getSystemCpuLoadTicks();
            if (cpuUsage > 80) {
                Log.errosLog("AVISO: ", "CPU ACIMA DE 80% ");
            }else if (cpuUsage > 60) {
                Log.errosLog("CRITICO: ", "CPU ACIMA DE 60% ");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return cpuUsage;
    }
    
    
}
