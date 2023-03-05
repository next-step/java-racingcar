package study;

import static org.assertj.core.api.Assertions.assertThat;

import RacingCar.RacingCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import RacingCar.Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RacingTest {
    RacingCar racing;

    @BeforeEach //함수 실행전 무조건 실행된다.
    void setUp() {
        this.racing = new RacingCar();

    }

    @Test
    @DisplayName("결과 확인테스트")
    void print(){
        RacingCar.print("진양철",4);
    }

    @Test
    @DisplayName("run game")
    void rungame(){

        List<Car> carlist = new ArrayList<>();
        carlist.add(new Car("cyan", 0));
        carlist.add(new Car("vincent", 0));
        carlist.add(new Car("lucas", 0));
        carlist.add(new Car("kai", 0));
        carlist.add(new Car("ace", 0));

        RacingCar.rungame(carlist,4);
    }

}
