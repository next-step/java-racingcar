package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class CarTest {

    private Car car;
    private Random random;
    private String name;
    private static final int INIT_NUM = 0;
    private static final int RANDOM_BOUND = 10;

    @BeforeEach
    void setUp() throws Exception {
        name = "carName";
        car = new Car(name);

        /*
         * Random mock test 참고 링크: https://multifrontgarden.tistory.com/187
         * private field에 set: https://www.baeldung.com/java-set-private-field-value
         * */

        random = mock(Random.class);
        Field randomField = car.getClass()
                .getDeclaredField("random");
        randomField.setAccessible(true);
        randomField.set(car, random);
    }

    @Test
    void createCar() {
        assertThat(car.getForwardNum()).isEqualTo(INIT_NUM);
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getStatus().get(name)).isEqualTo(INIT_NUM);
    }


    @ParameterizedTest
    @CsvSource({"4", "5", "6", "7", "8", "9"})
    void goForward(int randInt) {
        when(random.nextInt(RANDOM_BOUND))
                .thenReturn(randInt);

        assertThat(car.move()).isTrue();
        assertThat(car.getForwardNum()).isEqualTo(INIT_NUM + 1);
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3"})
    void validateStopForward(int randInt) {
        when(random.nextInt(RANDOM_BOUND))
                .thenReturn(randInt);

        assertThat(car.move()).isFalse();
        assertThat(car.getForwardNum()).isEqualTo(INIT_NUM);
    }
}
