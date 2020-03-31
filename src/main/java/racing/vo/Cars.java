package racing.vo;

import racing.domain.object.Car;
import racing.exception.EmptyInputDataException;
import racing.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {

	private static final int RANDOM_LIMIT = 10;
	private static final int IS_CASE_FORWARD_MIN = 4;
	private static final int FORWARD_UNIT = 1;

	private static final String TOKEN_SPLIT_FOR_CAR_LIST = ",";
	private static final String DELIMITER = ", ";
	private static final String NEW_LINE_TOKEN = "\n";

	private static final Random RANDOM_FOR_MOVE = new Random();

	private final List<Car> carList;
	
	public Cars(final String carList) {

		this.carList = new ArrayList<>();
		
		if ( StringUtils.isBlank(carList) ) {
			throw new EmptyInputDataException();
		}
		String[] cars = carList.split(TOKEN_SPLIT_FOR_CAR_LIST);
		makeCarList(cars);
	}

	public Cars(final List<Car> carList) {
		this.carList = carList;
	}

	private void makeCarList(String[] cars) {
		for (String name : cars) {
			carList.add(new Car(name));
		}
	}

	public boolean isEmpty() {
		return carList == null || carList.isEmpty();
	}

	public Cars move() {
		for (Car car : carList) {
			car.move(isCaseForward() ? FORWARD_UNIT : 0);
		}
		return this;
	}

	private boolean isCaseForward() {
		return RANDOM_FOR_MOVE.nextInt(RANDOM_LIMIT) >= IS_CASE_FORWARD_MIN;
	}

	public Cars getWinner() {
		return new Cars(
				carList.stream()
						.filter(car -> car.isWinner(getMaxPosition()))
						.collect(Collectors.toList())
		);
	}

	public String serializeName() {
		if ( this.isEmpty() ) {
			return "";
		}
		return carList.stream()
				.map(Car::getName)
				.collect(Collectors.joining(DELIMITER));
	}

	public String serialize() {
		StringBuilder sb = new StringBuilder();
		for (Car unit : carList) {
			sb.append(unit.toString()).append(NEW_LINE_TOKEN);
		}
		return sb.toString();
	}

	private int getMaxPosition() {
		return carList.stream()
				.mapToInt(Car::getPosition)
				.max()
				.orElse(0);
	}

	@Override
	public boolean equals(Object that) {
		return this.carList.equals( ((Cars)that).carList );
	}
}
