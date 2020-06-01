package test4;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study4.domain.Car;
import study4.domain.RacingGame;
import study4.domain.Winner;
import study4.view.ResultView;

class WinnerTest {

	List<Car> carlist = new ArrayList();
	Winner winner = new Winner();
	Car pobi;
	Car conan;
	Car nana;
	
	List<Car> winnerlist;
	@BeforeEach
	void 시작_하기전_메소드() {
		pobi = new Car("pobi", 3);
		conan = new Car("conan", 2);
		nana = new Car("nana", 3);

		carlist.add(pobi);
		carlist.add(conan);
		carlist.add(nana);
		winnerlist = winner.winnerMaxPosition(carlist);
	}

	@Test
	@DisplayName("우승자는 두명이다")
	void 우승자_구하기() {
		assertThat(winnerlist).hasSize(2);
	}
	
	@Test
	@DisplayName("우승자는 포비와 나나다")
	void 우승자는_포비와나나_를_포함한다() {
		assertThat(winnerlist).contains(pobi, nana);
	}
		
	@Test
	@DisplayName("우승자의 position이 최대값이다.")
	void 우승자의_최대값은_max와같다() {
		assertThat(winnerlist.get(0).getPosition()).isEqualTo(3);
	}
}
