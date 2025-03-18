package racing;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 자동차 테스트 클래스
 */
class CarTest {

    private Random originalRandom;

    /**
     * 분기 테스트를 위해 Java Reflection을 사용하여 Random 필드를 접근
     */
    @BeforeEach
    void setUp() throws Exception {
        // Car.random 필드 접근
        Field randomField = Car.class.getDeclaredField("random");
        randomField.setAccessible(true);
        // 원본 Random 백업
        originalRandom = (Random)randomField.get(null);
    }
    /**
     * 분기 테스트 후 Random 필드 복원
     */
    @AfterEach
    void tearDown() throws Exception {
        // 테스트 후 Car.random 복원
        Field randomField = Car.class.getDeclaredField("random");
        randomField.setAccessible(true);
        randomField.set(null, originalRandom);
    }

    @Test
    @DisplayName("차 생성에 대한 테스트")
    void generationTest() {
        Car car = new Car();
        assertAll(
            () -> assertNotNull(car),
            () -> assertThat(car.position).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("Random 값 4 이상일 때 차량 이동")
    void determineGoTest() throws Exception {
        Field randomField = Car.class.getDeclaredField("random");
        randomField.setAccessible(true);
        randomField.set(null, new Random(){
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        });
        Car car = new Car();
        car.move();
        assertThat(car.position).isEqualTo(1);
    }

    @Test
    @DisplayName("Random 값 4 미만일 때 차량 움직이지 않음")
    void determineStopTest() throws Exception {
        Field randomField = Car.class.getDeclaredField("random");
        randomField.setAccessible(true);
        randomField.set(null, new Random(){
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        });
        Car car = new Car();
        car.move();
        assertThat(car.position).isEqualTo(0);
    }

    @Test
    @DisplayName("차량 위치 출력 테스트")
    void printPositionTest() throws Exception {
        Field randomField = Car.class.getDeclaredField("random");
        randomField.setAccessible(true);
        randomField.set(null, new Random(){
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        });
        Car car = new Car();
        car.move();
        assertThat(car.print()).isEqualTo("-");
    }
}