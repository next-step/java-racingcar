package carracing;

public class ResultView {
	public static void printResultPhrase() {
		System.out.println("실행 결과");
	}

	public static void printMovingResult(int movingDistance) {
		String result = "-".repeat(Math.max(0, movingDistance));
		System.out.println(result);
	}

	public static void empty() {
		System.out.println("");
	}
}
