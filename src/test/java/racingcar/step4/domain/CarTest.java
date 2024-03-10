package racingcar.step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.step4.domain.dto.ParticipantResultDto;
import racingcar.step4.domain.move.IncrementMoveStrategy;

class CarTest {

    @DisplayName("전략에 따라 거리를 이동한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "3:3", "5:5"}, delimiter = ':')
    void moveLocationDependsOnMoveStrategy(int round, int currentLocation) {
        // given
        Car car = new Car("Test", new IncrementMoveStrategy());
        ParticipantResultDto participantResultDto = null;

        // when
        for (int i = 0; i < round; i++) {
            car.move();
        }
        participantResultDto = car.getParticipantResult();

        // then
        Assertions.assertThat(participantResultDto.getLocation()).isEqualTo(currentLocation);
    }
}