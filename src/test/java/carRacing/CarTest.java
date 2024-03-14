package carRacing;

import car.Car;
import car.randomNumer.RandomNumber;
import car.randomNumer.impl.RandomNumberByParameter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    RandomNumber randomNumberFixed;
    @BeforeEach
    void 강제로_랜덤값_입력(){
        randomNumberFixed = new RandomNumberByParameter(5);
    }

    @DisplayName("무조건 이동하는 경우")
    @Test
    void 무조건_한번_이동_테스트(){
        Car car = new Car(randomNumberFixed);
        car.move();
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @DisplayName("랜덤 범위를 알아서 세팅하는 경우")
    @Test
    void 한번_이동_테스트(){
        Car car = new Car();
        car.move();
        System.out.println("car.getLocation() = " + car.getLocation());
        assertThat(car.getLocation()).isBetween(0, 1);
    }

}