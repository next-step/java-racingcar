package racingcar.v1.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.v1.domain.policy.RacingMovePolicy;
import racingcar.v1.domain.policy.ZeroToNineRandomPolicy;
import racingcar.v1.domain.Car;
import racingcar.v1.domain.RacingRecord;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameRepositoryTest {


    private static final RacingGameRepository racingCarRepository = new RacingGameRepository();

    RacingMovePolicy racingMovePolicy = new ZeroToNineRandomPolicy();

    private static final Random random = new Random();

    private static List<RacingRecord> recordList;

    private static List<Car> carList;


    @BeforeAll
    static void beforeAll() {
        recordList = new ArrayList<>(Arrays.asList( new RacingRecord(0, 0, 0, "hong0"),
                new RacingRecord(1, 0, 1, "hong1"),
                new RacingRecord(1, 1, 2, "hong1"),
                new RacingRecord(2, 1, 2, "hong2"),
                new RacingRecord(1, 2, 3, "hong1")));

        carList = new ArrayList<>(Arrays.asList( new Car(0, "hong0", 0),
                new Car(1, "hong1", 0),
                new Car(2, "hong2", 0)));
    }

    @AfterEach
    void afterEach() {
        racingCarRepository.clearStore();
    }

    @DisplayName("RacingGameRepository save 로직 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void save(int findId) {

        for (RacingRecord racingRecord : recordList) {
            racingCarRepository.save(racingRecord);
        }

        int result = (int) recordList.stream()
                .filter(racingRecord -> racingRecord.getCarId() == findId).count();

        int answer = racingCarRepository.findAllById(findId).size();

        assertThat(result).isEqualTo(answer);

    }

    @DisplayName("RacingGameRepository findAllRacingRecordByTryNumber 테스트 시도 회수 만큼 데이터 저장이 잘 되었는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3,5,4,6})
    void findAllRacingRecordByTryNumber(int tryNumber) {
        for(int i = 0; i < tryNumber; i++) {
           playGame(carList, i);
        }

        int randomTryNumber = random.nextInt(tryNumber);
        int result = (int) racingCarRepository.findAllRacingRecordByTryNumber(randomTryNumber).size();

        assertThat(result).isEqualTo(carList.size());
    }

    private void playGame(List<Car> carList, int tryNumber) {
        for (Car car : carList) {
            car.forward(racingMovePolicy.execute(10));

            RacingRecord record = new RacingRecord(car.getId(), car.getPosition(), tryNumber, car.getParticipantName());
            racingCarRepository.save(record);
        }
    }

    @Test
    void findAllByIdTest() {

    }
}