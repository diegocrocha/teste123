package log;

import java.io.IOException;

public class TesteLog {

    public static void main(String[] args) throws IOException {
        Log.startLog();
        Log.errosLog("CPU acima de 80%", "WARNING: ");
    }
    
}
