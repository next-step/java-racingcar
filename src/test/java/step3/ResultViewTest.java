package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ResultView : 실행 결과 표시 UI 로직을 담당하는 View 클래스")
class ResultViewTest {

	@DisplayName("viewCarLocation : car의 location과 같은 숫자 만큼 '-' 문자를 더해 리턴함.")
	@Test
	void viewCarLocation() {
		List<Car> carList = Arrays.asList(new Car(), new Car(), new Car());
		Game game = new Game(carList, 5);
		while (game.isContinue()) {
			game.play();
		}
		assertThat(carList).allSatisfy(car -> {
			assertThat(ResultView.viewCarLocation(car)).isSubstringOf("-----");
			assertThat(ResultView.viewCarLocation(car).length()).isEqualTo(car.getLocation());
		});
	}
}