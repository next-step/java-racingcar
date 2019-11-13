package step3;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {

	private static final int BOUNDARY_NUMBER = 4;

	private static final int MAX_NUMBER = 10;

	private int turnCount;

	private List<Car> participants;

	private List<String> winners;

	public RacingGame() {
		this.participants = new ArrayList<>();
	}

	public static void main(String[] args) throws IOException {
		RacingGame racingGame = new RacingGame();
		racingGame.start();
	}

	private void start() throws IOException {
		this.participants = registParticipants(InputView.getParticipantNames());
		this.turnCount = InputView.getTurnCount();
		int remainTurn =  doRacing();
	}

	List<Car> registParticipants(String[] participantNames) {
		for (String name : participantNames) {
			this.participants.add(new Car(name));
		}
		return this.participants;
	}

	int doRacing() {
		while (this.turnCount-- > 0) {
			List<Car> present = doTurn();
			present = ResultView.printRacingStatus(participants);
		}
		findWinner();
		ResultView.printWinner(winners);

		return this.turnCount;
	}

	List<Car> doTurn() {
		for (Car car : this.participants) {
			int position = car.move(isMove());
		}
		return this.participants;
	}

	boolean isMove() {
		return new Random().nextInt(MAX_NUMBER) >= BOUNDARY_NUMBER;
	}

	void findWinner() {
		List<Car> sortedParticipants = sortParticipants();
		int max = getMax();
		List<String> winnerNames = getWinners(max);
	}

	List<Car> sortParticipants() {
		this.participants.sort((o1, o2) -> o2.getPosition() - o1.getPosition());
		return this.participants;
	}

	int getMax() {
		return this.participants.get(0).getPosition();
	}

	List<String> getWinners(int max) {
		winners = participants.stream()
				.filter(car -> car.getPosition() == max)
				.map(Car::getName)
				.collect(Collectors.toList());
		return winners;
	}

}
