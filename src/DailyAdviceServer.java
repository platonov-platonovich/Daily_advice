import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {
    String[] advicelist = {"eat smalest portion","dont buy stuf","hate fat people"};
    public void go() {
        try {
            ServerSocket serverSoock = new ServerSocket(4242);
            while (true) {
                Socket sock = serverSoock.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        }catch(IOException exx){;
            exx.printStackTrace();
        }
    }
        private String getAdvice(){
            int random = (int) (Math.random()*advicelist.length);
            return advicelist[random];
        }
        public static void main(String[] args){
            DailyAdviceServer server = new DailyAdviceServer();
            server.go();
        }
}
