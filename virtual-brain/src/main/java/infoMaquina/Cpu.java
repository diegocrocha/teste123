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
        } catch(Exception e) {
            System.out.println(e);
        }
        return cpuUsage;
    }
    
    
}
