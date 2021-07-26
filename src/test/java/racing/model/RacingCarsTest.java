package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("경주용 자동차 테스트")
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
    @ValueSource(ints = {-10, -3, -1, 0})
    public void minRacingCarCountExceptionTest(int racingCarCount) {
        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCars(racingCarCount))
                .withMessage("자동차는 1대 이상이어야 합니다.");
    }

    @DisplayName("자동차에게 부여하는 Number 목록이 비었으면, IllegalArgumentException이 발생한다.")
    @Test
    public void emptyNumbersExceptionTest() {
        // given
        RacingCars racingCars = new RacingCars(3);

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> racingCars.moveOrStop(new ArrayList<>()))
                .withMessage("숫자 목록이 비어있습니다.");
    }

    @DisplayName("자동차 대수와 자동차에게 부여하는 Number의 개수가 같지 않으면, IllegalArgumentException이 발생한다.")
    @Test
    public void notSameSizeExceptionTest() {
        // given
        RacingCars racingCars = new RacingCars(3);
        List<Number> numbers = new ArrayList<>();
        numbers.add(new Number(5));

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> racingCars.moveOrStop(numbers))
                .withMessage("숫자의 개수가 자동차 대수와 같지 않습니다.");
    }

    @DisplayName("자동차가 4 이상의 값을 부여받으면 한 칸 전진하고, 그렇지 않으면 멈춘다.")
    @Test
    public void moveOrStopTest() {
        // given
        RacingCars racingCars = new RacingCars(3);
        List<Number> numbers = new ArrayList<>();
        numbers.add(new Number(3));
        numbers.add(new Number(7));
        numbers.add(new Number(9));

        // when
        racingCars.moveOrStop(numbers);

        // then
        assertEquals(racingCars.getRacingCarPositions()[0], 0);
        assertEquals(racingCars.getRacingCarPositions()[1], 1);
        assertEquals(racingCars.getRacingCarPositions()[2], 1);
    }
}
