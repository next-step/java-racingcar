package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.service.GameService;
import step3.service.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGameTest {
    MoveStrategy moveStrategy = new MoveStrategy();


    @Test
    @DisplayName("전체 자동차를 움직이는 테스트")
    void moveCar() {
        // given
        Car testCar = new Car();
        Boolean isMove = true;
        Integer expectLocation = 2;

        // when
        testCar.moveCar(isMove);

        // then
        assertThat(testCar.getCurrentLocation()).isEqualTo(expectLocation);
    }

    @Test
    @DisplayName("난수 발생 테스트")
    void generateRandomNumber() {
        //given
        final Integer rowNum = 0;
        final Integer highNum = 9;

        //when
        Integer result = moveStrategy.generateRandomNumber();

        //then
        assertThat(result).isGreaterThanOrEqualTo(rowNum);
        assertThat(result).isLessThanOrEqualTo(highNum);
    }

    @Test
    @DisplayName("랜덤 난수를 입력했을 때 움직일지 안움직일지 정하는 메소드 테스트")
    void isMove() {
        //given
        final Integer moveNum = 5;
        final Integer nonMoveNum = 1;

        //when
        Boolean moveResult = moveStrategy.getIsMove(moveNum);
        Boolean nonMoveResult = moveStrategy.getIsMove(nonMoveNum);

        //then
        assertThat(moveResult).isTrue();
        assertThat(nonMoveResult).isFalse();
    }

    @Test
    @DisplayName("게임을 한단계 시도했을 때 나올 수 있는 결과에 대한 테스트")
    void runStep() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        final Integer rowNum = 1;
        final Integer highNum = 2;

        //when
        GameService.runStep(cars);

        //then
        for (Car resultCar : cars) {
            assertThat(resultCar.getCurrentLocation()).isLessThanOrEqualTo(highNum);
            assertThat(resultCar.getCurrentLocation()).isGreaterThanOrEqualTo(rowNum);
        }
    }

    @Test
    @DisplayName("게임을 n단계 시도했을 때 나올 수 있는 결과에 대한 테스트")
    void runManyStep() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        final Integer notMove = 0;
        final Integer Move = 1;
        final Integer startLocation = 1;
        final Integer step = 5;
        Integer finalRowNum = startLocation + (notMove * step);
        Integer finalHighNum = startLocation + (Move * step);

        //when
        GameService.runStep(cars);

        //then
        for (Car resultCar : cars) {
            assertThat(resultCar.getCurrentLocation()).isLessThanOrEqualTo(finalHighNum);
            assertThat(resultCar.getCurrentLocation()).isGreaterThanOrEqualTo(finalRowNum);
        }
    }


    //given
    //when
    //then

}
