package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("경주용 자동차 컬렉션 테스트")
public class RacingCarsTest {

    @DisplayName("자동차는 생성시 주입받은 자동차 개수 만큼 생성되어야 한다")
    @Test
    public void initialRacingCarsCountTest() {
        // given
        int racingCarCount = 5;

        // when
        RacingCars racingCars = new RacingCars(racingCarCount);

        // then
        assertEquals(racingCars.getSize(), racingCarCount);
    }

    @DisplayName("자동차 대수가 0대 이하라면, IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    public void minRacingCarCountExceptionTest(int racingCarCount) {
        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCars(racingCarCount))
                .withMessage("자동차는 1대 이상이어야 합니다.");
    }
}
