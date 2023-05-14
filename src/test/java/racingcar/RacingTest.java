package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    public InputView inputView = new InputView();
    public ResultView resultView = new ResultView();


    @Test
    void 레이싱_전체_테스트() {
        // Given
        String testInput = "pobi,crong,honux\n5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        // Then
        Racing race = inputView.init();
        resultView.displayResults(race.getCarCollection());
    }


    @Test
    void 랜덤하게_전진() {
        // Given
        Racing race = new Racing("pobi,crong,honux", 5);

        // When

        // Then
        resultView.displayResults(race.getCarCollection());
    }

    @Test
    void proceedOrStop함수는_0_또는_1을_반환한다() {
        // Given
        Car car = new Car("pobi", Arrays.asList(1, 2, 3, 4, 4));

        // Then
        assertThat(car.proceedOrStop()).isIn(0, 1);
        assertThat(car.proceedOrStop()).isIn(0, 1);
        assertThat(car.proceedOrStop()).isIn(0, 1);
        assertThat(car.proceedOrStop()).isIn(0, 1);
        assertThat(car.proceedOrStop()).isIn(0, 1);
    }

    @Test
    void Car_객체_테스트() {
        // Given
        Car car = new Car("pobi", Arrays.asList(1, 2, 3, 4, 5));

        // Then
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPositions()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void 자동차_이름은_5자를_초과할_수_없다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car car = new Car("pobibi", Arrays.asList(1, 2, 3, 4, 5));
        }).withMessage("자동차 이름은 5자를 초과할 수 없다.");
    }

    @Test
    void 우승자_출력하기() {
        // Given
        List<Car> cars = Arrays.asList(
                new Car("pobi", Arrays.asList(1, 2, 3, 4, 4)),
                new Car("crong", Arrays.asList(1, 1, 2, 3, 4)),
                new Car("honux", Arrays.asList(1, 2, 3, 3, 3))
        );

        // Then
        assertThat(resultView.getWinnerMessage(cars)).isEqualTo("pobi, crong가 최종 우승했습니다.");
    }
}
