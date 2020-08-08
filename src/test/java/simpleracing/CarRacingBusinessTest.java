package simpleracing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import simpleracing.execute.Car;
import simpleracing.execute.CarGame;
import simpleracing.execute.CarRacingGame;
import simpleracing.execute.Direction;

@DisplayName("레이싱 게임 비즈니스 로직 테스트")
public class CarRacingBusinessTest {

	@DisplayName("랜덤 값 대로 전진에 대한 값이 정확히 나오는지 테스트1")
	@ParameterizedTest
	@MethodSource("carParameterProvider1ForDirection")
	public void directionTest1(int carNumber, String name, List<Direction> directions, String except) {
		Car car = new Car(carNumber, name, new CarRacingGame());
		directions.stream()
				  .forEach(direction -> car.move(direction));

		assertThat(car.getLocation()).isEqualTo(except);
	}

	@DisplayName("랜덤 값 대로 전진에 대한 값이 정확히 나오는지 테스트2")
	@ParameterizedTest
	@MethodSource("carParameterProvider2ForDirection")
	public void directionTest2(int carNumber, String name, List<Integer> randomValues, String except) {
		Car car = new Car(carNumber, name, new CarRacingGame());
		randomValues.stream()
					.forEach(value -> car.move(Direction.getBy(value)));

		assertThat(car.getLocation()).isEqualTo(except);
	}

	@DisplayName("랜덤으로 생성되는 값 대로 차의 위치가 옮겨졌는지 테스트")
	@ParameterizedTest
	@MethodSource("carParameterProviderForOutput")
	public void outputTest2(List<Car> cars, List<List<Integer>> randomValuesList, String[] expects) {
		int tryCount = randomValuesList.get(0).size();

		IntStream.range(0, tryCount)
				 .forEach(i -> {
					 IntStream.range(0, cars.size())
							  .forEach(j -> {
								  cars.get(j).move(Direction.getBy(randomValuesList.get(j).get(i)));
							  });
				 });

		IntStream.range(0, cars.size())
				 .forEach(i -> {
					 assertThat(cars.get(i).getLocation()).isEqualTo(expects[i]);
				 });
	}

	private static Stream<Arguments> carParameterProvider1ForDirection() {
		List<Direction> directions1 = Arrays.asList(Direction.STOP, Direction.ADVANCE, Direction.ADVANCE, Direction.STOP,
													Direction.STOP, Direction.STOP, Direction.ADVANCE, Direction.STOP);

		List<Direction> directions2 = Arrays.asList(Direction.ADVANCE, Direction.ADVANCE, Direction.ADVANCE, Direction.STOP,
													Direction.STOP, Direction.ADVANCE, Direction.ADVANCE, Direction.ADVANCE);

		List<Direction> directions3 = Arrays.asList(Direction.ADVANCE, Direction.STOP, Direction.STOP, Direction.STOP,
													Direction.ADVANCE, Direction.ADVANCE, Direction.ADVANCE, Direction.STOP);

		return Stream.of(
				Arguments.arguments(1, "pobi", directions1, "---"),
				Arguments.arguments(2, "crong", directions2, "------"),
				Arguments.arguments(3, "honux", directions3, "----")
						);
	}

	private static Stream<Arguments> carParameterProvider2ForDirection() {
		return Stream.of(
				Arguments.arguments(1, "pobi", Arrays.asList(1, 4, 10, 3, 1, 0, 9, 2), "---"),
				Arguments.arguments(2, "crong", Arrays.asList(10, 5, 7, 3, 0, 10, 10, 10), "------"),
				Arguments.arguments(3, "honux", Arrays.asList(8, 1, 2, 3, 4, 10, 8, 3), "----")
						);
	}

	private static Stream<Arguments> carParameterProviderForOutput() {
		CarGame carRacingGame = new CarRacingGame();

		return Stream.of(
				Arguments.arguments(
						Arrays.asList(new Car(1, "pobi", carRacingGame),
									  new Car(2, "crong", carRacingGame),
									  new Car(3, "honux", carRacingGame)),
						Arrays.asList(Arrays.asList(1, 4, 10, 3, 1, 0, 9, 2),
									  Arrays.asList(10, 5, 7, 3, 0, 10, 10, 10),
									  Arrays.asList(8, 1, 2, 3, 4, 10, 8, 3)),
						new String[]{"---", "------", "----"})

						);
	}
}
