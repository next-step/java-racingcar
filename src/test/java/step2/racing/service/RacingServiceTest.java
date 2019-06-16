package step2.racing.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.racing.dto.RacingResult;
import step2.racing.random.StubRandomGenerator;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.racing.model.Car.DEFAULT_POSITION;
import static step2.racing.model.Car.MOVE_VALUE;
import static step2.racing.service.RacingService.START_UNIQUE_CAR_NUMBER;

class RacingServiceTest {

    private RacingService racingService;
    private StubRandomGenerator stubRandomGenerator;

    private final int carCount = 3;
    private final int attempts = 5;

    @ParameterizedTest(name = "랜덤값 : {arguments}")
    @ValueSource(ints = {6, 3})
    @DisplayName("자동차 3대, 레이싱 횟수 5번일때 랜덤값에 따라 차의 이동 검증")
    void start(int randomNumber) {

        stubRandomGenerator = new StubRandomGenerator(randomNumber);
        racingService = new RacingService(carCount, attempts, stubRandomGenerator);

        RacingResult racingResult = racingService.run();

        IntStream.range(0, attempts)
                .forEach(attempt -> IntStream.rangeClosed(START_UNIQUE_CAR_NUMBER, carCount)
                        .forEach(uniqueNumber -> assertThat(racingResult.getCarPosition(attempt).getPosition(uniqueNumber))
                                                .isEqualTo(randomNumber >= MOVE_VALUE ? DEFAULT_POSITION + attempt : DEFAULT_POSITION)));
    }
}