package infoMaquina;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.FormatUtil;

public class Disco {
    private SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer hardware = si.getHardware();
    private List<HWDiskStore> discos = hardware.getDiskStores();

    public List<String> getParticao(Integer index) {
        HWDiskStore disk = discos.get(index);
        List<String> part = new ArrayList<>();        
        for (HWPartition particao : disk.getPartitions()) {
            if (!particao.getMountPoint().equals(""))
                part.add(particao.getMountPoint());
        }        
        return part;
    }

    public Long getFreeDisk(Integer index) {
        Long size = 0L;        
        for (String particao : getParticao(index)) {
            File file = new File(particao);
            size += file.getFreeSpace();
        }        
        return size;
    }
    
    public Integer getDiskPercent(Integer index) throws IOException {
        Long total = discos.get(0).getSize();
        Long usado = getFreeDisk(index);
        Integer discoUsage = Double.valueOf(100 - usado * 100 / total).intValue();
        if (discoUsage > 80) {
                Log.errosLog("AVISO: ", "DISCO ACIMA DE 80% ");
            }else if (discoUsage > 60) {
                Log.errosLog("CRITICO: ", "DISCO ACIMA DE 60% ");
            }
        
        return discoUsage;
    }
    
    public long disk(){        
        return discos.get(0).getSize();
    } 
    
    
}
