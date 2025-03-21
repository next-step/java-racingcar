package racingcar.domain;

import java.util.List;

public class RaceResult {
	private RaceResult() {
		throw new UnsupportedOperationException("유틸 클래스의 인스턴스를 생성할 수 없습니다.");
	}

	public static int findMaxLocation(List<CarInfo> cars) {
		return cars.stream()
			.mapToInt(CarInfo::location)
			.max()
			.orElseThrow(() -> new RuntimeException("자동차가 존재하지 않습니다."));
	}

	public static List<String> determineWinner(List<CarInfo> cars) {
		int maxLocation = findMaxLocation(cars);
		return cars.stream()
			.filter(car -> car.isSameLocation(maxLocation))
			.map(CarInfo::name)
			.toList();
	}
}
