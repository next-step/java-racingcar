package racinggame.model;

import racinggame.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
	private static final int START = 0;
	private final List<String> printString;

	public RacingGame() {
		this.printString = new ArrayList<>();
	}

	public List<String> startGame() {
		Scanner sc = new Scanner(System.in);

		int carCount = InputView.input(sc,"자동차 대수는 몇 대 인가요?");
		int time = InputView.input(sc,"시도할 회수는 몇 회 인가요?");

		Cars cars = new Cars(carCount);
		return view(cars, time);
	}

	private List<String> view(Cars cars, int time) {
		for (int i = START; i < time; i++) {
			cars.carsMove();
			printString.addAll(cars.viewCarsStatus());
		}
		return printString;
	}
}
