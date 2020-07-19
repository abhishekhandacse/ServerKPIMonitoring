package health.monitor.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HealthMonitorApplication {
	public static void main(String[] args) {
		SpringApplication.run(HealthMonitorApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/netstat").allowedOrigins("http://127.0.0.1:5500");
				registry.addMapping("/ifconfig").allowedOrigins("http://127.0.0.1:5500");
				registry.addMapping("/lscpu").allowedOrigins("http://127.0.0.1:5500");
				registry.addMapping("/lshw").allowedOrigins("http://127.0.0.1:5500");
			}
		};
	}
}


