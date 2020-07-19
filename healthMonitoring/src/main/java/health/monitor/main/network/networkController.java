package health.monitor.main.network;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class networkController {
    @Autowired
    networkStatistics networkStatistics;
    @GetMapping("/netstat")
    public HashMap<String, String> get_netstat(){
        return networkStatistics.netstat();
    }
    @GetMapping("/ifconfig")
    public HashMap<String, String> get_ifconfig(){
        return networkStatistics.ifconfig();
    }
}
