package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultViewTest {
	@DisplayName("전진하는 자동차를 출력할 때 자동차 이름도 같이 출력")
	@Test
	void printWithCarName() {
		// given
		Car audi = Car.createCar("audi");

		// when
		String result = ResultView.carPositionWithChar(audi, '-');

		// then
		assertThat(result).contains("audi");
	}
}
