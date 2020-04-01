package racing.view;

import racing.domain.RacingGame;
import racing.vo.Cars;
import racing.vo.MoveCount;

import java.util.Scanner;

public class InputView {

	private final MoveCount times;
	private final Cars cars;
	
	public InputView() {
		Scanner scanner = new Scanner(System.in);
		this.cars = new Cars(inputCarList(scanner));
		this.times = new MoveCount(inputMoveCount(scanner));
	}
	
	private String inputCarList(final Scanner scanner) {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return scanner.nextLine();
	}

	private int inputMoveCount(final Scanner scanner) {
		System.out.println("시도할 회수는 몇 회 인가요?");
		return scanner.nextInt();
	}
	
	public RacingGame createNewGame() {
		return new RacingGame(cars, times);
	}
}
