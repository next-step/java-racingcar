package racing.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @DisplayName("입력받은 자동차 이릅 배열로 자동차 이름을 생성한다.")
    @Test
    void ready() {
        // given
        String inputNames = "test1,test2,test3";

        // when
        Racing racing = new Racing(inputNames, 0);

        // then
        int participatingCarCount = racing.participatingCars().numberOfCars();
        assertThat(participatingCarCount).isEqualTo(3);
        for (int i = 0; i < participatingCarCount; ++i) {
            assertThat(racing.participatingCars().cars().get(i).name()).isEqualTo("test" + (i + 1));
        }
    }
}
