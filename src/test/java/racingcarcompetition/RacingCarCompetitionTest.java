package racingcarcompetition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarCompetitionTest {
    final static int TOTAL_NUMBER_OF_CARS = 2;
    final static int TOTAL_MOVING_COUNT = 2;
    RacingCarCompetition racingCarCompetition;
    RacingCarInfo racingCarInfo;
    RandomGenerator randomGenerator = new RandomNumber(10);
    ;
    RandomGenerator testRandomMockGenerator = new TestRandomNumberGenerator();
    Car car;


    @BeforeEach
    void init() {
        car = new Car();
        racingCarCompetition = new RacingCarCompetition();
        racingCarInfo = new RacingCarInfo(TOTAL_NUMBER_OF_CARS, TOTAL_MOVING_COUNT, testRandomMockGenerator);
    }

    @DisplayName(value = "랜덤값 범위 확인 테스트")
    @RepeatedTest(5)
    void randomNumberTest() {
        assertThat(randomGenerator.generateRandom()).isBetween(0, 9);
    }

    @DisplayName(value = "값 저장 및 데이터 가져오기 테스트. ")
    @ParameterizedTest()
    @CsvSource({"1,4", "2,44"})
    void carMethodTest(int movingCount, String resultCarMovingData) {
        car.recordCarData(TOTAL_MOVING_COUNT, testRandomMockGenerator);
        assertThat(car.findEachMovingData(movingCount)).isEqualTo(resultCarMovingData);
    }

    @DisplayName(value = "RacingCarInfo 데이터 가져오는 여부 테스트. 현재 데이터 ={44,44}")
    @Test()
    void findEachRoundRacingCarDataTest() {
        List<String> resultData = racingCarInfo.findEachRoundRacingCarData(2);
        assertThat(resultData).isEqualTo(List.of("44", "44"));
    }


}