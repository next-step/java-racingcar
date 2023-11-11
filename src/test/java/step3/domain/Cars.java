package step3.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import step3.domain.CarName;
import step3.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    public void moveCarStatusTest() {
        Cars cars = new Cars(CarName.splitCarNames("abc,def,hig,lmn"), 0);
        assertThat(cars.getCars()).hasSize(4);
        assertThat(cars.getCars().get(0).name()).isEqualTo("abc");
        assertThat(cars.getCars().get(1).name()).isEqualTo("def");
        assertThat(cars.getCars().get(2).name()).isEqualTo("hig");
        assertThat(cars.getCars().get(3).name()).isEqualTo("lmn");

        Assertions.assertAll(
                () -> assertThat(cars.getCars()).hasSize(4),
                () -> assertThat(cars.getCars().get(0).name()).isEqualTo("abc"),
                () -> assertThat(cars.getCars().get(1).name()).isEqualTo("def"),
                () -> assertThat(cars.getCars().get(2).name()).isEqualTo("hig"),
                () -> assertThat(cars.getCars().get(3).name()).isEqualTo("lmn"),
                () -> assertThat(cars.getCars().get(0).position()).isEqualTo(0),
                () -> assertThat(cars.getCars().get(1).position()).isEqualTo(0),
                () -> assertThat(cars.getCars().get(2).position()).isEqualTo(0),
                () -> assertThat(cars.getCars().get(3).position()).isEqualTo(0));
    }

}