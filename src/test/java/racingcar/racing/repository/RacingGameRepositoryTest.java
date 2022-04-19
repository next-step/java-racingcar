package racingcar.racing.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.play.RacingMovePolicy;
import racingcar.play.ZeroToNineRandomPolicy;
import racingcar.racing.model.Car;
import racingcar.racing.model.RacingRecord;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameRepositoryTest {


    RacingGameRepository racingCarRepository = new RacingGameRepository();

    RacingMovePolicy racingMovePolicy = new ZeroToNineRandomPolicy();

    private static final Random random = new Random();

    @AfterEach
    void afterEach() {
        racingCarRepository.clearStore();
    }

    @Test
    @DisplayName("RacingGameRepository save 로직 테스트")
    void save() {
        // given
        List<RacingRecord> recordList = new ArrayList<>(Arrays.asList( new RacingRecord(0, 0, 0),
                new RacingRecord(1, 0, 1),
                new RacingRecord(1, 1, 2),
                new RacingRecord(2, 1, 2),
                new RacingRecord(1, 2, 3)));
        int tryNumber = 0;
        int findId = 0;

        // when
        for (RacingRecord racingRecord : recordList) {
            racingCarRepository.save(racingRecord);
        }

        // then
        int result = (int) recordList.stream()
                .filter(racingRecord -> racingRecord.getCarId() == findId).count();

        int answer = racingCarRepository.findAllById(findId).size();

        assertThat(result).isEqualTo(answer);

    }

    @DisplayName("RacingGameRepository findAllByTryNumber 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3,5,4,6})
    void findAllByTryNumber(int tryNumber) {
        // given
        List<Car> carList = new ArrayList<>(Arrays.asList( new Car(0, 0),
                new Car(1, 0),
                new Car(2, 0)));


        // when
        for(int i = 0; i < tryNumber; i++) {
           playGame(carList, i);
        }

        // then
        int randomTryNumber = random.nextInt(tryNumber);
        int result = (int) racingCarRepository.findAllByTryNumber(randomTryNumber).size();

        assertThat(result).isEqualTo(carList.size());
    }

    private void playGame(List<Car> carList, int tryNumber) {
        for (Car car : carList) {
            car.forward(racingMovePolicy.racing(10));

            RacingRecord record = new RacingRecord(car.getId(), car.getxCoordinate(), tryNumber);
            racingCarRepository.save(record);
        }
    }
}