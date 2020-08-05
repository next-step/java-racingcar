package simpleracing;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import simpleracing.execute.Car;
import simpleracing.execute.CarGame;
import simpleracing.execute.CarRacingGame;
import simpleracing.execute.Direction;
import simpleracing.output.CarRacingOutput;

@DisplayName("레이싱 게임 비즈니스 로직 테스트")
public class CarRacingBusinessTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	private CarRacingOutput carRacingOutput;

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		carRacingOutput = new CarRacingOutput();
	}

	@AfterEach
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@DisplayName("랜덤 값 대로 전진에 대한 값이 정확히 나오는지 테스트")
	@ParameterizedTest
	@MethodSource("carParameterProviderForDirection")
	public void directionTest(int carNumber, List<Integer> randomValues, Direction[] directionsParam) {
		Car car = new Car(carNumber, new CarRacingGame());
		randomValues.stream()
					.forEach(value -> {
						car.addGameResult(value);
					});
		List<Direction> directions = car.getDirections();
		assertThat(directions).containsExactly(directionsParam);
	}

	@DisplayName("랜덤으로 생성되는 값 대로 출력하는지 테스트")
	@ParameterizedTest
	@MethodSource("carParameterProviderForOutput")
	public void outputTest1(Car car, String expect, List<Integer> randomValues) {
		int count = randomValues.size();

		IntStream.range(0, count)
				 .forEach(i -> {
					 car.addGameResult(randomValues.get(i));
					 carRacingOutput.addRenderingView(Arrays.asList(car));
				 });

		carRacingOutput.render();
		assertThat(expect).isEqualTo(outContent.toString());
	}

	@DisplayName("랜덤으로 생성되는 값 대로 출력하는지 테스트2")
	@ParameterizedTest
	@MethodSource("carParameterProviderForOutput2")
	public void outputTest2(List<Car> cars, String expects, List<List<Integer>> randomValues) {
		int countOfCar = cars.size();
		int randomValueSize = randomValues.get(0).size();

		IntStream.range(0, randomValueSize)
				 .forEach(i -> {
					 IntStream.range(0, countOfCar)
							  .forEach(j -> {
								  cars.get(j).addGameResult(randomValues.get(j).get(i));
							  });
					 carRacingOutput.addRenderingView(cars);
				 });

		carRacingOutput.render();
		assertThat(outContent.toString()).isEqualTo(expects);
	}

	private static Stream<Arguments> carParameterProviderForDirection() {
		Direction[] directions1 = {
				Direction.STOP, Direction.ADVANCE, Direction.ADVANCE, Direction.STOP,
				Direction.STOP, Direction.STOP, Direction.ADVANCE, Direction.STOP
		};

		Direction[] directions2 = {
				Direction.ADVANCE, Direction.ADVANCE, Direction.ADVANCE, Direction.STOP,
				Direction.STOP, Direction.ADVANCE, Direction.ADVANCE, Direction.ADVANCE
		};

		Direction[] directions3 = {
				Direction.ADVANCE, Direction.STOP, Direction.STOP, Direction.STOP,
				Direction.ADVANCE, Direction.ADVANCE, Direction.ADVANCE, Direction.STOP};

		return Stream.of(
				Arguments.arguments(1, Arrays.asList(1, 4, 10, 3, 1, 0, 9, 2), directions1),
				Arguments.arguments(2, Arrays.asList(10, 5, 7, 3, 0, 10, 10, 10), directions2),
				Arguments.arguments(3, Arrays.asList(8, 1, 2, 3, 4, 10, 8, 3), directions3)
						);
	}


	private static Stream<Arguments> carParameterProviderForOutput() {
		String result1 = "실행 결과\n" + "\n" + "\n" + "-\n" + "\n" + "--\n" + "\n" + "--\n" + "\n" + "--\n" + "\n"
						 + "--\n" + "\n" + "---\n" + "\n" + "---\n" + "\n" + "\n";
		String result2 = "실행 결과\n" + "-\n" + "\n" + "--\n" + "\n" + "---\n" + "\n" + "---\n" + "\n" + "---\n" + "\n"
						 + "----\n" + "\n" + "-----\n" + "\n" + "------\n" + "\n" + "\n";
		String result3 = "실행 결과\n" + "-\n" + "\n" + "-\n" + "\n" + "-\n" + "\n" + "-\n" + "\n" + "--\n" + "\n"
						 + "---\n" + "\n" + "----\n" + "\n" + "----\n" + "\n" + "\n";
		CarGame carRacingGame = new CarRacingGame();

		return Stream.of(
				Arguments.arguments(new Car(1, carRacingGame), result1, Arrays.asList(1, 4, 10, 3, 1, 0, 9, 2)),
				Arguments.arguments(new Car(2, carRacingGame), result2, Arrays.asList(10, 5, 7, 3, 0, 10, 10, 10)),
				Arguments.arguments(new Car(3, carRacingGame), result3, Arrays.asList(8, 1, 2, 3, 4, 10, 8, 3))
						);
	}

	private static Stream<Arguments> carParameterProviderForOutput2() {
		String result = "실행 결과\n" + "\n" + "-\n" + "-\n" + "\n" + "-\n" + "--\n" + "-\n" + "\n" + "--\n"
						+ "---\n" + "-\n" + "\n" + "--\n" + "---\n" + "-\n" + "\n" + "--\n" + "---\n"
						+ "--\n" + "\n" + "--\n" + "----\n" + "---\n" + "\n" + "---\n" + "-----\n"
						+ "----\n" + "\n" + "---\n" + "------\n" + "----\n" + "\n" + "\n";

		CarGame carRacingGame = new CarRacingGame();

		return Stream.of(
				Arguments.arguments(Arrays.asList(new Car(1, carRacingGame), new Car(2, carRacingGame), new Car(3, carRacingGame)),
									result,
									Arrays.asList(Arrays.asList(1, 4, 10, 3, 1, 0, 9, 2),
												  Arrays.asList(10, 5, 7, 3, 0, 10, 10, 10),
												  Arrays.asList(8, 1, 2, 3, 4, 10, 8, 3)))
						);
	}
}
