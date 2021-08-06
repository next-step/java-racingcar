package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class AppTest {

	private InputConsole inputConsole;
	private Race race;
	private NumberContainer numberContainer;

	@BeforeEach
	void init() {
		inputConsole = new InputConsole();
		numberContainer = new NumberContainer();
		race = new Race(numberContainer,new String[]{"carOne","carTwo"});
	}

	@DisplayName("자동차가 가는지 결과를 확인하는 테스트")
	@ParameterizedTest
	@CsvSource(value = {"3:0", "4:1","5:1"}, delimiter = ':')
	void goTest(int randomNumber, int resultDistance) {
		Car car = new Car("yul", 0);
		car.move(randomNumber);
		int carDistance = car.getDistance();
		assertThat(carDistance).isEqualTo(resultDistance);
	}

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

	@DisplayName("5글자 초과시 에러를 던지는 테스트")
	@Test
	void carNameTest() {
		assertThatIllegalArgumentException().isThrownBy(()-> {
			Car car = new Car("123456",0);
		});
	}
}
