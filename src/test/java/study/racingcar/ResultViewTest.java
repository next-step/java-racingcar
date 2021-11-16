package study.racingcar;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.racingcar.domain.Position;
import study.racingcar.view.ResultView;

public class ResultViewTest {

	@Test
	@DisplayName("position 갯수에 따라 - 찍기")
	void test(){
		//given
		Position position1 = addPosition(2, new Position());
		Position position2 = addPosition(3, new Position());
		Position position3 = addPosition(4, new Position());

		List<Position> positions = new ArrayList<>();
		positions.add(position1);
		positions.add(position2);
		positions.add(position3);


		//when, then
		ResultView.printPosition(positions);

	}

	private Position addPosition(int count, Position position){
		for (int i = 0; i < count; i++) {
			position.add();
		}
		return position;
	}
}
