package log;

import infoMaquina.SistemaOperacional;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    
    private static String nomeArquivo;
    private static String mensagem;
    private static String nivelMensagem;
    private static SistemaOperacional sistema = new SistemaOperacional();

    
    private static String dataHoraFormatada;
    
    private static String localhost;
    
    private static FileWriter arq;
    private static PrintWriter gravarArq;
            
    
    
    public static String dataHora(){
        DateTimeFormatter dataHora = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime dataHoraSO = LocalDateTime.now(); 
        dataHoraFormatada = dataHora.format(dataHoraSO);
        return dataHoraFormatada;
    }
    
    public static String hostname() throws UnknownHostException{
        localhost = InetAddress.getLocalHost().getHostName();
        return localhost;
    }
    
    public static void escreverLog() throws IOException{
        arq = new FileWriter(nomeArquivo);
        gravarArq = new PrintWriter(arq);
    }
    
    public static void startLog() throws UnknownHostException, IOException{
        nomeArquivo = "D://Paula_Documentos//"+ dataHora() + hostname() + ".txt";
        escreverLog();
        nivelMensagem = "INFO: ";
        mensagem = nivelMensagem + dataHora() + " " + hostname() + " " + sistema + " iniciou a aplicação." +
                 "\n----------------------------------------------------------------------------------------------------------\n";
        gravarArq.print(mensagem); 
        arq.close();
    }
    
    public static void errosLog(String msg, String nvMsg) throws IOException{
        escreverLog();
        mensagem += dataHora() + " " + nvMsg + msg + "\n";
        gravarArq.print(mensagem);
        arq.close();
    }
 
}
