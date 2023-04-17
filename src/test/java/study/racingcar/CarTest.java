package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("숫자를 전달하여 자동차가 정상적으로 움직였는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "6:1", "3:0"}, delimiterString = ":")
    public void Car_move(int randomNum, int position) {

        Car car = new Car(0, "pobbi", new CarMoveStrategy());

        car.move(randomNum);

        assertThat(car.currentPosition()).isEqualTo(position);
    }

    @DisplayName("숫자를 전달하여 자동차가 정상적으로 움직였는지 테스트")
    @Test
    public void Car_move_여러_움직임_테스트() {

        Car car = new Car(0, "pobbi", new CarMoveStrategy());
        List<Integer> moveList = new ArrayList<>();
        moveList.add(0);
        moveList.add(7);
        moveList.add(5);
        moveList.add(4);

        for(Integer number : moveList){
            car.move(number);
        }

        assertThat(car.currentPosition()).isEqualTo(3);
    }
}
