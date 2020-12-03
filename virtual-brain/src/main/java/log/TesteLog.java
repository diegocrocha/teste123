package log;

import infoMaquina.Log;
import java.io.IOException;

public class TesteLog {

    public static void main(String[] args) throws IOException {
        Log.startLog();
        Log.errosLog("WARNING: ","CPU acima de 80%");
    }
    
}
