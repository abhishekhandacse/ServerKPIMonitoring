package health.monitor.main.cpuUtilization;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

@Component
public class CPUStatistics {
    private  String output;
    public CPUStatistics() {}
    public HashMap<String, String> top() {
        HashMap<String,String> hm=new HashMap<>();
        String s;
        Process p;
        output="";
        try {
            p = Runtime.getRuntime().exec("top -n 1");
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
    public HashMap<String,String> lscpu() {
        HashMap<String,String> hm=new HashMap<>();
        String s;
        Process p;
        output="";
        try {
            p = Runtime.getRuntime().exec("lscpu");
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
    public HashMap<String,String> lshw() {
        HashMap<String,String> hm=new HashMap<>();
        String s;
        Process p;
        output="";
        try {
            p = Runtime.getRuntime().exec("lshw");
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


/*
top - 16:20:28 up  2:37,  1 user,  load average: 0.20, 0.51, 0.51
Tasks: 249 total,   1 running, 248 sleeping,   0 stopped,   0 zombie
%Cpu(s):  6.4 us,  2.6 sy,  0.0 ni, 90.7 id,  0.3 wa,  0.0 hi,  0.0 si,  0.0 st
KiB Mem : 12229952 total,  5428580 free,  4053064 used,  2748308 buff/cache
KiB Swap: 12510204 total, 12510204 free,        0 used.  7484936 avail Mem
*/


/*
us - user cpu time (or) % CPU time spent in user space
sy - system cpu time (or) % CPU time spent in kernel space
ni - user nice cpu time (or) % CPU time spent on low priority processes
id - idle cpu time (or) % CPU time spent idle
wa - io wait cpu time (or) % CPU time spent in wait (on disk)
hi - hardware irq (or) % CPU time spent servicing/handling hardware interrupts
si - software irq (or) % CPU time spent servicing/handling software interrupts
st - steal time % CPU time in involuntary wait by virtual cpu while hypervisor is servicing another processor (or) % CPU time stolen from a virtual machine
*/