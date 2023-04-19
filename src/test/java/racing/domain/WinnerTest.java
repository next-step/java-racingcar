package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    @DisplayName("4단계 - 자동차 경주(우승자) - 자동차 경주 게임을 완료한 후 우승자 이름이 하나 이상 반환되는지 확인")
    @Test
    void award() {
        //given
        Racing racing = new Racing(1, Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3")));
        RacingCars racingCars = racing.race();

        //when
        List<String> namesOfWinner = Winner.award(racingCars);

        //then
        assertThat(namesOfWinner).hasSizeGreaterThanOrEqualTo(1);
    }

}
