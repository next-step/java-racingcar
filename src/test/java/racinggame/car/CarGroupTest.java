package racinggame.car;

import org.junit.Test;
import racinggame.RacingGameTestHelper;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 04/11/2018.
 */
public class CarGroupTest {
	@Test
	public void test_특정_자동차_이동() {
		final int dataSize = 5;
		String[] testData = RacingGameTestHelper.createTestData(dataSize);
		CarGroup carGroup = new CarGroup(testData);

		carGroup.moveForward(RacingGameTestHelper.racingGameRuleByCarName(testData[0]));

		assertThat(carGroup.getCarDTOList().size()).isEqualTo(dataSize);
	}

	@Test
	public void test_전체_자동차_이동() {
		final int dataSize = 5;
		String[] testData = RacingGameTestHelper.createTestData(dataSize);
		CarGroup carGroup = new CarGroup(testData);

		carGroup.moveForward(car -> true);

		assertThat(carGroup.getCarDTOList().size()).isEqualTo(dataSize);
	}
}