package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceCourseTest {

	private CarRaceCourse carRaceCourse;

	@Test
	@SuppressWarnings("NonAsciiCharacters")
	void 한_라운드가_진행되면_자동차경주장에_라운드가_기록된다() {
		// given
		carRaceCourse = new CarRaceCourse(1, 3);

		// when
		carRaceCourse.proceedOneRound();

		// then
		assertThat(carRaceCourse.getRound()).isEqualTo(1);
	}

	@Test
	@SuppressWarnings("NonAsciiCharacters")
	void 모든_라운드가_진행되면_경주가_종료된다() {
		// given
		carRaceCourse = new CarRaceCourse(1, 3);

		// when
		carRaceCourse.proceedOneRound();
		carRaceCourse.proceedOneRound();
		carRaceCourse.proceedOneRound();

		// then
		assertThat(carRaceCourse.isNotEndRace()).isEqualTo(false);
	}

}
