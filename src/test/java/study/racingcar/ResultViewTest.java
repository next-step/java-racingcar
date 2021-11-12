package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultViewTest {

	@Test
	@DisplayName("position 갯수에 따라 - 찍기")
	void test(){
		int position = 5;
		ResultView.printRace(position);
	}
}
