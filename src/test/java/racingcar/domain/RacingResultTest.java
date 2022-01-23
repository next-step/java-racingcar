package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

class RacingResultTest {

    @Test
    public void 최종_우승자_단독() {
        //given
        List<Car> cars = new ArrayList<>();
        Car car1 = Car.from("jason");
        Car car2 = Car.from("pobi");
        Car car3 = Car.from("sung");

        //when
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        Participants participants = Participants.getInstance(cars);

        participants.moveCarIfPositionChanged(0, true);
        participants.moveCarIfPositionChanged(0, true);
        participants.moveCarIfPositionChanged(0, true);

        participants.moveCarIfPositionChanged(1, true);
        participants.moveCarIfPositionChanged(1, true);

        participants.moveCarIfPositionChanged(2, true);

        RacingResult racingResult = RacingResult.toRacingResult(participants);

        //then
        Assertions.assertThat(racingResult.getWinner()).isEqualTo("jason");
    }

    @Test
    public void 최종_우승자_공동() {
        //given
        List<Car> cars = new ArrayList<>();
        Car car1 = Car.from("jason");
        Car car2 = Car.from("pobi");
        Car car3 = Car.from("sung");

        //when
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        Participants participants = Participants.getInstance(cars);

        participants.moveCarIfPositionChanged(0, true);
        participants.moveCarIfPositionChanged(0, true);
        participants.moveCarIfPositionChanged(0, true);

        participants.moveCarIfPositionChanged(1, true);

        participants.moveCarIfPositionChanged(2, true);
        participants.moveCarIfPositionChanged(2, true);
        participants.moveCarIfPositionChanged(2, true);

        RacingResult racingResult = RacingResult.toRacingResult(participants);

        //then
        Assertions.assertThat(racingResult.getWinner()).isEqualTo("jason, sung");
    }

    @DisplayName("Participatns에서 RacingResult로 변환 후 둘은 같은 차량 리스트를 들고 있다.")
    @Test
    public void Participatns_에서_RacingResult로의_변환() {
        //given
        List<Car> cars = new ArrayList<>();
        Car car1 = Car.from("jason");
        Car car2 = Car.from("pobi");

        car1.go();
        car1.go();
        car2.go();

        cars.add(car1);
        cars.add(car2);

        Participants participants = Participants.getInstance(cars);

        //when
        RacingResult racingResult = RacingResult.toRacingResult(participants);

        //then
        Assertions.assertThat(racingResult.getResult()).isEqualTo(participants.getParticipants());
    }
}