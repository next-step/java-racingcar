package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.RacingGame;
import racing.model.Car;
import racing.model.FinalRacingResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameTest {

	/*
	* - 단순히 파라미터로 숫자값을 받으니 이 메소드가 무슨 일을 하는 메소드인지 명확하지가 않아 보인다.
	  - 자동차를 움직이는 조건(전략, 인터페이스)을 파라미터로 받기
	* */
	//https://github.com/next-step/java-racingcar/pull/1671#discussion_r537067442
	//테스트 가능한 구조를 위해 변경하는 과정과 프로덕션 코드, 테스트 코드 각각에 다른 재료를 넣어서 테스트를 할 수 있다는 사실이 중요
	RacingGame racingGame = new RacingGame();

	// 통합 테스트 : 전체 과정을 통과하는 상위 메소드를 테스트하는 것

	@ParameterizedTest
	@CsvSource(value = {"aCar,bCar,cCar,dCar,eCar:5", "aCar,bCar:3", "aCar,bCar,cCar:2"}, delimiter = ':')
	@DisplayName("자동차 경주 통합 테스")
	void test_RacingCar(String inputName, int playCount) {
		FinalRacingResult finalRacingResult = racingGame.racing(inputName, playCount);
		assertThat(finalRacingResult).isNotNull();

	}

	@ParameterizedTest
	@NullSource
	@ValueSource(strings = {"", "  ", "123456"})
	@DisplayName("자동차 생성 테스트(name validate)")
	void test_prepareInitRacingCar(String name) {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Car(name);
		});
	}

	@Test
	@DisplayName("전진 테스트")
	protected void test_forward() {
		Car car = new Car("테스트카");
		car.speedUp(() -> { return true; });
		assertThat(car.getForwardPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("멈춤 테스트")
	void testx_stop() {
		Car car = new Car("테스트카");
		car.speedUp(() -> { return false; });
		assertThat(car.getForwardPosition()).isEqualTo(0);
	}

}