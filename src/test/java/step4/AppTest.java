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

	@BeforeEach
	void init() {
		inputConsole = new InputConsole();
	}

	@DisplayName("자동차가 4 이상일 때, 가는지 결과를 확인하는 테스트")
	@Test
	void goTest() {
		Car car = new Car("yul", 0);
		car.move(new NumberGenerator() {
			@Override
			public int getNumber() {
				return 4;
			}
		});
		int carDistance = car.getDistance();
		assertThat(carDistance).isEqualTo(1);
	}

	@DisplayName("자동차가 4 미만일 때, 가는지 결과를 확인하는 테스트")
	@Test
	void stopTest() {
		Car car = new Car("yul", 0);
		car.move(new NumberGenerator() {
			@Override
			public int getNumber() {
				return 3;
			}
		});
		int carDistance = car.getDistance();
		assertThat(carDistance).isEqualTo(0);
	}

//	@DisplayName("우승자를 확실히 반환하는지 확인하는 테스트")
//	@Test
//	void winnerTest() {
//		race = new Race(numberContainer,new String[]{"car","car2"});
//		List<Car> winners = race.getWinners();
//		assertThat(winners).contains(new Car("car",0), new Car("car2", 0));
//	}

	@DisplayName("5글자 초과시 에러를 던지는 테스트")
	@Test
	void carNameTest() {
		assertThatIllegalArgumentException().isThrownBy(()-> {
			Car car = new Car("123456",0);
		});
	}
}
