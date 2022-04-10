package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarProgressServiceTest {

    RacingCarProgressService racingCarProgressService;
    @BeforeEach
    void beforeEach() {
        racingCarProgressService = new RacingCarProgressService();
    }

    @Test
    @DisplayName("입력받은 갯수만큼 자동차 객체 생성 확인")
    void confirmCarObjectCreation() {
        int numberOfCars = 3;

        racingCarProgressService.createCars(numberOfCars);

        assertThat(racingCarProgressService.getCarsList()).hasSize(numberOfCars);
    }

    @Test
    @DisplayName("생성된 랜덤한 값이 0에서 9사이의 범위안에 들어오는지 확인")
    void confirmTheRandomValueRange() {
        assertThat(racingCarProgressService.getRandomValue()).isBetween(0, 9);
    }
}
