package carRacing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumMakerTest {

	@DisplayName("랜덤값은 0과 9사이의 값이 만들어진다")
	@Test
	void makeRandomNum() {
		RandomNumMaker ran = new RandomNumMaker();
		int randomNum = ran.makeRanNum();

		assertThat(randomNum).isBetween(0,9);
	}
}