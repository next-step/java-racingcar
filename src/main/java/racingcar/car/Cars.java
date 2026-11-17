package racingcar.car;

import java.util.ArrayList;
import java.util.List;

import racingcar.generator.NumberGenerator;

public class Cars {

	private List<Car> cars = new ArrayList<>();

	public Cars(int carCount) {
		for (int i = 0; i < carCount; i++) {
			cars.add(new Car());
		}
	}

	public void play(NumberGenerator numberGenerator) {
		for (int i = 0; i < cars.size(); i++) {
			cars.get(i).go(numberGenerator.generate());
		}
	}

	public List<Integer> getPositions() {
		List<Integer> positions = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			positions.add(cars.get(i).getPosition());
		}
		return positions;
	}
}
