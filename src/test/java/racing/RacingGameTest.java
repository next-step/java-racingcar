package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.RacingGame;
import racing.model.Car;
import racing.model.Forward;
import racing.model.Stop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
	@NullSource
	@ValueSource(strings = {"", "  ", "123456"})
	@DisplayName("자동차 생성 테스트(name validate)")
	void test_prepareInitRacingCar(String name) {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Car(name);
		});
	}

	@ParameterizedTest
	@DisplayName("전진 테스트")
	@ValueSource(ints = {1,2,3})
	protected void test_forward(@ConvertWith(ForwardConverter.class) Forward forward) {
		Car car = new Car("테스트카");
		car.speedUp(forward);
		assertThat(car.getForwardPosition()).isEqualTo(1);
	}

	@ParameterizedTest
	@DisplayName("멈춤 테스트")
	@ValueSource(ints = {1,2,3})
	void test_stop(@ConvertWith(StopConverter.class) Stop stop) {
		Car car = new Car("테스트카");
		car.speedUp(stop);
		assertThat(car.getForwardPosition()).isEqualTo(0);
	}

	static class ForwardConverter extends SimpleArgumentConverter {
		@Override
		protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
			assertEquals(Forward.class, targetType);
			return new Forward();

		}
	}

	static class StopConverter extends SimpleArgumentConverter {
		@Override
		protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
			assertEquals(Stop.class, targetType);
			return new Stop();

		}
	}

}