package racing.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;
import racing.model.*;
import racing.model.policy.BooleanForward;
import racing.model.policy.FourUpperForward;
import racing.model.policy.TwoUnderForward;
import racing.model.policy.inter.ForwardPolicy;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.*;

public class RacingGame {

	private static final String CAR_NAME_DELIMITER = ",";

	private Scanner scanner = new Scanner(System.in);

	private ResultView resultView = new ResultView();

	private InputView inputView = new InputView();

	private String inputName;

	private int playCount;

//	private ForwardPolicy forwardPolicy = new FourUpperForward();
//	private ForwardPolicy forwardPolicy = new TwoUnderForward();
	private ForwardPolicy forwardPolicy = new BooleanForward();

	public void start() {
		printInputUI();

		FinalRacingResult finalWinner = racing(this.inputName, this.playCount);

		printFinalWinnerUI(finalWinner.getWinnerName());
	}

	private void printInputUI() {
		inputView.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		this.inputName = scanner.next();
		inputView.print("시도할 회수는 몇 회 인가요?");
		this.playCount = scanner.nextInt();
	}

	public FinalRacingResult racing(String inputName, int playCount) {
		List<Car> cars = prepareInitRacingCar(inputName);
		startRacing(cars, playCount);
		FinalRacingResult finalWinner = findWinner(cars);
		return finalWinner;
	}

	private List<Car> prepareInitRacingCar(String inputName) {
		String[] carNames = inputName.split(CAR_NAME_DELIMITER);
		List<Car> cars = new ArrayList<>();
		for (String name : carNames) {
			cars.add(new Car(name));
		}
		return cars;
	}

	private void startRacing(List<Car> cars, int playCount) {
		for (int i = 0; i < playCount; i++) {
			speedUpForPlayCount(cars);
			System.out.println();
		}
	}

	//https://github.com/next-step/java-racingcar/pull/1623#discussion_r536464659
	private void speedUpForPlayCount(List<Car> cars) {
		for (Car car : cars) {
			car.speedUp(forwardPolicy);
			resultView.print(car.getName(), car.getForwardPosition());
		}
	}

	private FinalRacingResult findWinner(List<Car> cars) {
		List<Integer> positionList = new ArrayList<>();
		Map<Integer, String> map = new HashMap<>();
		for (Car car : cars) {
			positionList.add(car.getForwardPosition());
			map.merge(car.getForwardPosition(), car.getName(), (k, v) -> map.get(car.getForwardPosition()) + CAR_NAME_DELIMITER + car.getName());
		}
		Integer maxPosition = Collections.max(positionList);
		String winnerName = map.get(maxPosition);

		FinalRacingResult finalRacingResult = new FinalRacingResult(maxPosition, map, winnerName);
		return finalRacingResult;
	}

	private void printFinalWinnerUI(String winnerName) {
		resultView.printFinalWinner(winnerName);
	}

}