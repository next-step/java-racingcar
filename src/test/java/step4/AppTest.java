package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

	private Car car;
	private Car car2;
	private InputConsole inputConsole;
	private List<Car> cars;
	private Race race;
	private NumberContainer numberContainer;

	@BeforeEach
	void init() {
		car = new Car("MinYulCar");
		car2 = new Car("KyungJaeCar");
		inputConsole = new InputConsole();
		cars = new ArrayList<>(Arrays.asList(car,car2));
		numberContainer = new NumberContainer();
		race = new Race(numberContainer);
	}

	@DisplayName("자동차가 가는지 결과를 확인하는 테스트")
	@ParameterizedTest
	@CsvSource(value = {"3:0", "4:1","5:1"}, delimiter = ':')
	void goTest(int randomNumber, int resultDistance) {
		car.move(randomNumber);
		int carDistance = car.getDistance();
		assertThat(carDistance).isEqualTo(resultDistance);
	}

	@DisplayName("자동차의 이름이 제대로 부여되는지 확인하는 테스트")
	@Test
	void carNameTest() {
		String carName = "MinYulCar";
		assertThat(car.getCarName()).isEqualTo(carName);
	}

	@DisplayName("우승자를 확실히 반환하는지 확인하는 테스트")
	@Test
	void winnerTest() {
		car.move(3);
		car2.move(5);
		race.updateLongestDistance(cars);
		List<Car> winners = race.getWinners(cars);
		assertThat(winners.get(0)).isEqualTo(car2);
	}

//	@DisplayName("쉼표로 String Name을 구분했을 때 잘 구분하는 지 확인하는 테스트")
//	@ParameterizedTest
//	@ValueSource(strings = {"a,b,c","a,b"})
//	void commaCarNameTest(String input) {
//		String[] inputArray = input.split(",");
//		assertThat(inputConsole.getCarNames()).isEqualTo(inputArray);
//	}
}
