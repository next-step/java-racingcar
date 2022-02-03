package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Participants;

class RacingResultTest {

    @Test
    public void 최종_우승자_단독() {
        //given
        List<Car> cars = Arrays.asList(new Car("jason", 3), new Car("pobi", 2), new Car("sung", 1));

        //when
        RacingResult racingResult = RacingResult.getInstance(cars);

        //then
        assertThat(racingResult.findWinners()).isEqualTo("jason");
    }

    @Test
    public void 최종_우승자_공동() {
        //given
        List<Car> cars = Arrays.asList(new Car("jason", 3), new Car("pobi", 1), new Car("sung", 3));

        //when
        RacingResult racingResult = RacingResult.getInstance(cars);

        //then
        assertThat(racingResult.findWinners()).isEqualTo("jason, sung");
    }

    @DisplayName("Participatns에서 RacingResult로 변환 후 둘은 같은 차량 리스트를 들고 있다.")
    @Test
    public void Participatns_에서_RacingResult로의_변환() {
        //given
        List<Car> cars = Arrays.asList(new Car("jason", 3), new Car("pobi", 2), new Car("sung", 1));

        Participants participants = new Participants(cars);

        //when
        RacingResult racingResult = RacingResult.getInstance(cars);

        //then
        assertThat(racingResult.getResult()).isEqualTo(participants.getParticipants());
    }
}