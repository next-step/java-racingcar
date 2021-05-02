package util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ValidationTest {
	@Test
	public void isValidCarListTest() {
		boolean validCarList = Validation.isValidCarList("pobi,crong,honux");
		boolean invalidCarList1 = Validation.isValidCarList("pobi,,crong,hon");
		boolean invalidCarList2 = Validation.isValidCarList("pobi,crong,honuxxxx");
		assertThat(validCarList).as("Failure - Parameter String is invalid: ").isTrue();
		assertThat(invalidCarList1).as("Failure - Parameter String is valid: ").isFalse();
		assertThat(invalidCarList2).as("Failure - Parameter String is valid: ").isFalse();
	}

	@Test
	public void isValidCarElementTest() {
		boolean validCarName1 = Validation.isValidCarElement("pobi");
		boolean validCarName2 = Validation.isValidCarElement("crong");
		boolean invalidCarName1 = Validation.isValidCarElement("honuxxxx");
		boolean invalidCarName2 = Validation.isValidCarElement("");
		assertThat(validCarName1).as("Failure - Parameter String is invalid: ").isTrue();
		assertThat(validCarName2).as("Failure - Parameter String is invalid: ").isTrue();
		assertThat(invalidCarName1).as("Failure - Parameter String is valid: ").isFalse();
		assertThat(invalidCarName2).as("Failure - Parameter String is valid: ").isFalse();
	}

	@Test
	public void isValidRepeatTimeTest() {
		boolean validRepeatTime1 = Validation.isValidRepeatTime("5");
		boolean validRepeatTime2 = Validation.isValidRepeatTime("100");
		boolean invalidRepeatTime1 = Validation.isValidRepeatTime("0");
		boolean invalidRepeatTime2 = Validation.isValidRepeatTime("-1");
		boolean invalidRepeatTime3 = Validation.isValidRepeatTime("textinput");
		assertThat(validRepeatTime1).as("Failure - Parameter String is invalid: ").isTrue();
		assertThat(validRepeatTime2).as("Failure - Parameter String is invalid: ").isTrue();
		assertThat(invalidRepeatTime1).as("Failure - Parameter String is valid: ").isFalse();
		assertThat(invalidRepeatTime2).as("Failure - Parameter String is valid: ").isFalse();
		assertThat(invalidRepeatTime3).as("Failure - Parameter String is valid: ").isFalse();
	}
}
