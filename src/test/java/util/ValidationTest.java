package util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ValidationTest {
	private static final String TEST_TYPE_EXPECTED = "EXPECTED";

	@Test
	public void isValidCarListTest() {
		boolean validCarList = Validation.isValidCarList("pobi,crong,honux");
		boolean invalidCarList1 = Validation.isValidCarList("pobi,,crong,hon");
		boolean invalidCarList2 = Validation.isValidCarList("pobi,crong,honuxxxx");
		assertThat(validCarList)
			.as(InputView.getTestFailureMessage(TEST_TYPE_EXPECTED))
			.isTrue();
		assertThat(invalidCarList1)
			.as(InputView.getTestFailureMessage(TEST_TYPE_EXPECTED))
			.isFalse();
		assertThat(invalidCarList2)
			.as(InputView.getTestFailureMessage(TEST_TYPE_EXPECTED))
			.isFalse();
	}

	@Test
	public void isValidCarElementTest() {
		boolean validCarName1 = Validation.isValidCarElement("pobi");
		boolean validCarName2 = Validation.isValidCarElement("crong");
		boolean invalidCarName1 = Validation.isValidCarElement("honuxxxx");
		boolean invalidCarName2 = Validation.isValidCarElement("");
		assertThat(validCarName1)
			.as(InputView.getTestFailureMessage(TEST_TYPE_EXPECTED))
			.isTrue();
		assertThat(validCarName2)
			.as(InputView.getTestFailureMessage(TEST_TYPE_EXPECTED))
			.isTrue();
		assertThat(invalidCarName1)
			.as(InputView.getTestFailureMessage(TEST_TYPE_EXPECTED))
			.isFalse();
		assertThat(invalidCarName2)
			.as(InputView.getTestFailureMessage(TEST_TYPE_EXPECTED))
			.isFalse();
	}

	@Test
	public void isValidRepeatTimeTest() {
		boolean validRepeatTime1 = Validation.isValidRepeatTime("5");
		boolean validRepeatTime2 = Validation.isValidRepeatTime("100");
		boolean invalidRepeatTime1 = Validation.isValidRepeatTime("012");
		boolean invalidRepeatTime2 = Validation.isValidRepeatTime("-1");
		boolean invalidRepeatTime3 = Validation.isValidRepeatTime("textinput");
		boolean invalidRepeatTime4 = Validation.isValidRepeatTime("");
		assertThat(validRepeatTime1)
			.as(InputView.getTestFailureMessage(TEST_TYPE_EXPECTED))
			.isTrue();
		assertThat(validRepeatTime2)
			.as(InputView.getTestFailureMessage(TEST_TYPE_EXPECTED))
			.isTrue();
		assertThat(invalidRepeatTime1)
			.as(InputView.getTestFailureMessage(TEST_TYPE_EXPECTED))
			.isFalse();
		assertThat(invalidRepeatTime2)
			.as(InputView.getTestFailureMessage(TEST_TYPE_EXPECTED))
			.isFalse();
		assertThat(invalidRepeatTime3)
			.as(InputView.getTestFailureMessage(TEST_TYPE_EXPECTED))
			.isFalse();
		assertThat(invalidRepeatTime4)
			.as(InputView.getTestFailureMessage(TEST_TYPE_EXPECTED))
			.isFalse();
	}
}
