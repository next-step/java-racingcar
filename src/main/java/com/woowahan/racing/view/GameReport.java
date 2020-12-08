package com.woowahan.racing.view;

import java.util.List;
import java.util.stream.Collectors;

import com.woowahan.racing.constant.Message;
import com.woowahan.racing.model.Car;
import com.woowahan.racing.model.GameResult;

public class GameReport {

	private static final String DISTANCE_CHAR = "-";
	private static final String WINNER_DELIMITER = ", ";

	public static String report(List<GameResult> gameResults, List<String> winners) {
		String result = Message.MSG_REPORT_HEADER;
		result += reportAllGame(gameResults);
		result += Message.MSG_LINE_DOUBLE_BREAK;
		result += reportWinner(winners);
		return result;
	}

	private static String reportAllGame(List<GameResult> gameResults) {
		return gameResults.stream()
			.map(GameReport::reportEachGame)
			.collect(Collectors.joining(Message.MSG_LINE_DOUBLE_BREAK));
	}

	private static String reportWinner(List<String> winners) {
		return String.format(Message.MSG_WINNER, String.join(WINNER_DELIMITER, winners));
	}

	private static String reportEachGame(GameResult gameResult) {
		List<Car> cars = gameResult.getCars();
		return cars.stream()
			.map(car -> String.format(Message.MSG_EACH_GAME_RESULT, car.getName(), reportDistance(car.getDistance())))
			.collect(Collectors.joining(Message.MSG_LINE_BREAK));
	}

	private static String reportDistance(int distance) {
		String result = "";
		for (int i = 0; i < distance; i++) {
			result += DISTANCE_CHAR;
		}
		return result;
	}
}
