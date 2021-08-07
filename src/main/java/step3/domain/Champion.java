package step3.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Champion {
	private static final Map<Integer, List<String>> resultMap = new HashMap<>();

	private static int getHighestPosition(List<RacingResult> results) {
		return results.stream()
			.mapToInt(RacingResult::getPosition)
			.max()
			.getAsInt();
	}

	private static void putResultMap(RacingResult result) {
		String name = result.getName();
		int position = result.getPosition();

		List<String> values = resultMap.get(position);
		if (values != null) {
			values.add(name);
			return;
		}
		List<String> names = new ArrayList<>();
		names.add(name);
		resultMap.put(position, names);
	}

	public static List<String> getChampion(RacingResults lastResult) {
		List<RacingResult> results = lastResult.getResults();

		for (RacingResult result : results) {
			putResultMap(result);
		}

		int highestPosition = getHighestPosition(results);

		return resultMap.get(highestPosition);
	}
}
