package edu.nextstep.racing.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.nextstep.racing.domain.game.MoveCount;

@DisplayName("MoveCount : 게임에 필요한 상태값인, 최대이동횟수와 현재이동횟수를 내부 변수로 가짐.")
class MoveCountTest {

	@DisplayName("MoveCount : 현재이동횟수가 최대이동횟수보다 작으면 현재이동횟수가 1 증가함. 그렇지 않으면 현재이동횟수는 변화 없음.")
	@Test
	void countUp() {
		MoveCount moveCount = new MoveCount(2);
		assertThat(moveCount.getCurrent()).isEqualTo(0);
		moveCount.countUp();
		moveCount.countUp();
		assertThat(moveCount.getCurrent()).isEqualTo(2);
		moveCount.countUp();
		assertThat(moveCount.getCurrent()).isEqualTo(2);
	}

	@DisplayName("MoveCount : 현재이동횟수가 최대이동횟수보다 작으면 true를 리턴함.")
	@Test
	void isContinue() {
		MoveCount moveCount = new MoveCount(1);
		assertThat(moveCount.isContinue()).isTrue();
		moveCount.countUp();
		assertThat(moveCount.isContinue()).isFalse();
	}
}