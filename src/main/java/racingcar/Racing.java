package racingcar;

import java.util.ArrayList;

public class Racing {

	public ArrayList<Car> cars = new ArrayList<>();

	public Racing(int number, int count) {

		for (int i = 0; i < number; i++) {
			cars.add(new Car());
		}
	}

	public void play(int number) {
		for (int i = 0; i < number; i++) {
			for (Car car : cars) {
				int randomNumber = (int) (Math.random() * 10);
				System.out.println(car.move(randomNumber));
			}
			System.out.println();
		}
		System.out.println();
	}
}
