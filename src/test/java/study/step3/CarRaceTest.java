package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.step2.StringValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class CarRaceTest {

    private Car car;
    @BeforeEach
    void setUp(){
        car = new Car("rccar",new RandomMoveStrategy());
    }
    @ParameterizedTest
    @CsvSource(value = {"4","5"})
    @DisplayName("전진 테스트 - 전진 성공하는 경우, 랜덤값이 4,5라고 가정")
    void 전진테스트(int randomValue){
        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
    }
    @ParameterizedTest
    @CsvSource(value = {"0","1"})
    @DisplayName("전진 테스트 - 전진 실패하는 경우")
    void 전진조건테스트(int randomValue){
        car.move(randomValue >= NumberChecker.CONDITION_OF_START);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이름을 ,로 구분하는 테스트")
    void 자동차이름_구분(){
        String carNames = "pobi,crong,honux";
        String[] result = carNames.split(StringValidator.CAR_NAME_SPLIT_DELIMITER);
        assertThat(result).hasSize(3).contains("pobi","crong","honux");
    }

    @Test
    @DisplayName("자동차 이름 길이 체크 테스트")
    void 자동차이름_길이체크(){
        String carName = "honux23";
        assertThat(carName.length() > StringValidator.CAR_NAME_LENGTH_LIMIT).isTrue();
    }

    @Test
    @DisplayName("자동차 경주게임 우승 알려주는 기능 테스트")
    void 자동차_경주_우승자(){
        List<Car> carList = new ArrayList<>();

        Car car1 = new Car("rc1",new RandomMoveStrategy());
        Car car2 = new Car("rc2",new RandomMoveStrategy());
        Car car3 = new Car("rc3",new RandomMoveStrategy());
        for(int i=0;i<5;i++){
            car1.move(true);
            car3.move(true);
        }
        for(int i=0;i<3;i++){
            car2.move(true);
        }
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        Cars cars = new Cars(carList);
        assertThat(cars.getWinners()).containsOnly(car1,car3);
    }

}
