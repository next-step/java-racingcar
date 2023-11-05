package racing;

import java.util.*;

public class RacingGame {

	private static final Random RANDOM = new Random();
	private static final int BOUND = 10;

	public static int random() {
		return RANDOM.nextInt(BOUND);
	}

	public static String move(String car, int random) {
		if (random >= 4) {
			return car + "-";
		}
		return car;
	}

	public static List<Integer> makeRandomList(int cars) {
		List<Integer> randomList = new ArrayList<>();
		for (int i = 0; i < cars; i++) {
			randomList.add(random());
		}
		return randomList;
	}

	public static void moveAll(Map<String, String> carMap, int cars, List<Integer> randomList) {
		for (int i = 0; i < cars; i++) {
			carMap.put(Integer.toString(i), move(carMap.get(Integer.toString(i)), randomList.get(i)));
		}
	}

	public static Map<String, String> init(int cars) {
		Map<String, String> carMap = new HashMap<>();
		for (int i = 0; i < cars; i++) {
			carMap.put(Integer.toString(i), "-");
		}
		return carMap;
	}

	public static Map<String, String> start(int cars, int attempts) {
		Map<String, String> carMap = init(cars);

		while (attempts-- > 0) {
			List<Integer> randomList = makeRandomList(cars);
			moveAll(carMap, cars, randomList);
		}

		return carMap;
	}

}
