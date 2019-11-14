package step3;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {

	private static final int BOUNDARY_NUMBER = 4;

	private static final int MAX_NUMBER = 10;

	public static void main(String[] args) throws IOException {
		RacingGame racingGame = new RacingGame();
		racingGame.start();
	}

	void start() throws IOException {
		RacingInfo racingInfo = setRacingInfo();
		doRacing(racingInfo);
	}

	RacingInfo setRacingInfo() throws IOException {
		List<Car> participants = registerParticipants(InputView.getParticipantNames());

		RacingInfo racingInfo = new RacingInfo();
		racingInfo.setParticipants(participants);
		racingInfo.setTurnCount(InputView.getTurnCount());

		return racingInfo;
	}

	List<Car> registerParticipants(String[] participantNames) {
		List<Car> participants = new ArrayList<>();

		for (String name : participantNames) {
			participants.add(new Car(name));
		}

		return participants;
	}

	void doRacing(RacingInfo racingInfo) {
		int turnCount = racingInfo.getTurnCount();

		while (turnCount-- > 0) {
			List<Car> present = doTurn(racingInfo.getParticipants());
			ResultView.printRacingStatus(present);
		}

		List<String> winners = findWinner(racingInfo.getParticipants());
		ResultView.printWinner(winners);
	}

	List<Car> doTurn(List<Car> participants) {
		for (Car car : participants) {
			car.move(isMove());
		}

		return participants;
	}

	boolean isMove() {
		return new Random().nextInt(MAX_NUMBER) >= BOUNDARY_NUMBER;
	}

	List<String> findWinner(List<Car> participants) {
		List<Car> sortedParticipants = sortParticipants(participants);
		return getWinners(sortedParticipants);
	}

	List<Car> sortParticipants(List<Car> participants) {
		participants.sort((o1, o2) -> o2.getPosition() - o1.getPosition());
		return participants;
	}

	List<String> getWinners(List<Car> sortedParticipants) {
		int max = getMax(sortedParticipants);
		return sortedParticipants.stream()
				.filter(car -> car.getPosition() == max)
				.map(Car::getName)
				.collect(Collectors.toList());
	}

	int getMax(List<Car> sortedParticipants) {
		return sortedParticipants.get(0).getPosition();
	}

}
