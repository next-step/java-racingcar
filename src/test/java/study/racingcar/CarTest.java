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
    @ValueSource(ints = {3, 6, 5})
    public void Car_move(int games) {

        Car car = new Car(0, "pobbi", new CarMoveStrategy());

        for(int i = 0; i < games; i++) {
            car.move();
        }

        assertThat(car.currentPosition()).isBetween(0, games);
    }
}
