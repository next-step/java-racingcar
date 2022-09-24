package racing.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.generator.DefaultNumberGenerator;
import racing.domain.generator.NumberGenerator;

public class CarRaceTest {

    NumberGenerator advanced = () -> 4;
    NumberGenerator notAdvanced = () -> 3;


    @Test
    @DisplayName("생성 테스트")
    void ctorTest() {
        //given
        List<Car> carList = List.of(
            new Car("1"),
            new Car("2"),
            new Car("3")
        );

        //then
        assertDoesNotThrow(() -> new CarRace(carList, new DefaultNumberGenerator(10)));
    }

    @Test
    @DisplayName("전체 자동차 전진 테스트")
    void advanceCarTest() {
        //given
        String name = "name";
        List<Car> list = new ArrayList<>(List.of(new Car(0, name)));
        CarRace carRace = new CarRace(list, advanced);

        //when
        CarRace movedCarRace = carRace.move();

        //then
        assertThat(movedCarRace).isEqualTo(new CarRace(List.of(new Car(1, name))));
    }

    @Test
    @DisplayName("전체 자동차 전진 실패 테스트")
    void notAdvanceCarTest() {
        //given
        String name = "name";
        List<Car> list = new ArrayList<>(List.of(new Car(0, name)));
        CarRace carRace = new CarRace(list, notAdvanced);

        //when
        CarRace movedCarRace = carRace.move();

        //then
        assertThat(movedCarRace).isEqualTo(carRace);
    }

}
