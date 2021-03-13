package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.StringValidator;

import static org.assertj.core.api.Assertions.*;

public class CarRaceTest {

    private Car goSuccessTestCar;
    private Car goFailTestCar;
    @BeforeEach
    void setUp(){
        goSuccessTestCar = new Car("rcCa");
        goFailTestCar = new Car("rcCar");
    }
    @Test
    @DisplayName("전진 테스트 - 전진 성공하는 경우")
    void 전진테스트(){
        MoveStrategy moveStrategy = new CarMoveByNameLengthStrategy();
        goSuccessTestCar.move(moveStrategy);
        assertThat(goSuccessTestCar.getPosition()).isEqualTo(2);
    }
    @Test
    @DisplayName("전진 테스트 - 전진 실패하는 경우")
    void 전진조건테스트(){
        MoveStrategy moveStrategy = new CarMoveByNameLengthStrategy();
        goFailTestCar.move(moveStrategy);
        assertThat(goFailTestCar.getPosition()).isEqualTo(1);
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
    @DisplayName("자동차 경주게임 우승자 알려주는 기능 테스트")
    void 자동차_경주_우승자(){
        String carNames = "rc11,rc2,rc33";
        Cars cars = new Cars(carNames);
        MoveStrategy moveStrategy = new CarMoveByNameLengthStrategy();
        cars.move(moveStrategy);
        assertThat(cars.getWinners().
                stream().
                map(car -> car.getCarName())
                ).containsOnly("rc11","rc33");
    }

}
