package step5.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
	private static final int SPEED = 3;

	@Test
	@DisplayName("addPositionBySpeed() 메소드를 호출했을 때 입력한 speed 만큼 움직이는지 체크하는 함수")
	void carStrategyMoveTest() {
		Position currentPosition = new Position(0);
		currentPosition.addPositionBySpeed(SPEED);
		assertThat(currentPosition).isEqualTo(new Position(SPEED));
	}

	@Test
	@DisplayName("static 메소드 getMaxPosition() 이 List<Position> 을 입력했을때 MAX 값을 잘 출력하는지 테스트")
	void getMaxPosition() {
		List<Position> positionList = new ArrayList<>();
		positionList.add(new Position(0));
		positionList.add(new Position(1));
		positionList.add(new Position(2));
		positionList.add(new Position(3));
		assertThat(Position.getMaxPosition(positionList)).isEqualTo(new Position(3));
	}
}
