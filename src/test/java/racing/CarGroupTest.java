package racing;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 차량 그룹에 대한 테스트
 */
class CarGroupTest {

    static CarGroup carGroup;

    private Random originalRandom;

    @BeforeEach
    void setUp() throws Exception {
        HashMap<Integer, Car> cars = new HashMap<>(
            Map.of(
                0, new Car(),
                1, new Car(),
                2, new Car()
            )
        );
        carGroup = new CarGroup(cars);
        // Car.random 필드 접근
        Field randomField = Car.class.getDeclaredField("random");
        randomField.setAccessible(true);
        // 원본 Random 백업
        originalRandom = (Random)randomField.get(null);
    }

    @AfterEach
    void tearDown() throws Exception {
        // 테스트 후 Car.random 복원
        Field randomField = Car.class.getDeclaredField("random");
        randomField.setAccessible(true);
        randomField.set(null, originalRandom);
    }

    @Test
    @DisplayName("차량 전체 이동 테스트")
    void moveTest() throws Exception {
        Field randomField = Car.class.getDeclaredField("random");
        randomField.setAccessible(true);
        randomField.set(null, new Random() {
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        });
        carGroup.go();
        for (int i = 0; i < carGroup.cars.size(); i++) {
            Car car = carGroup.cars.get(i);
            assertAll(
                () -> assertNotNull(car),
                () -> assertThat(car.position).isEqualTo(1)
            );
        }
    }
}