package infoMaquina;

import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.FormatUtil;

public class Disco {
    private SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer hardware = si.getHardware();
    private List<HWDiskStore> discos = hardware.getDiskStores();
    
    public void disk(){        
        for (int i = 0; i < discos.size(); i++) {
            System.out.println("Disco " + i + ": " + FormatUtil.formatBytes(discos.get(i).getSize()));
        }
    }
    
}
