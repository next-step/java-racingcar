package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

	private List<String> winners;

	public List<String> findWinners(List<Car> participants) {
		int max = getMax(participants);
		winners = participants.stream()
				.filter(car -> car.getPosition() == max)
				.map(Car::getName)
				.collect(Collectors.toList());
		return winners;
	}

	public int getMax(List<Car> participants) {
		Collections.sort(participants, (o1, o2) ->
				o2.getPosition() - o1.getPosition()
		);
		return participants.get(0).getPosition();
	}

	public List<String> getWinners() {
		return winners;
	}
}
