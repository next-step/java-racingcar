package racinggame.comparator;

import java.util.Comparator;
import racinggame.domain.Car;

public class WinnerComparator implements Comparator<Car> {

	@Override
	public int compare(Car car1, Car car2) {
		return car1.compareTo(car2);
	}
}