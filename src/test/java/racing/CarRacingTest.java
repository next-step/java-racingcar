package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import racing.model.RaceRecord;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarRacingTest {

    @DisplayName("성공 :: carRacing 10번 반복 테스트")
    @RepeatedTest(10)
    void start() {
        // given
        CarRacing carRacing = new CarRacing(3, 5);

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
            CarRacing carRacing = new CarRacing(carNumber, times);
        }).withMessageContaining("");
    }


    @DisplayName("TrackRecords 생성 확인")
    @Test
    void getRaceRecords() {
        // given
        CarRacing carRacing = new CarRacing(5, 3);

        // when
        carRacing.run();

        // then
        List<RaceRecord> raceRecords = carRacing.getRaceRecords();
        assertThat(raceRecords.size()).isEqualTo(3);
        raceRecords.forEach(r -> {
            assertThat(r.getTrackRecords().size()).isEqualTo(5);
        });

    }
}