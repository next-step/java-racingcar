package study.racingcar.view;

import java.util.List;

import study.racingcar.domain.Position;
import study.racingcar.domain.RacingGame;

public class ResultView {

	private static final String DASH = "-";
	private static final String PLAY_RESULT_MESSAGE = "실행결과";
	private static final String SEPARATOR = "";

	private ResultView() {
		throw new AssertionError();
	}

	public static void printCurrentRacingResult(RacingGame game) {
		List<Position> positions = game.carsCurrentPosition();
		printPosition(positions);
	}

	public static void printStart() {
		System.out.println(PLAY_RESULT_MESSAGE);
	}

	public static void printPosition(List<Position> positions) {
		for (Position position : positions) {
			printRace(position);
		}
		newLine();
	}

	public static void newLine() {
		System.out.println(SEPARATOR);
	}

	private static void printRace(Position position) {
		for (int i = 0; i < position.valueOfPosition(); i++) {
			System.out.print(DASH);
		}
		newLine();
	}




}
