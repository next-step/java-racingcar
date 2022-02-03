package racingcar.domain.car;


import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    @Test
    public void 참가자_객체를_생성한다() {
        //given
        String[] names = {"jason", "pobi", "sung"};

        //when
        Participants participants = Participants.createCars(names);
        List<Car> cars = participants.getParticipants();

        //then
        assertThat(cars.stream()
            .map(car -> car.getName())
            .collect(Collectors.toList())).containsExactlyInAnyOrder("jason", "pobi", "sung");
    }

    @Test
    public void 참가_차량_생성_테스트() {
        //given
        String[] names = {"jason", "pobi"};

        //when
        Participants participants = Participants.createCars(names);
        List<String> carNames = participants.getParticipants().stream()
            .map(Car::getName)
            .collect(Collectors.toList());

        //then
        assertThat(carNames).containsExactly("jason", "pobi");
    }

    @Test
    public void 최종_우승자_단독() {
        //given
        List<Car> cars = Arrays.asList(new Car("jason", 3), new Car("pobi", 2), new Car("sung", 1));

        //when
        Participants participants = new Participants(cars);

        //then
        assertThat(participants.findWinners()).isEqualTo("jason");
    }

    @Test
    public void 최종_우승자_공동() {
        //given
        List<Car> cars = Arrays.asList(new Car("jason", 3), new Car("pobi", 2), new Car("sung", 3));

        //when
        Participants participants = new Participants(cars);

        //then
        assertThat(participants.findWinners()).isEqualTo("jason, sung");
    }
}