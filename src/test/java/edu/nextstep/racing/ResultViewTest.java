package edu.nextstep.racing;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ResultView : 실행 결과 표시 UI 로직을 담당하는 View 클래스")
class ResultViewTest {

	@DisplayName("viewCarLocation : 자동차의 이름과 자동차의 위치만큼의 '-'를, ' : '으로 붙여서 출력함.")
	@Test
	void viewCarLocation() {
		List<Car> carList = new ArrayList<>();
		Car car1 = new Car();
		car1.setName("pobi");
		carList.add(car1);
		Car car2 = new Car();
		car2.setName("crong");
		carList.add(car2);
		Car car3 = new Car();
		car3.setName("honux");
		carList.add(car3);

		Game game = new Game(carList, 5);
		while (game.isContinue()) {
			game.play();
		}

		assertThat(carList).allSatisfy(car -> {
			String[] texts = ResultView.viewCarLocation(car).split(" : ");
			assertThat(texts[0]).isEqualTo(car.getName());
			assertThat(texts[1]).isSubstringOf("-----");
			assertThat(texts[1].length()).isEqualTo(car.getLocation());
		});
	}
}