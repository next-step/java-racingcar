package step3.domain;

import java.util.*;

public class Participants {

	private List<Car> participants;

	public Participants(String[] participantNames) {
		participants = new ArrayList<>();

		for (String name : participantNames) {
			participants.add(new Car(name));
		}
	}

	public List<Car> move(int boundaryNumber, int maxNumber) {
		for (Car car : participants) {
			car.move(isMove(boundaryNumber, maxNumber));
		}

		return participants;
	}

	public boolean isMove(int boundaryNumber, int maxNumber) {
		return new Random().nextInt(maxNumber) >= boundaryNumber;
	}

	public List<Car> getParticipants() {
		return participants;
	}
}
