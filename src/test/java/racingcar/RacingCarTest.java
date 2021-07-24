package racingcar;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static racingcar.utils.StringUtils.inputStrSeperator;

public class RacingCarTest {
    RacingCar racingCar = new RacingCar();

    @Test
    @DisplayName(", 구분자로 문자열 분리")
    void seperatorTest() {
        String inputStr = "pobi,crong,honux";
        String[] names = inputStrSeperator(inputStr);
        Assertions.assertArrayEquals(names, new String[]{"pobi", "crong", "honux"});
    }

    @Test
    @DisplayName("차 생성")
    void createCarTest() {
        String[] carStrArr = Arrays.array("pobi", "crong", "honux");
        Cars cars = new Cars(carStrArr);
        List<Car> carList = cars.getCars();
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car honux = new Car("honux");
        assertThat(carList).contains(pobi, crong, honux);
    }

    @Test
    @DisplayName("차 생성시, 5자 이상일 경우 에러")
    void checkMaximumTest() {
        String inputStr = "aaaaaa";
        assertThatThrownBy(() -> new Car(inputStr))
                .isInstanceOf(RuntimeException.class);

    }

    @Test
    @DisplayName("자동차 전진 또는 멈춤")
    void moveCarTest() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("random값에 의한 전진 테스트")
    void randomTest() {
        Car car = new Car("pobi");
        int randomNumber = 4;
        boolean move = car.isMove(randomNumber);
        int randomNumber1 = 0;
        boolean stop = car.isMove(randomNumber1);

        assertThat(move).isTrue();
        assertThat(stop).isFalse();
    }
//    @Test
//    @DisplayName("우승자 확인")
//    void winnersTest(){
//        Car pobi = new Car("pobi",5);
//        Car crong = new Car("crong",5);
//        Car honux = new Car("honux",2);
//        List<Car> carList = new ArrayList<>();
//        carList.add(pobi);
//        carList.add(crong);
//        carList.add(honux);
//
//        Cars cars = new Cars(carList);
//        List<Car> winners = cars.getWinners();
//        assertThat(winners).contains(pobi,crong);
//    }

//    @Test
//    @DisplayName("게임 테스트")
//    void playTest(){
//        List<Car> winners = racingCar.play("pobi,crong,honux", 5);
//        winners.stream().map(w -> w.getName()).forEach(System.out::println);
//    }
}
