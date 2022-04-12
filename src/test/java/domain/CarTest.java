package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void init() {
        car = new Car();
        for (int i = 0; i < 5; i++) {
            car.move(5);
        }
    }

    @DisplayName("4이상의 수를 입력받은 경우 전진하는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void carMoveTest(int randomNumber) {
        int beforePosition = car.getPosition();
        car.move(randomNumber);
        assertThat(car.getPosition()).isEqualTo(beforePosition + 1);
    }

    @DisplayName("4미만의 수를 입력받은 경우 전진하지 않는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void carDontMoveTest(int randomNumber) {
        int beforePosition = car.getPosition();
        car.move(randomNumber);
        assertThat(car.getPosition()).isEqualTo(beforePosition);
    }

    @DisplayName("자동차의 상태 출력 테스트")
    @Test
    void carPositionPrintTest() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        car.printPosition();

        Assertions.assertEquals("-".repeat(Math.max(0, car.getPosition())), outputStream.toString().trim());
    }
}
