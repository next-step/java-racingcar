package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingHistoriesTest {
    @Test
    @DisplayName("레이싱 플릿으로 새로운 히스토리를 생성하면 한개의 초기 히스토리만 가집니다")
    void initializedRacingHistoriesTest() {
        List<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2", "Car3"));
        RacingFleet fleet = RacingFleet.valueOf(carNames);
        RacingHistories histories = RacingHistories.newInstance(fleet);
        assertThat(histories.value().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("racingFleet에 대해 record를 하면 해당 차량 상태들이 기록됩니다.")
    void recordRacingStateTest() {
        List<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2", "Car3"));
        RacingFleet fleet = RacingFleet.valueOf(carNames);
        RacingHistories histories = RacingHistories.newInstance(fleet);
        histories.recordRacingState(fleet);
        assertThat(histories.value().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("같은 racingFleet로 생선한 히스토리는 equals true입니다.")
    void equalsTest() {
        List<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2", "Car3"));
        RacingFleet fleet = RacingFleet.valueOf(carNames);
        RacingHistories histories1 = RacingHistories.newInstance(fleet);
        RacingHistories histories2 = RacingHistories.newInstance(fleet);
        assertThat(histories1).isEqualTo(histories2);
    }

    @Test
    @DisplayName("같은 racingFleet로 생선한 히스토리는 hashcode가 같습니다.")
    void hashCodeTest() {
        List<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2", "Car3"));
        RacingFleet fleet = RacingFleet.valueOf(carNames);
        RacingHistories histories1 = RacingHistories.newInstance(fleet);
        RacingHistories histories2 = RacingHistories.newInstance(fleet);
        assertThat(histories1.hashCode()).isEqualTo(histories2.hashCode());
    }
}
