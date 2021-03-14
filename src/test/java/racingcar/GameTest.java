package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.GameService;
import racingcar.service.MoveStrategy;
import racingcar.service.RacingGameService;
import racingcar.service.RandomMoveStrategy;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    MoveStrategy moveStrategy = new RandomMoveStrategy();
    Random random = new Random();
    GameService gameService = new RacingGameService();
    ResultView resultView = new ResultView();


    @Test
    @DisplayName("자동차를 한칸 움직이는 테스트")
    void moveCar() {
        // given
        Car testCar = new Car();
        Boolean isMove = true;
        int expectLocation = 1;

        // when
        testCar.move(isMove);

        // then
        assertThat(testCar.getCurrentLocation()).isEqualTo(expectLocation);
    }

//    @Test
//    @DisplayName("n대의 자동차가 생성되었는지 테스트")
//    void generateCar() {
//        //given
//        List<Car> expectCars = new ArrayList<>();
//        int carNumber = 3;
//        expectCars.add(new Car());
//        expectCars.add(new Car());
//        expectCars.add(new Car());
//
//        //when
//        List<Car> resultCars = gameService.initGame(carNumber);
//
//        //then
//        for (int i = 0; i < carNumber; i++) {
//            assertThat(resultCars.get(i)).isEqualToComparingFieldByField(expectCars.get(i));
//        }
//    }


//    @Test
//    @DisplayName("난수 발생 테스트")
//    void generateRandomNumber() {
//        //given
//        int rowNum = 0;
//        int highNum = 9;
//        List<Integer> results = new ArrayList<>();
//        int testLoopTime = 100;
//        int testLoopStart = 0;
//
//        //when
//        for (int i = testLoopStart; i < testLoopTime; i++) {
//            results.add(moveStrategy.generateRandomNumber());
//        }
//
//        //then
//        for (int result : results) {
//            assertThat(result).isBetween(rowNum, highNum);
//        }
//    }


    //움직일지 안움직일지 테스트..?
//    @Test
//    @DisplayName("랜덤 난수를 입력했을 때 움직일지 안움직일지 정하는 메소드 테스트")
//    void isMove() {
//        //given
//        Integer moveNum = 5;
//        Integer nonMoveNum = 1;
//
//        //when
//        Boolean moveResult = moveStrategy.getIsMove();
//        Boolean nonMoveResult = moveStrategy.getIsMove();
//
//        //then
//        assertThat(moveResult).isTrue();
//        assertThat(nonMoveResult).isFalse();
//    }

//    @Test
//    @DisplayName("현재 위치 표현 테스트")
//    void getLocationView() {
//        //given
//        int expectLocation = 3;
//        Car testCar = new Car(expectLocation);
//        String expectLocationView = "---";
//
//        //when
//        String result = resultView.getLocationView(testCar);
//
//
//        //then
//        assertThat(result).isEqualTo(expectLocationView);
//    }


    @Test
    @DisplayName("게임 진행 테스트")
    void runManyStep() {
        //given
        List<Integer> expectLocation = new ArrayList<>();
        int testCarNum = 5;

        int startLocation = 0;
        int step = 5;

        for (int i = 0; i < testCarNum; i++) {
            expectLocation.add(startLocation + random.nextInt(step + 1));
        }
        int rowNum = startLocation;
        int highNum = startLocation + step;

        while (true) {
            //given
            List<Car> expectCars = new ArrayList<>();
            for (int i = 0; i < testCarNum; i++) {
                expectCars.add(new Car());
            }


            //when
            for (int i = 0; i < step; i++) {
                gameService.runStep();
            }

            //then
            isCorrectLocation(expectCars, testCarNum, rowNum, highNum);
            if (isExpectLocation(expectCars, expectLocation, testCarNum)) {
                break;
            }
        }
    }


    void isCorrectLocation(List<Car> cars, Integer testCarNum, Integer rowNum, Integer highNum) {
        for (int i = 0; i < testCarNum; i++) {
            assertThat(cars.get(i).getCurrentLocation()).isBetween(rowNum, highNum);
        }
    }

    Boolean isExpectLocation(List<Car> cars, List<Integer> expectLocation, Integer testCarNum) {
        for (int i = 0; i < testCarNum; i++) {
            if (cars.get(i).getCurrentLocation() != expectLocation.get(i)) {
                return false;
            }
        }
        return true;
    }


    //given
    //when
    //then

}
