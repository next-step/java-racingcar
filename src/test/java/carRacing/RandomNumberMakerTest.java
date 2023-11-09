package carRacing;

import static org.assertj.core.api.Assertions.assertThat;

import carRacing.numberMaker.RandomNumberMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberMakerTest {

	@DisplayName("랜덤값은 0과 9사이의 값이 만들어진다")
	@Test
	void makeRandomNum() {
		RandomNumberMaker ran = new RandomNumberMaker();
		int randomNum = ran.makeNumber();

		assertThat(randomNum).isBetween(0,9);
	}
}