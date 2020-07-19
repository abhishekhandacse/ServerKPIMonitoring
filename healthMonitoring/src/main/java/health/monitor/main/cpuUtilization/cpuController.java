package health.monitor.main.cpuUtilization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class cpuController {
    @Autowired
    CPUStatistics statistics;
    @GetMapping("/top")
    public HashMap<String,String> get_top(){ return statistics.top();}
    @GetMapping("/lscpu")
    public HashMap<String,String> get_lscpu(){
            return statistics.lscpu();
    }
    @GetMapping("/lshw")
    public HashMap<String,String> get_lshw(){
        return statistics.lshw();
    }
}
