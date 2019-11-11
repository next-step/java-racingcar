package step2;

import java.util.Random;

public class RacingGame {

	private static final int LIMIT_NUMBER = 10;

	private static final int DELIMITER_NUMBER = 4;

	public static void main(String[] args) {
		UserInput userInput = RacingGame.getUserInput();
		Car[] cars = RacingGame.initDataStructure(userInput.getCarCount());
		RacingGame.doRacing(cars, userInput.getMoveCount());
	}

	// 사용자 입력값 처리
	static UserInput getUserInput() {
		return InputView.getUserInput();
	}

	// Car 객체를 담을 배열 생성 및 초기화
	static Car[] initDataStructure(int carCount) {
		Car[] cars = new Car[carCount];
		for (int i = 0, len = cars.length; i < len; i++) {
			cars[i] = new Car();
		}
		return cars;
	}

	// 레이싱 전체를 진행
	static int doRacing(Car[] cars, int moveCount) {
		while (moveCount-- > 0) {
			ResultView.printCars(processRacingTurn(cars));
		}
		return moveCount;
	}

	// 레이싱 한 턴을 진행
	static Car[] processRacingTurn(Car[] cars) {
		for (Car car : cars) {
			car.move(isMove());
		}
		return cars;
	}

	// 이동 조건을 만족하는지 확인
	static boolean isMove() {
		Random random = new Random();
		return random.nextInt(LIMIT_NUMBER) >= DELIMITER_NUMBER;
	}

}