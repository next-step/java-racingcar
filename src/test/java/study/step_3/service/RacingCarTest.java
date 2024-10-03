package study.step_3.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RacingCarTest {

    RacingCar racingCar;
    Random random;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
        random = new Random();
    }

    @DisplayName("전진하는 조건 값의 범위는 0부터 9까지이다.")
    @ParameterizedTest
    @ValueSource(ints = {10, 10, 10, 10, 10, 10, 10, 10, 10})
    void getRandomValue(int bound) {

        //given & when
        int randomResult = random.nextInt(bound);
        log.println("randomResult :" + randomResult);

        //then
        assertThat(randomResult).isBetween(0, 9);
    }

    // 기준값을 0으로 잡고 무조건 true 리턴
    @DisplayName("랜덤 값중 주어진 기준값 이상 일 경우 True 를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"10 0"}, delimiter = ' ')
    public void canMove(int bound, int standard) {

        //given
        int randomResult = racingCar.getRandomValue(bound);
        log.println("randomResult :" + randomResult + " standard :" + standard);

        //when & then
        assertTrue(randomResult > standard);
    }

    @DisplayName("랜덤 값중 주어진 기준값 이상 일 경우 True 를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"10 11"}, delimiter = ' ')
    public void cantMove(int bound, int standard) {

        //given
        int randomResult = racingCar.getRandomValue(bound);
        log.println("randomResult :" + randomResult + " standard :" + standard);

        //when & then
        assertFalse(randomResult > standard);
    }

    @DisplayName("랜덤 값의 범위와 기준값을 파라미터로 받고 파라미터 값 이상일 경우 distance가 1 증가한다.")
    @ParameterizedTest
    @CsvSource({"5,0", "10,0"})
    void canDrive(int bound, int standard) {
        // when & then
        assertThat(racingCar.drive(bound, standard)).isEqualTo(1);
    }

    @DisplayName("랜덤 값의 범위와 기준값을 파라미터로 받고 파라미터 값 이하일 경우 distance는 증가하지 않는다.")
    @ParameterizedTest
    @CsvSource({"5,6", "10,11"})
    void cantDrive(int bound, int standard) {
        // when & then
        assertThat(racingCar.drive(bound, standard)).isEqualTo(0);
    }

}
