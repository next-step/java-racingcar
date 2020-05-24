package racingGame.view;

import racingGame.domain.ScoreBoard;

public class OutputView {
	private static String[] result;
	
	public static void printGameScore(ScoreBoard scoreBoard) {
		System.out.println("실행 결과");
		
		String[][] gameResultScoreBoard = scoreBoard.makeScoreBoard();
		result = new String[gameResultScoreBoard[0].length];
		initializeResult();
		
		for(int i = 0 ; i < gameResultScoreBoard.length ; i++) {
			printNRound(gameResultScoreBoard, i);
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
