package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Scanner;


public class RacingCarTest extends IOTest {

    // random value를 확인하기 위한 함수
    static Random random = new Random(4);
    public int actual(){
        int actual = 0;
        int randomValue = random.nextInt(10);
        if (randomValue >= 4){
            actual = 1;
        }
        return actual;
    }

    @Nested
    @DisplayName("Car")
    class CarTest {
        Car car = new Car();

        @Test
        @DisplayName("(1)자동차의 위치를 전달")
        public void position() {
            Assertions.assertThat(car.position()).isEqualTo(0);
        }

        @Test
        @DisplayName("(2)자동차의 위치를 업데이트")
        public void updatePosition() {
            car.updatePosition();
            Assertions.assertThat(car.position()).isEqualTo(actual());
        }
    }

    @Nested
    @DisplayName("CarArray")
    class CarArrayTest {
        CarArray carArray = new CarArray();

        @Test
        @DisplayName("(1)자동차 배열에 입력받은 갯수만큼 자동차 생성")
        public void resizeCarArray() {
            carArray.resizeCarArray(3);
        }

        @Test
        @DisplayName("(2)자동차 배열 내의 자동차 위치 전달")
        public void position() {
            for (int i = 0; i < carArray.mNumOfCar; i++) {
                Assertions.assertThat(carArray.mCarArray[i].position()).isEqualTo(0);
            }
        }

        @Test
        @DisplayName("(3)자동차 배열 내의 모든 자동차 위치를 업데이트")
        public void updateCarArrayPosition() {
            carArray.updateCarArrayPosition();
            for (int i = 0; i < carArray.mNumOfCar; i++) {
                Assertions.assertThat(carArray.mCarArray[i].position()).isEqualTo(actual());
            }
        }
    }

    @Test
    @DisplayName("Racing")
    public void race() {
        CarArray carArray = new CarArray();
        Racing racing = new Racing(carArray);
        racing.race();
    }
}
