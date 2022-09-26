package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.dto.RaceInputDTO;
import racinggame.service.RaceService;

import java.util.List;
import java.util.function.IntPredicate;

import static org.assertj.core.api.Assertions.assertThat;

class RaceCourseTest {

    @Test
    void 자동차_경주_횟수만큼_자동차가_이동한다() {
        //given
        IntPredicate canMovePredicate = randomNumber -> true;
        List<Car> cars = List.of(new Car(canMovePredicate), new Car(canMovePredicate), new Car(canMovePredicate));
        RaceInputDTO raceInputDTO = new RaceInputDTO(3, 3);

        RaceService raceService = new RaceService();

        //when
        raceService.startRace(raceInputDTO, cars);

        //then
        assertThat(cars.get(0).distance()).isEqualTo(3);
    }
}