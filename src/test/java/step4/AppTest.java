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

	private InputConsole inputConsole;
	private Race race;
	private NumberContainer numberContainer;

	@BeforeEach
	void init() {
		inputConsole = new InputConsole();
		numberContainer = new NumberContainer();
		race = new Race(numberContainer);
	}

//	@DisplayName("자동차가 가는지 결과를 확인하는 테스트")
//	@ParameterizedTest
//	@CsvSource(value = {"3:0", "4:1","5:1"}, delimiter = ':')
//	void goTest(int randomNumber, int resultDistance) {
//		car.move(randomNumber);
//		int carDistance = car.getDistance();
//		assertThat(carDistance).isEqualTo(resultDistance);
//	}
//
//	@DisplayName("자동차의 이름이 제대로 부여되는지 확인하는 테스트")
//	@Test
//	void carNameTest() {
//		String carName = "MinYulCar";
//		assertThat(car.getCarName()).isEqualTo(carName);
//	}

	@DisplayName("우승자를 확실히 반환하는지 확인하는 테스트")
	@Test
	void winnerTest() {
		Car carOne = new Car("1", 5);
		Car carTwo = new Car("2",3);
		Car carThree = new Car("3",5);
		race.addCar(carOne);
		race.addCar(carTwo);
		race.addCar(carThree);
		List<Car> winners = race.getWinners();
		assertThat(winners).contains(carOne, carThree);
	}

//	@DisplayName("쉼표로 String Name을 구분했을 때 잘 구분하는 지 확인하는 테스트")
//	@ParameterizedTest
//	@ValueSource(strings = {"a,b,c","a,b"})
//	void commaCarNameTest(String input) {
//		String[] inputArray = input.split(",");
//		assertThat(inputConsole.getCarNames()).isEqualTo(inputArray);
//	}
}
