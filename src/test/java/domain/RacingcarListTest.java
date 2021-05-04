package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import util.InputView;

class RacingcarListTest {
	private static final String TEST_TYPE_OBJECT = "OBJECT";

	@Test
	public void getRacingcarStringToListTest() {
		List<Racingcar> actualRacingcarList = RacingcarList.getRacingcarStringToList("pobi,crong,honux,nero");
		List<Racingcar> expectedRacingcarList = new ArrayList<>();
		expectedRacingcarList.add(new Racingcar("pobi"));
		expectedRacingcarList.add(new Racingcar("crong"));
		expectedRacingcarList.add(new Racingcar("honux"));
		expectedRacingcarList.add(new Racingcar("nero"));

		assertThat(actualRacingcarList)
			.as(InputView.getTestFailureMessage(TEST_TYPE_OBJECT))
			.usingRecursiveComparison()
			.isEqualTo(expectedRacingcarList);
	}

	@Test
	public void getWinnerTest() {
		List<Racingcar> actualRacingcarList = new ArrayList<>();
		actualRacingcarList.add(new Racingcar("pobi", "-----"));
		actualRacingcarList.add(new Racingcar("crong", "-"));
		actualRacingcarList.add(new Racingcar("honux", "--"));
		actualRacingcarList.add(new Racingcar("nero", "-----"));

		List<String> actualWinnerList = RacingcarList.getWinner(actualRacingcarList);
		List<String> expectedWinnerList = new ArrayList<>();
		expectedWinnerList.add("pobi");
		expectedWinnerList.add("nero");

		assertThat(actualWinnerList)
			.as(InputView.getTestFailureMessage(TEST_TYPE_OBJECT))
			.isEqualTo(expectedWinnerList);
	}
}
