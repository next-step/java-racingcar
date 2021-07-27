package racing.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {


	@DisplayName("이동거리를 입력하면 이동거리만큼 생성된다.")
	@ParameterizedTest
	@CsvSource(value = {"1,3,5,7,9"})
	public void createPosition(int value){
		Position position = new Position(value);

		assertThat(position.resultPosition()).isEqualTo(value);
	}

	@Test
	@DisplayName("음수값을 입력하면 예외가 발생된다.")
	public void valuePositiveCheck(){
		assertThrows(IllegalArgumentException.class, () ->
			new Position(-5)
		);

		assertThatThrownBy(() -> new Position(-3))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("음수값을 가질수 없습니다.");
	}

	@Test
	@DisplayName("이동에 대한 명령을 하면 1칸씩 이동된다.")
	public void positionMoving(){
		Position position = new Position(0);
		Position move1 = position.move();

		assertThat(position.resultPosition()).isEqualTo(1);
		assertThat(move1.resultPosition()).isEqualTo(1);
		assertThat(position).isEqualTo(move1);
	}

	@Test
	@DisplayName("현재 위치값이 최고위치값과 동일하면 true 아니면 false 가 반환한다.")
	public void maxPositionCheck(){
		int maxPosition = 3;
		Position position = new Position(0);
		position.move();
		position.move();

		assertThat(position.maxPositionCheck(maxPosition)).isFalse();

		position.move();
		assertThat(position.maxPositionCheck(maxPosition)).isTrue();
	}

}