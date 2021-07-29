package carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("4 이상의 정수에 따라 Car 객체의 position 값이 증가하는지 테스트")
    void go() {
        Car car = new Car();
        int position = 0;
        int[] randomNumbers = {2, 3, 4, 6, 5, 1};

        for (int randomNumber : randomNumbers) {
            position = car.go(new Random() {
                @Override
                public int nextInt(int bound) {
                    return randomNumber;
                }
            });
        }
        assertThat(position).isEqualTo(3);
    }
}