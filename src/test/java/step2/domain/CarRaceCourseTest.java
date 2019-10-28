package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.rules.CarNumberDefaultRule;
import step2.domain.rules.RaceRoundDefaultRule;
import step2.util.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class CarRaceCourseTest {

	private CarRaceCourse carRaceCourse;

	@BeforeEach
	void init() {
		carRaceCourse = new CarRaceCourse(new CarNumberDefaultRule(1), new RaceRoundDefaultRule(3), new RandomGenerator());
	}

	@Test
	void 한_라운드가_진행되면_자동차경주장에_라운드가_기록된다() {
		// when
		carRaceCourse.proceedOneRound();

		// then
		assertThat(carRaceCourse.getCurrentRound()).isEqualTo(1);
	}

	@Test
	void 모든_라운드가_진행되면_경주가_종료된다() {
		// when
		carRaceCourse.proceedOneRound();
		carRaceCourse.proceedOneRound();
		carRaceCourse.proceedOneRound();

		// then
		assertThat(carRaceCourse.isNotEndRace()).isFalse();
	}

}
