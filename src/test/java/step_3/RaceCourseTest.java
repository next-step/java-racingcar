package step_3;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.IntPredicate;

import static org.assertj.core.api.Assertions.assertThat;

class RaceCourseTest {

    @Test
    void 자동차_경주_횟수만큼_자동차가_이동한다() {
        //given
        List<Car> cars = getCars();
        RaceCourse raceCourse = new RaceCourse(cars, 3);

        //when
        raceCourse.startRace();
        raceCourse.viewRaceResult();

        //then
        assertThat(cars.get(0).distance()).isEqualTo(3);
    }

    private List<Car> getCars() {
        IntPredicate canMovePredicate = randomNumber -> true;
        return List.of(new Car(canMovePredicate), new Car(canMovePredicate), new Car(canMovePredicate));
    }
}