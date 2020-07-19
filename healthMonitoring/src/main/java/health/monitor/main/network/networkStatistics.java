package health.monitor.main.network;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

@Component
public class networkStatistics {
    private  String output;
    public networkStatistics() {}
    public HashMap<String, String> netstat() {
        HashMap<String,String> hm=new HashMap<>();
        String s;
        Process p;
        output="";
        try {
            p = Runtime.getRuntime().exec("netstat -r");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s = bufferedReader.readLine()) != null){
                output+=s;
                output+='\n';
            }

            p.waitFor();
            System.out.println ("exit: " + p.exitValue());
            p.destroy();
        } catch (Exception e) {e.printStackTrace();}
        hm.put("body",output);
        return hm;
    }
    public HashMap<String, String> ifconfig() {
        HashMap<String,String> hm=new HashMap<>();
        String s;
        Process p;
        output="";
        try {
            p = Runtime.getRuntime().exec("ifconfig");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s = bufferedReader.readLine()) != null){
                output+=s;
                output+='\n';
            }

            p.waitFor();
            System.out.println ("exit: " + p.exitValue());
            p.destroy();
        } catch (Exception e) {e.printStackTrace();}
        hm.put("body",output);
        return hm;
    }
}
