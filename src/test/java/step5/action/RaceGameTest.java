package step5.action;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.action.Race;
import step5.domain.Car;
import step5.domain.Cars;
import step5.domain.strategy.ArrangeStrategy;
import step5.domain.strategy.MoveStrategy;
import step5.domain.strategy.WinnerStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaceGameTest {
    // 레이싱 시작.
    @DisplayName("레이스 객체 생성")
    @Test
    void createRaceGate(){
        RaceGame game = RaceGame.of(Cars.from(new String[]{
                "a","b","c"
        }));
        assertThat(getCarNameList(game.getCars().showCarList())).contains("a","b","c");
    }

    @DisplayName("Cars 객체의 move 실행 (moveStrategy 주입하기)")
    @Test
    void moveCarsTest(){
        List<Car> carList = new ArrayList<>();
        carList.add(Car.of("car1",10));
        carList.add(Car.of("car2",5));
        carList.add(Car.of("car3",6));
        RaceGame game = RaceGame.of(Cars.from(carList));

        MoveStrategy strategy = new MoveStrategy() {
            @Override
            public boolean isMove(int randomNumber) {
                int boundary = 5;
                return randomNumber > boundary;
            }

            @Override
            public List<Car> move(List<Car> carList) {
                for(Car car: carList){
                    car.move(isMove(6));
                }
                return carList;
            }
        };
        game.move(strategy);
        List<Car> list = game.getCars().showCarList();
        assertThat(getCarPositionList(list)).containsExactly(11,6,7);
    }

    @DisplayName("우승자 가져오기")
    @Test
    void getWinner(){
        List<Car> carList = new ArrayList<>();
        carList.add(Car.of("car1",10));
        carList.add(Car.of("car2",5));
        carList.add(Car.of("car3",6));
        RaceGame game = RaceGame.of(Cars.from(carList));

        ArrangeStrategy arrangeStrategy = new ArrangeStrategy() {
            @Override
            public List<Car> arrangeCarList(List<Car> carList) {
                return carList;
            }
        };

        WinnerStrategy winnerStrategy = new WinnerStrategy() {
            @Override
            public List<Car> getWinner(List<Car> carList) {
                return null;
            }
        };

        List<Integer> positions = getCarPositionList(game.getWinner(winnerStrategy,arrangeStrategy));

        assertThat(positions).containsExactly(10);
    }

    List<String> getCarNameList(List<Car> carList){
        return carList.stream().map(Car::getName).collect(Collectors.toList());
    }

    List<Integer> getCarPositionList(List<Car> carList){
        return carList.stream().map(Car::getPosition).collect(Collectors.toList());
    }
}