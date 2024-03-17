package RacingCarWinner;

import RacingCarWinner.Model.Car;
import RacingCarWinner.View.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarWinnerTest {
    @ParameterizedTest
    @DisplayName("random 값이 4이상일 경우에만 전진")
    @CsvSource(value = {"0,false", "1,false", "2,false", "3,false", "4,true", "5,true", "6,true"})
    void carMoveTest(int num, boolean isGo) {
        Car car = new Car("sample");
        car.moveCar(num);
        String stringCurrentState = car.makeStringCurrentPosition();
        assertThat(stringCurrentState.contains("-")).isEqualTo(isGo);
    }

    @Test
    @DisplayName("split 결과가 크기가 1인 배열인 경우 반환 확인")
    void splitSingle() {
        InputView inputView = new InputView();
        String[] strList = inputView.getSplitStringData("pobi,crong,honux", ",");
        assertThat(strList).containsExactly("pobi", "crong", "honux");
    }
}
