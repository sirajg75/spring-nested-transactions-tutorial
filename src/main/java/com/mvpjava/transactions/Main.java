package com.mvpjava.transactions;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main implements CommandLineRunner {	
	@Autowired UploaderService uploaderService;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		uploaderService.upload(buildTimedCommands(),3);		
		  Runnable rr = new Runnable() {		  
			  @Override public void run() { uploaderService.upload(buildTimedCommands(),2);		  
		  }
		 
		};
	    new Thread(rr).start();
	}
	
	private List<String> buildTimedCommands(){
		List<String> sql = new ArrayList<>();
		sql.add("INSERT INTO TIMED_COMMANDS (command, time_of_execution) VALUES ('STAR_TRACKER MODE REBOOT_1', '2019-07-10T00:00:00Z')" );
		sql.add("INSERT INTO TIMED_COMMANDS (command, time_of_execution) VALUES ('SAR_ANTENNA IMAGE_ON_1', '2019-07-10T11:22:00Z')" );
		sql.add("INSERT INTO TIMED_COMMANDS (command, time_of_execution) VALUES ('SAR_ANTENNA STANDBY_1', '2019-07-10T11:29:00Z')");
		
		sql.add("INSERT INTO TIMED_COMMANDS (command, time_of_execution) VALUES ('STAR_TRACKER MODE OFF_2', '2019-07-10T12:00:00Z')" );
		sql.add("INSERT INTO TIMED_COMMANDS (command, time_of_execution) VALUES ('SAR_ANTENNA IMAGE_OFF_2', '2019-07-10T12:22:00Z')" );
		sql.add("INSERT INTO TIMED_COMMANDS (command, time_of_execution) VALUES ('SAR_ANTENNA STANDBY_2', '2019-07-10T13:29:00Z')");
		
		sql.add("INSERT INTO TIMED_COMMANDS (command, time_of_execution) VALUES ('XPNDR TX ON_3', '2019-07-10T14:00:00Z')" );
		sql.add("INSERT INTO TIMED_COMMANDS (command, time_of_execution) VALUES ('XPNDR TX OFF_3', '2019-07-10T14:20:00Z')" );
		sql.add("INSERT INTO TIMED_COMMANDS (command, time_of_execution) VALUES ('SUN_SENSOR ON_3', '2019-07-10T14:29:00Z')");
		
		sql.add("INSERT INTO TIMED_COMMANDS (command, time_of_execution) VALUES ('MAG ON_4', '2019-07-10T14:30:00Z')");
		
		return sql;
	}
	
	/* Just keep application running in order to view H2 console */
	/*
	 * private void pauseApplication() { Scanner scanner = new Scanner(System.in);
	 * System.out.
	 * println("Press any key to stop application. Goto http://localhost:8081/h2-console URL=jdbc:h2:mem:satellitetest"
	 * ); scanner.nextLine(); System.out.println("Application will close");
	 * scanner.close(); System.exit(0); }
	 */
	

}
