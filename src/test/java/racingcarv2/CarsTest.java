package racingcarv2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.service.GameService;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp(){
        cars = new Cars("pobi,crong,honux");
    }

    @DisplayName("n대의 자동차 생성자 테스트")
    @Test
    void cars_unit_test(){
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    /**
     * 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
     */
    @DisplayName("자동차 경주 우승자 확인 테스트")
    @Test
    void is_winner_test(){
        Cars testCars = new Cars();

        Car pobi = new Car("pobi",3);
        Car crong = new Car("crong",2);
        Car honux = new Car("honux",1);
        testCars.add(pobi);
        testCars.add(crong);
        testCars.add(honux);

        assertThat(testCars.isWinners()).contains(new Car("pobi",3));
    }
}