package race;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 전진_결정() {
        boolean value = Car.canForward(4);
        assertThat(value).isTrue();
    }

    @Test
    void 정지_결정() {
        boolean value = Car.canForward(2);
        assertThat(value).isFalse();
    }

    @Test
    void 자동차_생성() {
        int number = 3;
        List<Integer> carList = Car.createCar(number);
        assertThat(carList).hasSize(number);
        IntStream.range(0,number).forEach(
                index -> assertThat(carList.get(index)).isZero()
        );
    }

    @Test
    void 자동차_전진_횟수_증가() {
        List<Integer> carList = Car.createCar(1);
        int index = 0;
        int current = carList.get(index);
        Car.addForward(index);

        assertThat(carList.get(index)).isEqualTo(current + 1);
    }

}
