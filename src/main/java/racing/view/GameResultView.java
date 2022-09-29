package racing.view;

import racing.domain.Car;
import racing.domain.Game;
import racing.domain.GameRound;

import java.util.List;
import java.util.stream.IntStream;

public class GameResult {
    private final static String COLON = ":";
    private final static String WHEEL_MARK = "-";
    private final static String GAME_RESULT = "게임 결과";
    private final static int FIRST_CAR = 0;

    public void result(Game game) {
        racing.domain.GameResult gameResult = game.getGameResult();
        resultPerRound(gameResult.getGameRoundList());
        gameResult.gameWinner();
    }

    private void resultPerRound(List<GameRound> roundList) {
        System.out.println(GAME_RESULT);
        roundList.stream()
                .forEach(round -> {
                    forwardCountOfCarPerRound(round.getForwardCountOfCars(), round.getCars());
                });
    }

    private void forwardCountOfCarPerRound(List<Integer> forwardCountOfCars, List<Car> cars) {
        IntStream.range(FIRST_CAR, cars.size()).forEach(carNumber -> {
            System.out.println(parsePositionOfCar(cars.get(carNumber).getCarName(), forwardCountOfCars.get(carNumber)));
        });
        System.out.println();
    }

    private String parsePositionOfCar(String carName, int forwardCount) {
        return carName + COLON + WHEEL_MARK.repeat(forwardCount);
    }
}