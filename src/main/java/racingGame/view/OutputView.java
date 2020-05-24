package racingGame.view;

public class OutputView {
	private static String[] result;
	
	public static void printGameScore(String[][] gameScore) {
		System.out.println("실행 결과");
		
		result = new String[gameScore[0].length];
		initializeResult();
		
		for(int i = 0 ; i < gameScore.length ; i++) {
			printNRound(gameScore, i);
			System.out.println();
		}
	}

	private static void initializeResult() {
		for(int i = 0 ; i < result.length ; i++) {
			result[i] = "";
		}
	}

	private static void printNRound(String[][] gameScore, int i) {
		for(int j = 0 ; j < gameScore[i].length ; j++) {
			result[j] += gameScore[i][j];
			System.out.println(result[j]);
		}
	}
}
