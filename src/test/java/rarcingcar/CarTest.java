package rarcingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Car;

public class CarTest {

    @ParameterizedTest
    @CsvSource({"4,true"})
    public void car_이동_테스트(int num, boolean moved) {
        Car testCar2 = new Car(3);
        assertThat(testCar2.move(num).equals(new Car(4))).isEqualTo(moved);
    }

    @ParameterizedTest
    @CsvSource({"3,false"})
    public void car_정지_테스트(int num, boolean moved) {
        Car testCar = new Car();
        assertThat(testCar.move(num).equals(new Car(1))).isEqualTo(moved);
    }

    @ParameterizedTest
    @CsvSource({"3,---", "4,----", "-1,''"})
    public void toStringTest(int pos, String posToString) {
        assertThat(new Car(pos).toString()).isEqualTo(posToString);
    }

    @Test
    public void car_생성_테스트() {
        assertThat(new Car("pobi").getName()).isEqualTo("pobi");
    }

    @Test
    public void car_생성_실패_테스트() {
        assertThatThrownBy(() -> new Car("pobibi")).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void car_리스트_생성_테스트() {
        assertAll(
            () -> assertThat(Car.createCars("pobi,crong,honux").size()).isEqualTo(3),
            () -> assertThat(Car.createCars("pobi,crong,honux")).contains(new Car("pobi"), new Car("crong"), new Car("honux"))
        );
    }

}
