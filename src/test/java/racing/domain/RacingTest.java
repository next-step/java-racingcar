package racing.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.dto.RacingInfo;

class RacingTest {

    @DisplayName(value = "carNames에서 얻은 자동차 수만큼 차를 생성한다.")
    @Test
    void createCar() {
        RacingInfo info = new RacingInfo("a,b,c,d", 0);
        Racing racing = new Racing(info);

        int carNumber = "a,b,c,d".split(",").length;
        assertThat(racing.getCars().size()).isEqualTo(carNumber);
    }
}
