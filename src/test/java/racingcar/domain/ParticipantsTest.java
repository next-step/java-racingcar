package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

class ParticipantsTest {

    final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름이 5자를 초과합니다.";

    @Test
    public void 이름이_5자_이하인_차량은_Exception발생안함() {
        //given
        String name = "jason";

        //when

        //then
        Assertions.assertThatCode(() -> Participants.validateCarName(name)).doesNotThrowAnyException();
    }

    @Test
    public void 이름이_5자를_초과한_차량은_Exception발생() {
        //given
        String name = "jason1";

        //when

        //then
        Assertions.assertThatCode(() -> Participants.validateCarName(name)).hasMessageContaining(NAME_LENGTH_ERROR_MESSAGE);
    }

    @Test
    public void 전진조건_만족시_차량의_위치가_일치하는지() {
        //given
        List<Car> cars = new ArrayList<>();
        Car car1 = Car.from("jason");
        Car car2 = Car.from("pobi");
        cars.add(car1);
        cars.add(car2);

        Participants participants = Participants.getInstance(cars);

        //when
        for (int i = 0; i < participants.getParticipantCount(); i++) {
            participants.moveCarIfPositionChanged(i, true);
        }
        RacingResult result = RacingResult.toRacingResult(participants);

        //then
        Assertions.assertThat(result.getResult().get(0).getPosition()).isEqualTo(1);
        Assertions.assertThat(result.getResult().get(1).getPosition()).isEqualTo(1);
    }

    @Test
    public void 전진조건_불만족시_차량의_위치가_변하지_않는지() {
        //given
        List<Car> cars = new ArrayList<>();
        Car car1 = Car.from("jason");
        Car car2 = Car.from("pobi");
        cars.add(car1);
        cars.add(car2);

        Participants participants = Participants.getInstance(cars);

        //when
        for (int i = 0; i < participants.getParticipantCount(); i++) {
            participants.moveCarIfPositionChanged(i, false);
        }
        RacingResult result = RacingResult.toRacingResult(participants);

        //then
        Assertions.assertThat(result.getResult().get(0).getPosition()).isEqualTo(0);
        Assertions.assertThat(result.getResult().get(1).getPosition()).isEqualTo(0);
    }

    @DisplayName("RacingResult에서 Participatns로 변환 후 둘은 같은 차량 리스트를 들고 있다.")
    @Test
    public void RacingResult_에서_Participatns_로의_변환() {
        //given
        List<Car> cars = new ArrayList<>();
        Car car1 = Car.from("jason");
        Car car2 = Car.from("pobi");

        car1.go();
        car1.go();
        car2.go();

        cars.add(car1);
        cars.add(car2);

        RacingResult racingResult = RacingResult.getInstance(cars);

        //when
        Participants participants =  Participants.toParticipants(racingResult);

        //then
        Assertions.assertThat(participants.getParticipants()).isEqualTo(racingResult.getResult());
    }
}