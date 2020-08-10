package step3;
import java.util.ArrayList;
import java.util.List;

public class Car {

	private final List<String> status = new ArrayList<String>();
	
	public void run(int randomNum) {
		if(isRunable(randomNum)) {
			status.add("-");
		}
		
		printStatus();
	}

	private void printStatus() {
		StringBuilder strStatus = new StringBuilder();
		
		status.forEach(strStatus::append);
		
		System.out.println(strStatus.toString());
	}
	
	private boolean isRunable(int randomNum) {
		return randomNum >= 4;
	}
}
