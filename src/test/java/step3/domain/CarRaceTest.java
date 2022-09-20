package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarRaceTest {

    NumberGenerator advanced = () -> 4;
    NumberGenerator notAdvanced = () -> 3;


    @Test
    @DisplayName("생성 테스트")
    void ctorTest() {
        //given
        List<Car> carList = List.of(
                new Car(0),
                new Car(0),
                new Car(0)
        );

        //then
        assertDoesNotThrow(() -> new CarRace(carList, NumberGenerator.RandomNumberGenerator(10)));
    }

    @Test
    @DisplayName("size체크 테스트")
    void getSizeTest() {
        //given
        List<Car> list = List.of(new Car(0));

        //when
        CarRace carRace = new CarRace(list, NumberGenerator.RandomNumberGenerator(10));

        //then
        assertThat(carRace.size()).isEqualTo(1);

    }

    @Test
    @DisplayName("자동차 추가 테스트")
    void addCarTest() {
        //given
        List<Car> list = List.of(new Car(0));
        CarRace carRace = new CarRace(list, NumberGenerator.RandomNumberGenerator(10));

        //when
        carRace.addCar(new Car(0));

        //then
        assertThat(carRace.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 전진 테스트")
    void advanceCarTest() {
        //given
        List<Car> list = List.of(new Car(0));
        CarRace carRace = new CarRace(list, advanced);

        //when
        carRace.move();

        //then
        carRace.cars().get(0).state();

    }


}
