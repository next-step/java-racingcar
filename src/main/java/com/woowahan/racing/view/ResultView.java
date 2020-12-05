package com.woowahan.racing.view;

import java.util.List;

import com.woowahan.racing.constant.Message;
import com.woowahan.racing.model.GameResult;

public class ResultView {

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
			.forEach(car -> System.out.println(String.format("%s : %s", car.getName(), car.getDistance())));
		System.out.println();
	}

	private static void printResultWinner(List<String> winners) {
		System.out.println(String.format(Message.MSG_WINNER, String.join(", ", winners)));
	}

}
