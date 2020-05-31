package test4;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study4.domain.Car;
import study4.domain.RacingGame;
import study4.domain.Winner;
import study4.view.ResultView;

class WinnerTest {

	String 자동차이름 = "pobi,choi";
	ResultView resultview = new ResultView();
	Winner winner = new Winner();
	List<String> winnerCarList = new ArrayList();

	int max1 = -1;
	int 시도횟수 = 5;

	RacingGame rg = new RacingGame(자동차이름, 시도횟수);
	List<Car> carList = rg.splitCarName(자동차이름);

	@BeforeEach
	@DisplayName("우승자 체크 시작 전 메소드")
	void 우승자_체크_시작전_메소드() {

		carList = resultview.outputResult(rg.racingcarMove(carList));

	}

	@Test
	@DisplayName("우승자는 carName에 속한다")
	void 우승자가_입력값에_포함되는지_검증하는_메소드() {
		winnerCarList = winner.winnerMaxPosition(carList);
		assertThat(자동차이름).containsOnlyOnce(winnerCarList.get(0));
	}
	
}
