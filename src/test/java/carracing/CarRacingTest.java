package carracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
    private CarRacing carRacing;

    @BeforeEach
    void setUpCarRacing() {
        int participateCarCount = 5;
        int moveCount = 7;
        carRacing = new CarRacing(participateCarCount, moveCount);
    }


    @Test
    void racing_ready() {
        carRacing.ready();
    }

    @Test
    void racing_참가하는_자동차_수() {
        assertThat(carRacing.participateCarSize()).isEqualTo(5);
    }

    @Test
    void racing_움직임_횟수() {
        assertThat(carRacing.racingMoveCount()).isEqualTo(7);
    }


    @Test
    void 자동차_이동거리_랜덤값_부여() {
        Random random = new Random();
        Car car = new Car();
        int bound = 10;
        int randomNumber = random.nextInt(bound);
        car.assignRandomDistance(randomNumber);
        assertThat(car.getDistance()).isNotNull();
    }

    @Test
    @DisplayName("3대의 자동차가 5번 움직였을 경우 실행결과")
    void racing_start() {
        carRacing = new CarRacing(3, 5);
        carRacing.ready();
        carRacing.start();
    }




}
