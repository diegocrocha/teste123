package log;

import infoMaquina.Log;
import java.io.IOException;

public class TesteLog2 {
    
    public static void main(String[] args) throws IOException {
        Log.errosLog("WARNING: ","CPU acima de 80%");
    }
}
