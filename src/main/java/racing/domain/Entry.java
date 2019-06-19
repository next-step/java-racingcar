package racing.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 게임에 참여한 선수를 관리하는 일급 콜렉션
 */
public class Entry {

	private List<RacingCar> players;

	public Entry(List<RacingCar> players){
		// shallow copy
		this.players = players.stream().collect(Collectors.toList());
	}

	public int size() {
		return players.size();
	}

	public List<Integer> drive() {
		return players.stream()
				.map(car -> {
					car.move();
					return car.getMileage();
				}).collect(Collectors.toList());
	}
}
