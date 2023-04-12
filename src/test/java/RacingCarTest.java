import org.junit.jupiter.api.Test;
import step3.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

	private Car sampleCar;

	@Test
	void 차의랜덤넘버는0부터9까지나온다() {
		assertThat(Utils.getRandomNumber(10)).isGreaterThanOrEqualTo(0);
		assertThat(Utils.getRandomNumber(10)).isLessThanOrEqualTo(9);
	}

	@Test
	void 차가전진시steps가증가한다() {
		sampleCar.isCarMove(0);
		assertThat(sampleCar.getSteps()).isEqualTo(0);
		sampleCar.isCarMove(9);
		assertThat(sampleCar.getSteps()).isEqualTo(1);
	}


	@Test
	void printTest() {
		int[] testValue = {1, 2, 3};
		ResultView.printStatus(testValue);
	}
}
