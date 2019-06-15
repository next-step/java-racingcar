package step2.racing.service;

import org.junit.jupiter.api.*;
import step2.racing.dto.CarPosition;
import step2.racing.dto.RacingResult;
import step2.racing.random.StubRandomGenerator;

import javax.rmi.CORBA.Stub;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.racing.model.Car.DEFAULT_POSITION;

class RacingServiceTest {

    private RacingService racingService;
    private StubRandomGenerator stubRandomGenerator;

    private final int carCount = 3;
    private final int attempts = 5;

    @Test
    @DisplayName("자동차 3대, 횟수 5번일때 모든 차가 이동하는 케이스 검증")
    void start_move() {

        int moveNumber = 6;
        stubRandomGenerator = new StubRandomGenerator(moveNumber);
        racingService = new RacingService(carCount, attempts, stubRandomGenerator);

        RacingResult racingResult = racingService.run();

        IntStream.range(0, attempts).forEach(attempt ->
                IntStream.range(0, carCount).forEach( carNumber ->
                        assertThat(racingResult.getCarPosition(attempt).getPosition(carNumber))
                                .isEqualTo(DEFAULT_POSITION + attempt)
                )
            );
    }

    @Test
    @DisplayName("자동차 3대, 횟수 5번일때 모든 차가 이동하지 않는 케이스 검증")
    void start_notMove() {

        int moveNumber = 3;
        stubRandomGenerator = new StubRandomGenerator(moveNumber);
        racingService = new RacingService(carCount, attempts, stubRandomGenerator);

        RacingResult racingResult = racingService.run();

        IntStream.range(0, attempts).forEach(attempt ->
                IntStream.range(0, carCount).forEach( carNumber ->
                        assertThat(racingResult.getCarPosition(attempt).getPosition(carNumber))
                                .isEqualTo(DEFAULT_POSITION)
                )
            );
    }
}