package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarGroupTest {

    @Test
    void getNames_자동차그룹의_이름이_같다() {
        CarGroup carGroup = new CarGroup("wu2ee,pobi");
        assertThat(carGroup.getNames()).isEqualTo(List.of("wu2ee", "pobi"));
    }

    @Test
    void moveCarGroupPerTrial_모든_자동차가_움직인다() {
        CarGroup carGroup = new CarGroup("wu2ee,pobi,crong,honux");
        carGroup.moveCarGroupPerTrial(() -> 4);
        assertThat(carGroup).isEqualTo(
                new CarGroup(
                        List.of(
                                new Car(1, "wu2ee"),
                                new Car(1, "pobi"),
                                new Car(1, "crong"),
                                new Car(1, "honux")
                        )
                ));
    }

    @Test
    void moveCarGroupPerTrial_모든_자동차가_움직이지_않는다() {
        CarGroup carGroup = new CarGroup("wu2ee,pobi,crong,honux");
        carGroup.moveCarGroupPerTrial(() -> 3);
        assertThat(carGroup).isEqualTo(
                new CarGroup(
                        List.of(
                                new Car(0, "wu2ee"),
                                new Car(0, "pobi"),
                                new Car(0, "crong"),
                                new Car(0, "honux")
                        )
                ));
    }

    @Test
    void getWinners_우승자가_존재한다() {
        List<Car> cars = List.of(
                new Car(3, "wu2ee"),
                new Car(5, "pobi"),
                new Car(7, "honux"));

        CarGroup carGroup = new CarGroup(cars);
        assertThat(carGroup.getWinners()).isEqualTo(List.of("honux"));
    }

    @Test
    void getWinners_우승자가_여러명_존재한다() {
        List<Car> cars = List.of(
                new Car(3, "wu2ee"),
                new Car(7, "pobi"),
                new Car(7, "honux"));

        CarGroup carGroup = new CarGroup(cars);
        assertThat(carGroup.getWinners()).isEqualTo(List.of("pobi","honux"));
    }
}