package racinggame.view;

import java.util.List;

public class ResultView {
	public static void resultView(List<String> result) {
		result.stream().forEach(r -> System.out.println(r));
	}
}
