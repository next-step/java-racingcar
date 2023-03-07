package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import RacingCar.RacingCar;
import RacingCar.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class RacingTest {
    RacingCar racing;

    @BeforeEach
    void setUp() {
        this.racing = new RacingCar();
    }

    @ParameterizedTest
    @ValueSource(strings = {"","cyan.jade"})
    @DisplayName("이름 체크")
    void validatename(String name){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Car.validatename(name));
    }

    @Test
    @DisplayName("게임 출력 테스트")
    void printrace(){
        RacingCar.printrace("A",1);
        RacingCar.printrace("B",5);
    }

    @Test
    @DisplayName("게임 실행 테스트")
    void rungame(){

        List<Car> carlist = new ArrayList<>();
        carlist.add(new Car("cyan"));
        carlist.add(new Car("vince"));
        carlist.add(new Car("lucas"));

        RacingCar.rungame(carlist,4);

    }

    @Test
    @DisplayName("제일 멀리 간 이동거리 구하기")
    void getmaxmove(){

        List<Car> carlist = new ArrayList<>();
        carlist.add(new Car("cyan", 30));
        carlist.add(new Car("vince", 100));
        carlist.add(new Car("lucas", 20));

        System.out.println("maxmove: "+RacingCar.getmaxmove(carlist));
    }

    @Test
    @DisplayName("우승자 구하기")
    void getwinner(){

        List<Car> carlist = new ArrayList<>();
        carlist.add(new Car("cyan", 150));
        carlist.add(new Car("vince", 150));
        carlist.add(new Car("lucas", 20));

        RacingCar.getwinner(carlist);
    }

}
