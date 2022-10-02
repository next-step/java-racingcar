package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @Test
    public void 입력값에_맞춰서_carList생성확인() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int value = 5;
        RacingCar racingCar = new RacingCar();
        Method carList = RacingCar.class.getDeclaredMethod("carList", int.class);
        carList.setAccessible(true);
        Car[] actual = (Car[]) carList.invoke(racingCar, value);
        assertThat(actual.length).isEqualTo(value);
    }

    @Test
    public void 차량전진횟수확인() {
        int previousLocation = 0;
        Car car = new Car(0);
        int location = car.advanceNumber();
        assertThat(location - previousLocation).isLessThan(10);
    }

}