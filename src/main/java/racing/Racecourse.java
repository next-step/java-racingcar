package racing;

import java.util.ArrayList;
import java.util.List;

public class Racecourse {
	private final List<Car> cars = new ArrayList<>();
	private int count;

	public void init(Command command) {
		cars.clear();

		this.count = command.getCount();
		for (String name : command.getNames()) {
			cars.add(new Car(name));
		}
	}

	public int getCarsSize() {
		return cars.size();
	}

	public int getCount() {
		return count;
	}

	public void run() {
		for (int i = 0; i < count; i++) {
			moveAll();
			print();
		}
	}

	public void moveAll() {
		for (Car car : cars) {
			car.move(new MoveCondition());
		}
	}

	public void print() {
		for (Car car : cars) {
			car.print();
		}
		System.out.println();
	}
}
