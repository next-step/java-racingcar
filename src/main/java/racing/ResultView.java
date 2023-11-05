package racing;

import java.util.Map;

public class ResultView {

	public static void printResult(Map<String, String> carMap, int cars) {
		for (int i = 0; i < cars; i++) {
			System.out.println(carMap.get(Integer.toString(i)));
		}
		System.out.println();
	}
}
