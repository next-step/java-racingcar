package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import racing.car.CarRacing;
import racing.car.MovableRule;
import racing.car.RandomMovableRule;
import racing.car.model.RaceRecord;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarRacingTest {

    @DisplayName("성공 :: carRacing 10번 반복 테스트")
    @RepeatedTest(10)
    void start() {
        // given
        CarRacing carRacing = new CarRacing(5, 3, new RandomMovableRule());

        // when
        carRacing.run();

        // then
        assertThat(carRacing.getRaceRecords().size()).isEqualTo(5);
    }

    @DisplayName("실패 :: 잘못된 입력값")
    @ParameterizedTest
    @CsvSource({"0, 5", "3, 0", "-1, -2"})
    void start_fail(ArgumentsAccessor argumentsAccessor) {
        int carNumber = argumentsAccessor.getInteger(0);
        int times = argumentsAccessor.getInteger(1);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            CarRacing carRacing = new CarRacing(carNumber, times, new RandomMovableRule());
        }).withMessageContaining("");
    }


    @DisplayName("TrackRecords 생성 확인")
    @Test
    void getRaceRecords() {
        // given
        CarRacing carRacing = new CarRacing(5, 3, new RandomMovableRule());

        // when
        carRacing.run();

        // then
        List<RaceRecord> raceRecords = carRacing.getRaceRecords();
        assertThat(raceRecords.size()).isEqualTo(2);
        raceRecords.forEach(r -> {
            assertThat(r.getTrackRecords().size()).isEqualTo(5);
        });

    }

    @DisplayName("모든 차가 움직인 경우")
    @ParameterizedTest
    @CsvSource({"5, 3", "3, 10", "10, 20"})
    void run_success(ArgumentsAccessor argumentsAccessor) {
        // given
        MovableRule movableRule = () -> true;
        int carNumber = argumentsAccessor.getInteger(0);
        int times = argumentsAccessor.getInteger(1);
        CarRacing carRacing = new CarRacing(carNumber, times, movableRule);

        // when
        carRacing.run();

        // then
        RaceRecord lastRaceRecord = carRacing.getRaceRecords().get(times - 1);
        Optional<Integer> exception = lastRaceRecord.getTrackRecords()
                .stream()
                .filter(r -> r != times)
                .findAny();
        assertThat(exception.isPresent()).isEqualTo(false);

    }


    @DisplayName("모든 차가 움직이지 않은 경우")
    @ParameterizedTest
    @CsvSource({"10, 3", "3, 3", "15, 10"})
    void run_fail(ArgumentsAccessor argumentsAccessor) {
        // given
        MovableRule movableRule = () -> false;
        int carNumber = argumentsAccessor.getInteger(0);
        int times = argumentsAccessor.getInteger(1);
        CarRacing carRacing = new CarRacing(carNumber, times, movableRule);

        // when
        carRacing.run();

        // then
        RaceRecord lastRaceRecord = carRacing.getRaceRecords().get(times - 1);
        Optional<Integer> exception = lastRaceRecord.getTrackRecords()
                .stream()
                .filter(r -> r != 0)
                .findAny();
        assertThat(exception.isPresent()).isEqualTo(false);

    }

}