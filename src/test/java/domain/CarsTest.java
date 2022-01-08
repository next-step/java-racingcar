package domain;

import org.junit.jupiter.api.DisplayName;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        Assertions.assertThat(cars.getCars())
                .extracting("name")
                .contains("AAA", "BBB", "CCC");
    }

    @Test
    @DisplayName("가장 멀리 간 거리를 제대로 찾을 수 있는지 test")
    void findMaxDistance() {
        //given
        Cars cars = new Cars(carsName);

        //when
        cars.getCars().get(0).move(() -> true);
        cars.getCars().get(0).move(() -> true);

        //then
        Assertions.assertThat(cars.findMaxDistance()).isEqualTo(2);
    }

    @Test
    @DisplayName("한 명의 우승자를 제대로 반환하는지 test")
    void findWinner() {
        //given
        Cars cars = new Cars(carsName);

        //when
        cars.getCars().get(0).move(() -> true);
        cars.getCars().get(0).move(() -> true);
        int maxDistance = cars.findMaxDistance();

        //then
        Assertions.assertThat(cars.findMaxDistanceCar(maxDistance).size())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("여러 명의 우승자를 제대로 반환하는지 test")
    void findWinners() {
        //given
        Cars cars = new Cars(carsName);

        //when
        cars.getCars().get(0).move(() -> true);
        cars.getCars().get(0).move(() -> true);
        cars.getCars().get(1).move(() -> true);
        cars.getCars().get(2).move(() -> true);
        cars.getCars().get(2).move(() -> true);
        int maxDistance = cars.findMaxDistance();

        //then
        Assertions.assertThat(cars.findMaxDistanceCar(maxDistance))
                .contains("AAA", "CCC");
        Assertions.assertThat(cars.findMaxDistanceCar(maxDistance).size())
                .isEqualTo(2);
    }

}