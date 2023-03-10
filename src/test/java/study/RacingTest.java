package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    Car testcar;

    @BeforeEach
    void setUp() {
        this.racing = new RacingCar();
        this.testcar = new Car ("test", 100);
    }

    @ParameterizedTest
    @ValueSource(strings = {"","cyan.jade"})
    @DisplayName("이름 체크")
    void validateName(String name){

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> testcar.validateName(name));
    }

    @Test
    @DisplayName("현재 자동차 위치 구하기")
    void getPosition(){

         assertEquals(100, testcar.getPosition());

    }

    @Test
    @DisplayName("현재 자동차 이름 구하기")
    void getName(){

        assertEquals("test", testcar.getName());

    }

    @Test
    @DisplayName("게임 출력 테스트")
    void printRace(){

        racing.printRace("A",1);
        racing.printRace("B",5);

    }

    @Test
    @DisplayName("게임 실행 테스트")
    void runGame(){

        List<Car> carlist = new ArrayList<>();
        carlist.add(new Car("cyan"));
        carlist.add(new Car("vince"));
        carlist.add(new Car("lucas"));

        racing.startGame(carlist,4);

    }

    @Test
    @DisplayName("제일 멀리 간 이동거리 구하기")
    void getMaxPosition(){

        List<Car> carlist = new ArrayList<>();
        carlist.add(new Car("cyan", 30));
        carlist.add(new Car("vince", 100));
        carlist.add(new Car("lucas", 20));

        assertEquals(100, racing.getMaxPosition(carlist));

    }

    @Test
    @DisplayName("우승자 구하기")
    void getWinner(){

        List<Car> carlist = new ArrayList<>();
        carlist.add(new Car("cyan", 150));
        carlist.add(new Car("vince", 120));
        carlist.add(new Car("lucas", 20));

        assertThat("[cyan]").isEqualTo(racing.getWinner(carlist));
    }

}
