package step4.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
	private static final String SPLIT_STANDARD = ",";

	private final List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void init(String nameListString) {
		String[] names = nameListString.split(SPLIT_STANDARD);
		Arrays.stream(names)
				.map(Car::new)
				.forEachOrdered(cars::add);
	}

	public List<Car> getCars() {
		return cars;
	}
}
