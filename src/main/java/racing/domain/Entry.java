package racing.domain;

import racing.vo.RacingRecord;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 게임에 참여한 선수를 관리하는 일급 콜렉션
 */
public class Entry {

	private List<RacingCar> items;

	public Entry(List<RacingCar> items){
		// shallow copy
		this.items = items.stream().collect(Collectors.toList());
	}

	public int size() {
		return items.size();
	}

	public List<RacingRecord> drive() {
		return items.stream()
				.map(car -> {
					car.move();
					return new RacingRecord(car.getDriverName(), car.getMileage());
				}).collect(Collectors.toList());
	}

	public List<RacingRecord> getWinners() {

		int longestMileage = items.stream()
				.sorted(Comparator.reverseOrder())
				.findFirst()
				.orElseThrow(IllegalStateException::new)
				.getMileage();

		return items.stream()
				.filter(car -> car.getMileage() >= longestMileage)
				.map(car -> new RacingRecord(car.getDriverName(), car.getMileage()))
				.collect(Collectors.toList());
	}
}
