package vn.PTIT;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import vn.PTIT.config.WebMVC;

@SpringBootApplication
@Import({ WebMVC.class })
public class StartServer implements CommandLineRunner {
	public void run(String... args) throws Exception {
		System.out.println("\n---------- HELLO CUONG PHAM ----------");
	}

	public static void main(String[] args) {
		SpringApplication.run(StartServer.class, args);
	}
}

