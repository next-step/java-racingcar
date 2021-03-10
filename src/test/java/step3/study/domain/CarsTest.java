package step3.study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.study.util.RandomGenerator;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1","2,3","3,5"})
    @DisplayName("입력받은 숫자만큼 자동차가 생성된다.")
    void createCarsTest(int carCount, int tryCount) {
        RequestRacingDTO requestRacingDTO = new RequestRacingDTO(carCount,tryCount);
        assertThat(Cars.of(requestRacingDTO).size()).isEqualTo(carCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1","2,3"})
    @DisplayName("입력받은 숫자만큼 경주가 실행된다.")
    void playRacingGameForTryCount(int carCount, int tryCount) {
        RequestRacingDTO requestRacingDTO = new RequestRacingDTO(carCount, tryCount);
        Cars cars = new Cars(Cars.of(requestRacingDTO));
        ResponseRacingDTO responseRacingDTO = cars.moveCarsForTryCount(requestRacingDTO, new RandomGenerator(new Random()));

        assertThat(responseRacingDTO.getRecodesList().size()).isEqualTo(tryCount);
    }
}