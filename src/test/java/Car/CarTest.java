package Car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    void 자동차초기상태테스트() {
        int carMoveCount = car.getMoveCount();
        assertThat(carMoveCount).isEqualTo(0);
    }

}