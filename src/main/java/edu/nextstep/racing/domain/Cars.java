package edu.nextstep.racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = Collections.unmodifiableList(cars);
	}

	public void moveAll() {
		for (Car car : cars) {
			car.move();
		}
	}

	public Cars getHeadCars() {
		if (cars == null || cars.isEmpty()) {
			return new Cars(Collections.emptyList());
		}

		PriorityQueue<Car> orderedCars = new PriorityQueue<>(Collections.reverseOrder()); // 역순이어야 내림차순으로 정렬됨.
		orderedCars.addAll(cars);

		List<Car> headCars = new ArrayList<>();
		Car head = orderedCars.peek();
		while (!orderedCars.isEmpty() && orderedCars.peek().compareTo(head) == 0) {
			headCars.add(orderedCars.poll());
		}

		return new Cars(headCars);
	}

	public List<Car> getAll() {
		return cars;
	}
}
