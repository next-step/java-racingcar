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

	/*
		Q) Winner를 이용해서 크게 다른 처리를 하는 부분이 없어서
		따로 일급컬렉션 객체를 만들지 않고 participants 객체에서
		전부 처리했는데 어떻게 생각하시는지 궁금합니다.
	 */
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

	/*
		Q) Getter, Setter 메서드 위치는 어디가 적절하다고 생각하시나요?
		생성자랑 getter, setter를 사용자 정의 메서드보다 위쪽에 두자니
		사용자 정의 메서드가 멀리 있어서 보기 불편하다는 느낌이 들어서요.
	 */
	public List<Car> getParticipants() {
		return participants;
	}
}
