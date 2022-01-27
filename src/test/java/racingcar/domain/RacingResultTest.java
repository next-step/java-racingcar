package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Participants;
import racingcar.domain.racing.RacingResult;
import racingcar.domain.random.MoveGen;

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

        cars.get(0).go(new MoveGen());
        cars.get(0).go(new MoveGen());
        cars.get(0).go(new MoveGen());

        cars.get(1).go(new MoveGen());
        cars.get(1).go(new MoveGen());

        cars.get(2).go(new MoveGen());

        RacingResult racingResult = new Participants(cars).race();

        //then
        assertThat(racingResult.getWinner()).isEqualTo("jason");
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

        cars.get(0).go(new MoveGen());
        cars.get(0).go(new MoveGen());
        cars.get(0).go(new MoveGen());

        cars.get(1).go(new MoveGen());
        cars.get(1).go(new MoveGen());

        cars.get(2).go(new MoveGen());
        cars.get(2).go(new MoveGen());
        cars.get(2).go(new MoveGen());

        RacingResult racingResult = new Participants(cars).race();

        //then
        assertThat(racingResult.getWinner()).isEqualTo("jason, sung");
    }

    @DisplayName("Participatns에서 RacingResult로 변환 후 둘은 같은 차량 리스트를 들고 있다.")
    @Test
    public void Participatns_에서_RacingResult로의_변환() {
        //given
        List<Car> cars = new ArrayList<>();
        Car car1 = Car.from("jason");
        Car car2 = Car.from("pobi");

        car1.go(new MoveGen());
        car1.go(new MoveGen());
        car2.go(new MoveGen());

        cars.add(car1);
        cars.add(car2);

        Participants participants = new Participants(cars);

        //when
        RacingResult racingResult = RacingResult.toRacingResult(participants);

        //then
        assertThat(racingResult.getResult()).isEqualTo(participants.getParticipants());
    }
}