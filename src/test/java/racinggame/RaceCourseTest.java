package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.dto.RaceConfigurationDTO;

import java.util.List;
import java.util.function.IntPredicate;

import static org.assertj.core.api.Assertions.assertThat;

class RaceCourseTest {

    @Test
    void 자동차_경주_횟수만큼_자동차가_이동한다() {
        //given
        RaceConfigurationDTO dto = new RaceConfigurationDTO(3, 1);
        RaceResultView raceResultView = new RaceResultView();

        IntPredicate canMovePredicate = randomNumber -> true;
        List<Car> cars = List.of(new Car(canMovePredicate), new Car(canMovePredicate), new Car(canMovePredicate));

        RaceCourse raceCourse = new RaceCourse(cars, dto);

        //when
        raceCourse.startRace(raceResultView);

        //then
        assertThat(cars.get(0).distance()).isEqualTo(3);
    }
}