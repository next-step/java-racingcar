package step_3;

import org.junit.jupiter.api.Test;
import step_3.dto.RaceConfigurationDTO;

import java.util.List;
import java.util.function.IntPredicate;

import static org.assertj.core.api.Assertions.assertThat;

class RaceCourseTest {

    @Test
    void 자동차_경주_횟수만큼_자동차가_이동한다() {
        //given
        RaceConfigurationDTO dto = new RaceConfigurationDTO(3, 1);
        ResultView resultView = new ResultView();

        List<Car> cars = getCars();
        RaceCourse raceCourse = new RaceCourse(cars, dto);

        //when
        raceCourse.startRace(resultView);

        //then
        assertThat(cars.get(0).distance()).isEqualTo(3);
    }

    private List<Car> getCars() {
        IntPredicate canMovePredicate = randomNumber -> true;
        return List.of(new Car(canMovePredicate), new Car(canMovePredicate), new Car(canMovePredicate));
    }
}