package game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
	private final List<RacingCar> racingCars = new ArrayList<>();
	private final List<RacingCar> winners = new ArrayList<>();

	private final static int SUBSTRING_START_INDEX = 0;
	private final static int SUBSTRING_END_INDEX = 1;
	private final static String DELIMITER = ",";


	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame();
		racingGame.startGame();
	}

	public void startGame() {
		Scanner sc = new Scanner(System.in);

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carNames = sc.next();

		for (String carName : carNames.split(",")) {
			this.racingCars.add(new RacingCar(carName));
		}

		System.out.println("시도할 회수는 몇회인가요?");
		int destinationNumber = sc.nextInt();

		System.out.println("");
		System.out.println("실행결과");

		for (int i = 0; i < destinationNumber; i++) {
			racingCarRun();
		}
		findWinners();
		System.out.println(getWinnersNames() + "가 최종 우승했습니다.");
	}

	private void racingCarRun() {
		for (RacingCar racingCar : this.racingCars) {
			racingCar.move();
			displayCarProgress(racingCar);
		}
		System.out.println("");
	}

	private void displayCarProgress(RacingCar racingCar) {
		System.out.println(racingCar.getCarNameWrapper().getCarName() + ": " + racingCar.getDisplacement().displayDistance());
	}

	private void findWinners() {
		List<RacingCar> participants = new ArrayList<>(this.racingCars);
		participants.sort((participant1, participant2) -> (Integer.compare(participant2.getDisplacement().getDistance(), participant1.getDisplacement().getDistance())));

		for (RacingCar racingCar : racingCars) {
			addWinner(participants.get(0).getDisplacement().getDistance(), racingCar);
		}
	}

	private String getWinnersNames() {
		StringBuilder winnerNames = new StringBuilder();
		for (RacingCar winner : winners) {
			winnerNames.append(winner.getCarNameWrapper().getCarName()).append(DELIMITER);
		}
		return winnerNames.substring(SUBSTRING_START_INDEX, winnerNames.length() - SUBSTRING_END_INDEX);
	}

	private void addWinner(int winDistance, RacingCar racingCar) {
		if (racingCar.getDisplacement().getDistance() == winDistance) {
			this.winners.add(racingCar);
		}
	}
}
