package step3.racinggame.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import step3.racinggame.view.GamePad;
import step3.racinggame.view.ScoreBoard;

public class RacingGame {

    private final GasStation gasStation;

    public RacingGame() {
        this.gasStation = new GasStation();
    }

    // 현재 구현한 '게임'에서 단위테스트는 어떻게?
    // 단위테스트를 위해 private 메소드 일부를 public 으로 바꾼 기분...

    // 게임을 실행하는 부분
    public void play() {
        // 차량 수를 입력받아 경기할 차량을 준비한다.
        GamePad.printNumOfCarInputMsg();
        List<Car> cars = readyToRace(GamePad.insertData());

        // 경기 수를 입력 받아 경기를 진행한다.
        GamePad.printNumOfGameInputMsg();
        List<List<Integer>> scoreBoard = playGame(GamePad.insertData(), cars);

        // 경기 결과를 출력한다.
        ScoreBoard.printScoreBoard(scoreBoard);
    }


    public List<Car> readyToRace(int numOfCar) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numOfCar; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    public List<List<Integer>> playGame(int numOfGame, List<Car> cars) {
        List<List<Integer>> scoreBoard = new ArrayList<>();

        for (int i = 0; i < numOfGame; i++) {
            scoreBoard.add(playRace(cars));
        }

        return scoreBoard;
    }

    private List<Integer> playRace(List<Car> cars) {
        return cars.stream()
                .map(car -> {
                    car.move(gasStation.sellFuel());
                    return car.whereAmI();
                })
                .collect(Collectors.toUnmodifiableList());
    }

}
