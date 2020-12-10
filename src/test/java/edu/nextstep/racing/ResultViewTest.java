package edu.nextstep.racing;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ResultView : 실행 결과 표시 UI 로직을 담당하는 View 클래스")
class ResultViewTest {

	private final int ALWAYS_MOVE = 9;
	private final int NEVER_MOVE = 1;

	@DisplayName("viewCarLocation : 자동차의 이름과 자동차의 위치만큼의 '-'를, ' : '으로 붙여서 출력함.")
	@Test
	void viewCarLocation() {
		List<Car> carList = new ArrayList<>();
		Car car1 = new Car(() -> ALWAYS_MOVE);
		car1.setName("pobi");
		carList.add(car1);
		Car car2 = new Car(() -> NEVER_MOVE);
		car2.setName("crong");
		carList.add(car2);

		AtomicInteger count = new AtomicInteger(2); // 두번만 이동함
		Car car3 = new Car(() -> count.getAndDecrement() > 0 ? ALWAYS_MOVE : NEVER_MOVE);
		car3.setName("honux");
		carList.add(car3);

		Game game = new Game(carList, 5);
		while (game.isContinue()) {
			game.play();
		}

		assertThat(ResultView.viewCarLocation(car1)).isEqualTo("pobi : -----");
		assertThat(ResultView.viewCarLocation(car2)).isEqualTo("crong : ");
		assertThat(ResultView.viewCarLocation(car3)).isEqualTo("honux : --");

	}
}