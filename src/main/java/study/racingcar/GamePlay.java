package study.racingcar;

import study.racingcar.controller.GameController;
import study.racingcar.domain.MoveStrategy;
import study.racingcar.domain.RandomNumberStrategy;

public class GamePlay {
	public static void main(String[] args) {
		MoveStrategy strategy = new RandomNumberStrategy();
		GameController.start(strategy);
	}
}
