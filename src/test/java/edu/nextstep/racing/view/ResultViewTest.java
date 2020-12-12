package edu.nextstep.racing.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.nextstep.racing.domain.game.cars.car.Car;

@DisplayName("ResultView : 실행 결과 표시 UI 로직을 담당하는 View 클래스")
class ResultViewTest {

	@DisplayName("viewCarLocation : 자동차의 이름과 자동차의 위치만큼의 '-'를, ' : '으로 붙여서 출력함.")
	@Test
	void viewCarLocation() {
		assertThat(ResultView.viewCarLocation(new Car("pobi", 5))).isEqualTo("pobi : -----");
		assertThat(ResultView.viewCarLocation(new Car("crong", 0))).isEqualTo("crong : ");
		assertThat(ResultView.viewCarLocation(new Car("honux", 2))).isEqualTo("honux : --");
	}
}