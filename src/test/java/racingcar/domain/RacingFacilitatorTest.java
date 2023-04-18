package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.StageRecord;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingFacilitatorTest {

    @DisplayName("RacingFacilitator가 레이싱에 시도횟수와 함께 cars를 참가 신청 받는다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi,crong", "pobi,crong,honux"})
    void participate(String value) {
        List<String> carNames = List.of(value.split(","));
        PositiveNumber racingTryCount = new PositiveNumber(5);

        RacingFacilitator racingFacilitator = RacingFacilitator.participate(racingTryCount, carNames);

        assertThat(racingFacilitator.getRacingTryCount().getNumber()).isEqualTo(5);
        assertThat(racingFacilitator.getRacing().getCars()).hasSize(carNames.size());
    }

    @DisplayName("RacingFacilitator가 시도횟수만큼 레이싱을 진행시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi,crong", "pobi,crong,honux"})
    void processRacing(String value) {
        List<String> carNames = List.of(value.split(","));
        PositiveNumber racingTryCount = new PositiveNumber(5);

        RacingFacilitator racingFacilitator = RacingFacilitator.participate(racingTryCount, carNames);
        List<StageRecord> stageRecords = racingFacilitator.processRacing();

        assertThat(stageRecords).hasSize(racingTryCount.getNumber());

        for (int stage = 0; stage < racingTryCount.getNumber(); stage++) {
            assertThat(stageRecords.get(stage).getRecords()).hasSize(carNames.size());
            assertThat(stageRecords.get(stage).getStage()).isEqualTo(stage + 1);
        }
    }

    @DisplayName("RacingFacilitator가 최종 우승자의 이름을 return한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi,crong", "pobi,crong,honux"})
    void getWinners(String value) {
        List<String> carNames = List.of(value.split(","));
        PositiveNumber racingTryCount = new PositiveNumber(5);

        RacingFacilitator racingFacilitator = RacingFacilitator.participate(racingTryCount, carNames);
        racingFacilitator.processRacing();
        String winners = racingFacilitator.getWinners();

        assertThat(winners).isNotBlank();
    }

    @DisplayName("경기가 진행되지 않고 winner를 구하면 IllegalStateException를 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi,crong", "pobi,crong,honux"})
    void getWinnersException(String value) {
        List<String> carNames = List.of(value.split(","));
        PositiveNumber racingTryCount = new PositiveNumber(5);

        RacingFacilitator racingFacilitator = RacingFacilitator.participate(racingTryCount, carNames);

        assertThatThrownBy(racingFacilitator::getWinners)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("최종 stage record가 없습니다.");
    }
}
