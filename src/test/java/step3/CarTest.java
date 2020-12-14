package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private static final String SEPARATOR = ",";
    private static final String DUMMY_CAR_NAME = "Dummy";

    @ParameterizedTest
    @ValueSource(strings = {
            "0" + SEPARATOR + " ",
            "1" + SEPARATOR + "-",
            "2" + SEPARATOR + "--",
            "3" + SEPARATOR + "---",
            "10" + SEPARATOR + "----------"
    })
    public void 차_이동_결과_테스트(String input) {
        int moveCount = Integer.parseInt(input.split(SEPARATOR)[0]);
        String expected = input.split(SEPARATOR)[1];
        Car car = new Car("Dummy");
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }
        assertThat(car.getWayResult()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0" + SEPARATOR + "0",
            "1" + SEPARATOR + "1",
            "2" + SEPARATOR + "2",
            "3" + SEPARATOR + "3",
            "10" + SEPARATOR + "10"
    })
    public void 차_이동_테스트(String input) {
        int moveCount = Integer.parseInt(input.split(SEPARATOR)[0]);
        int expected = Integer.parseInt(input.split(SEPARATOR)[1]);
        Car car = new Car(DUMMY_CAR_NAME);
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }
        assertThat(car.getMoveCount()).isEqualTo(expected);
    }

    @Test
    public void 자동차_이름_제한_테스트() {
        assertThatThrownBy(() -> {
            Car car = new Car("12345");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}

