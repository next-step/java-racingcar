package racing;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.car.CarRacing;
import racing.car.MovableRule;
import racing.car.RandomMovableRule;
import racing.car.model.RaceRecord;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarRacingTest {
    public String[] names = {"lee", "hong", "kim", "jung", "park"};

    @DisplayName("성공 :: carRacing 10번 반복 테스트")
    @RepeatedTest(10)
    void start() {
        // given
        CarRacing carRacing = new CarRacing(names, 3, new RandomMovableRule());

        // when
        carRacing.run();

        // then
        assertThat(carRacing.getRaceRecords().size()).isEqualTo(5);
    }

    @DisplayName("실패 :: 잘못된 입력값")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, 0})
    void start_fail(int times) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CarRacing carRacing = new CarRacing(names, times, new RandomMovableRule());
        }).withMessageContaining("경기 횟수는 1회 이상이어야 합니다.");
    }


    @DisplayName("TrackRecords 생성 확인")
    @Test
    void getRaceRecords() {
        // given
        CarRacing carRacing = new CarRacing(names, 3, new RandomMovableRule());

        // when
        carRacing.run();

        // then
        List<RaceRecord> raceRecords = carRacing.getRaceRecords();
        assertThat(raceRecords.size()).isEqualTo(2);
        raceRecords.forEach(r -> {
            assertThat(r.getTrackRecords().size()).isEqualTo(5);
        });

    }

    private static Stream<Arguments> getArguments() {
        return Stream.of(
                Arguments.of(Arrays.array("lee", "kim", "hong"), 10), // null strings should be considered blank
                Arguments.of(Arrays.array("tony", "jen"), 3),
                Arguments.of(Arrays.array("tony", "haha", "mini", "toto"), 5)
        );
    }

    @DisplayName("모든 차가 움직인 경우")
    @ParameterizedTest
    @MethodSource("getArguments")
    void run_success(String[] names, int times) {
        // given
        MovableRule movableRule = () -> true;
        CarRacing carRacing = new CarRacing(names, times, movableRule);

        // when
        carRacing.run();

        // then
        RaceRecord lastRaceRecord = carRacing.getRaceRecords().get(times - 1);
        Optional<Integer> exception = lastRaceRecord.getTrackRecords().entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(v -> v != times)
                .findAny();

        assertThat(exception.isPresent()).isEqualTo(false);
    }

    @DisplayName("모든 차가 움직이지 않은 경우")
    @ParameterizedTest
    @MethodSource("getArguments")
    void run_fail(String[] names, int times) {
        // given
        MovableRule movableRule = () -> false;
        CarRacing carRacing = new CarRacing(names, times, movableRule);

        // when
        carRacing.run();

        // then
        RaceRecord lastRaceRecord = carRacing.getRaceRecords().get(times - 1);
        Optional<Integer> exception = lastRaceRecord.getTrackRecords().entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(v -> v == times)
                .findAny();

        assertThat(exception.isPresent()).isEqualTo(false);
    }

    @DisplayName("승자 확인하기")
    @ParameterizedTest
    @MethodSource("getArguments")
    void findWinner(String[] names, int times) {
        // given
        MovableRule movableRule = () -> true;
        CarRacing carRacing = new CarRacing(names, times, movableRule);

        // when
        carRacing.run();
        List<String> winners = carRacing.findWinner();

        // then
        assertThat(winners.size()).isEqualTo(names.length);
    }

}