package step3_racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarTest {

    private Car car;
    private Random random;
    private static final int INITNUM = 0;
    private static final int RANDOMBOUND = 10;

    @BeforeEach
    void setUp(){
        car = new Car();
        random = mock(Random.class);
    }

    @Test
    void createCar(){
        assertThat(car.getForwardNum()).isEqualTo(INITNUM);
    }

    /*Random mock test 참고 링크: https://multifrontgarden.tistory.com/187*/
    @ParameterizedTest
    @CsvSource({"4", "5", "6", "7", "8", "9"})
    void goForward(int randInt){
        when(random.nextInt(RANDOMBOUND))
                .thenReturn(randInt);
        car.setRandom(random);

        assertThat(car.goForward()).isTrue();
        assertThat(car.getForwardNum()).isEqualTo(INITNUM + 1);
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3"})
    void validateStopForward(int randInt){
        when(random.nextInt(RANDOMBOUND))
                .thenReturn(randInt);
        car.setRandom(random);

        assertThat(car.goForward()).isFalse();
        assertThat(car.getForwardNum()).isEqualTo(INITNUM);
    }
}
