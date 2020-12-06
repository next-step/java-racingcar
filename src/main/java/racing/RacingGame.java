package racing;

import racing.model.Car;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {

	private static final int MAX_RANDOM_BOUND = 10;

	Random random = new Random();

	ResultView resultView = new ResultView();

	Scanner scanner = new Scanner(System.in);

	public void start() {
		InputView inputView = initInputView();

		List<Car> cars = prepareInitRacingCar(inputView.getInputName());
		startRacing(cars, inputView.getPlayCount());
	}

	public void startRacing(List<Car> cars, int playCount) {
		for (int i = 0; i < playCount; i++) {
			speedUpForPlayCount(cars);
			System.out.println();
		}
	}

	//todo 전략패턴
	//https://github.com/next-step/java-racingcar/pull/1623#discussion_r536464659
	public void speedUpForPlayCount(List<Car> cars) {
		for (Car car : cars) {
			car.speedUp(random.nextInt(MAX_RANDOM_BOUND));
			resultView.print(car.getName(), car.getForwardPosition());
		}
	}

	public List<Car> prepareInitRacingCar(String inputName) {
		String[] carNames = inputName.split(",");
		List<Car> cars = new ArrayList<>();
		for (String name : carNames) {
			cars.add(new Car(name));
		}
		return cars;

	}

	private InputView initInputView() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String inputName = scanner.next();
		System.out.println(inputName);
		String[] carNames = inputName.split(",");

		System.out.println("시도할 회수는 몇 회 인가요?");
		int playCount = scanner.nextInt();
		System.out.println(playCount);

		return new InputView(inputName, carNames.length, playCount);
	}


}