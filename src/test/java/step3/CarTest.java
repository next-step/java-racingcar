package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private static final String SEPARATOR = ",";

    @ParameterizedTest
    @ValueSource(strings = {
            "0" + SEPARATOR + " ",
            "1" + SEPARATOR + "-",
            "2" + SEPARATOR + "--",
            "3" + SEPARATOR + "---",
            "10" + SEPARATOR + "----------"
    })
    public void 차_이동_테스트(String input) {
        int moveCount = Integer.parseInt(input.split(SEPARATOR)[0]);
        String expected = input.split(SEPARATOR)[1];
        Car car = new Car("Dummy");
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }
        assertThat(car.getWayResult()).isEqualTo(expected);
    }


}
