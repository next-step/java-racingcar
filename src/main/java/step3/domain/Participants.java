package step3.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Participants {

	private List<Car> participants;

	public Participants() {
		this.participants = new ArrayList<>();
	}

	public List<Car> register(String[] participantNames) {
		for (String name : participantNames) {
			participants.add(new Car(name));
		}

		return participants;
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

	public List<String> getWinners() {
		int max = getMax();
		return participants.stream()
				.filter(car -> car.getPosition() == max)
				.map(Car::getName)
				.collect(Collectors.toList());
	}

	public int getMax() {
		Collections.sort(participants, (o1, o2) ->
				o2.getPosition() - o1.getPosition()
		);
		return participants.get(0).getPosition();
	}

	// Q) Getter, Setter 메서드 위치는 어디가 적절하다고 생각하시나요?
	public List<Car> getParticipants() {
		return participants;
	}
}
