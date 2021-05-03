package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 테스트")
public class CarTest {

	@Test
	@DisplayName("자동차 생성 테스트")
	void createCarTest() {
		String name = "honux";
		Car car = new Car(name);
		assertThat(car).isNotNull();
		assertThat(car.getName()).isEqualTo(name);
	}
	@Test
	@DisplayName("자동차 생성 실패 테스트 : 이름이 5자 이상 일 경우")
	void createCarFailTest() {
		assertThatIllegalArgumentException().isThrownBy(() ->new Car("honuxx"));
	}
}
