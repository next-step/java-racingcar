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
	static Car pobi;
	static Car conan;
	static Car nana;

	@BeforeEach
	void 시작_하기전_메소드() {
		pobi = new Car("pobi", 3);
		conan = new Car("conan", 2);
		nana = new Car("nana", 3);

		carlist.add(pobi);
		carlist.add(conan);
		carlist.add(nana);
		
	}

	@Test
	@DisplayName("우승자는 두명이다 + 우승자는 pobi와 nana를 포함한다.")
	void 우승자_구하기() {

		List<Car> winnerlist = winner.winnerMaxPosition(carlist);

		assertThat(winnerlist).hasSize(2);
		assertThat(winnerlist).contains(pobi, nana);
		assertThat(winnerlist.get(0).getPosition()).isEqualTo(3);
	}
	
	@Test
	void 우승자의_최대값은_max와같다() {
		List<Car> winnerlist = winner.winnerMaxPosition(carlist);
		assertThat(winnerlist.get(0).getPosition()).isEqualTo(3);
	}
}
