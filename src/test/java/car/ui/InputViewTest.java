package car.ui;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import car.exception.CarNameLengthException;

@DisplayName("입력값 테스트")
public class InputViewTest {

	@DisplayName("자동차 이름이 5자를 초과하는지 확인.")
	@Test
	void test1() {
		InputView inputView = new InputView();
		inputView.carNames = new String[]{ "pobipo", "crong", "honux" };

		assertThatThrownBy(inputView::checkCarName).isInstanceOf(CarNameLengthException.class);
	}
}
