package Car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    void setUp(){
        car = new Car();
    }

    @Test
    void 자동차초기상태테스트(){
        String result = car.getStatus();
        assertThat(result).isEqualTo("-");
    }

    @ParameterizedTest
    @CsvSource({
            "1, --, 2",
            "2, ---, 3",
            "5, ------, 6"
    })
    void 자동차전진테스트(int moveCount, String answer, int moveCountAnswer) throws NoSuchFieldException, IllegalAccessException {
        for(int i=0;i<moveCount;i++){
            car.move();
        }
        String result = car.getStatus();
        assertThat(result).isEqualTo(answer);

        Field field = car.getClass().getDeclaredField("moveCount");
        field.setAccessible(true);
        int moveCountByCar = (int)field.get(car);
        assertThat(moveCountByCar).isEqualTo(moveCountAnswer);
    }

}