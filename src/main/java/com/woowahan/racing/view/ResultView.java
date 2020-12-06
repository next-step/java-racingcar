package com.woowahan.racing.view;

import java.util.List;

import com.woowahan.racing.constant.Message;
import com.woowahan.racing.model.GameResult;

public class ResultView {

	public static final String DISTANCE_CHAR = "-";

	public static void printResult(List<GameResult> gameResults, List<String> winners) {
		printResultHeader();
		for (GameResult gameResult : gameResults) {
			printEachResult(gameResult);
		}
		printResultWinner(winners);
	}

	public static void printResultHeader() {
		System.out.println("실행 결과:");
	}

	public static void printEachResult(GameResult gameResult) {
		gameResult.getCars()
			.forEach(
				car -> System.out.println(String.format("%s : %s", car.getName(), printDistance(car.getDistance()))));
		System.out.println();
	}

	private static String printDistance(int distance) {
		String result = "";
		for (int i = 0; i < distance; i++) {
			result += DISTANCE_CHAR;
		}
		return result;
	}

	private static void printResultWinner(List<String> winners) {
		System.out.println(String.format(Message.MSG_WINNER, String.join(", ", winners)));
	}

}
