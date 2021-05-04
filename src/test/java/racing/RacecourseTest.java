package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("경주장 테스트")
class RacecourseTest {

	@Test
	@DisplayName("경주장 생성 및 초기화 테스트")
	void createRacecourseTest() {
		Racecourse racecourse = new Racecourse();
		racecourse.init(new Command(5, "pobi,crong,honux"));
		assertThat(racecourse.getCarsSize()).isEqualTo(3);
		assertThat(racecourse.getCount()).isEqualTo(5);
	}
}