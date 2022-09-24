package carRacing.level3.output;

import java.util.HashMap;

public class OutPutView {

	HashMap<Integer, String> map1 = new HashMap<Integer, String>();

	public void showRace(int carNum) {
		System.out.println("-");
		map1.put(carNum, "-");

	}
}