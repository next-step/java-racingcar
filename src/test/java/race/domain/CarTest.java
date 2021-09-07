package race.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.domain.Car;
import race.strategy.RandomNumCondition;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;
    private RandomNumCondition randomNumCondition;

    @BeforeEach
    void setUp() {
        randomNumCondition = new RandomNumCondition();
        car = new Car();
    }

    @Test
    @DisplayName("Car_정적팩토리_메서드_생성_테스트")
    void Car_정적팩토리_메서드_생성_테스트() {
        //when
        Car carResult = Car.createCar("test1", new ArrayList<Boolean>());
        //then
        assertThat(carResult.getName()).isEqualTo("test1");
    }


    @Test
    @DisplayName("setDistance 테스트")
    void addDistanceTest() {
        //given
        car.addDistance(() -> true);
        //then
        assertThat(car.getWinOrLoseLog().get(0)).isTrue();
    }
}