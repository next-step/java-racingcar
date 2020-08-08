package step3;
import java.util.ArrayList;
import java.util.List;

public class Car {

	List<String> status;
	
	public Car() {
		status = new ArrayList<String>();
	}
	
	public void run(int randomNum) {
		if(isRunable(randomNum)) {
			status.add("-");
		}
		
		printStatus();
	}

	public void printStatus() {
		StringBuilder strStatus = new StringBuilder();
		
		status.forEach(strStatus::append);
		
		System.out.println(strStatus.toString());
	}
	
	public boolean isRunable(int randomNum) {
		return randomNum >= 4;
	}
}
