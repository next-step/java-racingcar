import org.junit.jupiter.api.Test;
import step3.RacingCarClass;
import step3.ResultView;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {
	@Test
	void 숫자가4이상나올경우전진() {
		assertThat(RacingCarClass.isCarMove(4)).isTrue();
		assertThat(RacingCarClass.isCarMove(9)).isTrue();
	}

	@Test
	void 숫자가4이하로나올경우그자리() {
		assertThat((RacingCarClass.isCarMove(3))).isFalse();
		assertThat((RacingCarClass.isCarMove(0))).isFalse();
	}

	@Test
	void printTest() {
		int[] testValue = {1, 2, 3};
		ResultView.printStatus(testValue);
	}
}
