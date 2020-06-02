package test4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study4.domain.Car;
import study4.domain.RacingGame;
import study4.domain.RandomGenerator;

class RacingGameTest {

	private static final String 자동차이름들 = "pobi,choi,hyang";
	List<Car> carList;

	@BeforeEach
	void 테스트_시작전_메소드() {
		carList = new ArrayList();
	}

	@Test
	@DisplayName("이름수만큼 carList에 저장되는지 검증")
	void 입력받은_자동차수이름개수가_자동차리스트사이즈이다() {
		carList = RacingGame.splitCarName(자동차이름들);
		assertThat(carList).hasSize(3);
	}

}
