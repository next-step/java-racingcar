package step3.service;

import static step3.view.InputView.*;
import static step3.view.ResultView.*;

import java.util.Random;

import step3.domain.Car;

public class RacingGame {
	Car[] cars;
	int moveCount;
	Random random = new Random();

	public static void main(String[] args) {
		int carCount = getCarCount();
		int moveCount = getMoveCount();
		RacingGame game = new RacingGame();
		game.race(carCount, moveCount);
	}

	public void race(int carCount, int moveCount) {
		this.setRaceInfo(carCount, moveCount);
		printStart();
		this.moveCars();
	}

	public void setRaceInfo(int carCount, int moveCount) {
		this.cars = new Car[carCount];
		this.moveCount = moveCount;
		for (int i = 0; i < carCount; i++) {
			cars[i] = new Car();
		}
	}

	private void moveCars() {
		for (int i = 0; i < moveCount; i++) {
			moveCarsOnce();
		}
	}

	private void moveCarsOnce() {
		for (Car car : this.cars) {
			car.move(random.nextInt(10));
		}
		printCurrentPosition(this.cars);
	}

	public Car[] getCars() {
		return cars;
	}
}
