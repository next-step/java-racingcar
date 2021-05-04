package game;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameWrapperTest {

	@Test
	@DisplayName("레이싱카 이름이 5자를 넘지 않는가?")
	void isRight_WhenNameIsLessThan5Words() {
		CarNameWrapper carNameWrapper = new CarNameWrapper("람보르기니");
		assertThat(carNameWrapper.getCarName().length()).isLessThanOrEqualTo(5);
	}

	@Test
	@DisplayName("이름이 5자 이상이면 Exception 처리를 하는가.")
	void isError_WhenNameIsMoreThan5Words() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			CarNameWrapper carNameWrapper = new CarNameWrapper("람보보르기니");
		});
	}

}