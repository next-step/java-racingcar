package repository;

import domain.Car;
import org.junit.jupiter.api.DisplayName;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

    private String carsName;

    @BeforeEach
    void setUp() {
        carsName = "AAA,BBB,CCC";
    }

    @Test
    @DisplayName("자동차가 comma 기준으로 Car 객체에 잘 담긴다")
    void splitCarsName() {
        //given, when : 생성자에서 splitCarsName 을 바로 호출
        Cars cars = new Cars(carsName);

        //then
        Assertions.assertThat(cars.getCars().size()).isEqualTo(3);
        Assertions.assertThat(cars.getCars().get(0).getName()).isEqualTo("AAA");
    }

}