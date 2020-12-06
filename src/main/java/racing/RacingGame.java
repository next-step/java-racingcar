package racing;

import racing.model.Car;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.*;

public class RacingGame {

	private static final int MAX_RANDOM_BOUND = 10;

	ResultView resultView = new ResultView();

	Scanner scanner = new Scanner(System.in);

	Random random = new Random();

	public void start() {
		InputView inputView = initInputView();
		List<Car> cars = prepareInitRacingCar(inputView.getInputName());
		startRacing(cars, inputView.getPlayCount());
		printWinner(cars);
	}

	public void printWinner(List<Car> cars) {
		List<Integer> positionList = new ArrayList<>();
		Map<Integer, String> map = new HashMap<>();
		for (Car car : cars) {
			positionList.add(car.getForwardPosition());
			map.merge(car.getForwardPosition(), car.getName(), (k, v) -> map.get(car.getForwardPosition()) + "," + car.getName());
		}
		Integer maxPosition = Collections.max(positionList);
		System.out.println(map.get(maxPosition) + "가 최종 우승했습니다.");
	}

	public void startRacing(List<Car> cars, int playCount) {
		for (int i = 0; i < playCount; i++) {
			speedUpForPlayCount(cars);
			System.out.println();
		}
	}

	//https://github.com/next-step/java-racingcar/pull/1623#discussion_r536464659
	public void speedUpForPlayCount(List<Car> cars) {
		for (Car car : cars) {
			car.speedUp(go());
			resultView.print(car.getName(), car.getForwardPosition());
		}
	}

	private int go(){
		return random.nextInt(MAX_RANDOM_BOUND);
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