package infoMaquina;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

public class Processador {
    private SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer hardware = si.getHardware();
    private CentralProcessor process = hardware.getProcessor();
    
    String processador = process.toString();    
    String nomeProcessador = processador.split("GHz")[1];
    Integer indiceProcessador =  processador.indexOf(nomeProcessador);
    
    public String printProcessador(){
        String textoProcessador = (String) processador.subSequence(0, indiceProcessador);
        return textoProcessador;
    }
    
    @Override
    public String toString() {
        return processador;
    }

    public Integer getIndiceProcessador() {
        return indiceProcessador;
    }
}
