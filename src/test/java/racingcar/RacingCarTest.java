package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    @DisplayName("쉼표로 구분된 여러 자동자 이름을 분리한다.")
    public void 쉼표로_구분된_여러_자동자_이름을_분리한다() throws Exception {
        String str = "pobi,crong,honux";
        String[] cars = Cars.split(str);

        Assertions.assertThat(cars[0]).isEqualTo("pobi");
        Assertions.assertThat(cars[1]).isEqualTo("crong");
        Assertions.assertThat(cars[2]).isEqualTo("honux");
    }



}
