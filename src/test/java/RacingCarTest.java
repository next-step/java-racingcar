import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private final RacingCar racingCar = new RacingCar();

    @Test
    @DisplayName("0에서 9 사이 random 값을 생성한다.")
    public void test4() {
        assertThat(racingCar.createRandom()).isBetween(0, 9);
    }


    @ParameterizedTest
    @CsvSource(delimiter = ':', value = { "0:false", "4:true", "9:true" })
    @DisplayName("random 값이 4 이상이면 전진하고, 그렇지 않으면 정지한다.")
    public void test5(int input, boolean expected) {
        assertThat(racingCar.isGoingForward(input)).isEqualTo(expected);
    }


}
