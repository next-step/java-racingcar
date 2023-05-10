package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingCarTest {

    @Test
    @DisplayName("레이싱카 객체를 원하는 만큼 생성하는 메서드 테스트")
    void createRacingCars() {
        RacingCars racingCars = new RacingCars(3);

        assertThat(racingCars.getRacingCars()).hasSize(3);
    }

    @Test
    @DisplayName("레이싱카 생성 시 position 0이 맞는지 확인")
    void racingCarDefaultPositionIs0() {
        RacingCar racingCar = new RacingCar();

        assertThat(racingCar.position()).isEqualTo(0);
    }

    @Test
    @DisplayName("레이싱카가 이동하는지 확인")
    void isRacingCarMove() {
        RacingCar racingCar = new RacingCar();

        racingCar.moveForwardWhenFourHigher(new Random() {
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        });

        racingCar.moveForwardWhenFourHigher(new Random() {
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        });

        racingCar.moveForwardWhenFourHigher(new Random() {
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        });


        assertThat(racingCar.position()).isEqualTo(3);
    }
}
