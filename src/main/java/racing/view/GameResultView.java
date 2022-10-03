package racing.view;

import racing.domain.Car;
import racing.domain.Game;
import racing.domain.GameResult;
import racing.domain.Round;

import java.util.List;
import java.util.stream.IntStream;

public class GameResultView {
    private final static String COLON = ":";
    private final static String WHEEL_MARK = "-";
    private final static String GAME_RESULT = "게임 결과";
    private final static int FIRST_CAR = 0;

    public void result(Game game) {
        System.out.println(GAME_RESULT);
        GameResult gameResult = game.getGameResult();
        resultPerRound(gameResult.getGameRoundList());
        gameWinner(gameResult.gameWinner());
    }

    private void resultPerRound(List<Round> roundList) {
        for (Round round : roundList) {
            forwardCountOfCarPerRound(round.getForwardCountOfCars(), round.getCars());
        }
    }

    private void gameWinner(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
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