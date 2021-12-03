package study.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

	private RacingGame game;
	private int tryNo;

	@BeforeEach
	void setUp(){
		List<Name> names = Arrays.asList(new Name("a"), new Name("b"), new Name("c"));
		tryNo = 5;
		game = new RacingGame(names, tryNo);
	}

	@Test
	@DisplayName("처음 세팅시 isEnd false")
	void tryNoTest() {
		assertThat(game.closed()).isFalse();
	}

	@Test
	@DisplayName("tryNo 만큼 레이스 실행 시, isEnd TRUE")
	void tryNoTest2() {
		for (int i = 0; i < tryNo ; i++) {
			game.playGame(() -> true);
		}

		assertThat(game.closed()).isTrue();
	}


}