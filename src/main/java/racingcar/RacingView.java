package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingView {
    public RacingGame game;

    public RacingView(RacingGame game) {
        this.game = game;
    }

    public void printResultMsg() {
        System.out.println(RacingViewConst.EXECUTION_RESULT_MSG);
    }

    // NOTE: Car 보다 작은 단위로 convert 하지 않도록 한다.
    protected String convertCar(Car car) {
        int position = car.getPosition();
        String name = car.getName();
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(RacingViewConst.SEPARATOR);
        for (int j = 0; j < position; j++) {
            sb.append(RacingViewConst.PLAYER_TOKEN);
        }
        return sb.toString();
    }

    public void print() {
        this.game.printCars(car -> {
            String convertedCar = this.convertCar(car);
            System.out.println(convertedCar);
        });
        System.out.println();
    }

    protected String convertWinnerList(List<Car> winnerList) {
        List<String> winners = winnerList
                .stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
        return String.join(RacingViewConst.WINNER_DELIMITER, winners) + RacingViewConst.WINNER_MSG;
    }

    public void printWinners() {
        List<Car> winnerList = this.game.getWinners();
        String winnerStr = this.convertWinnerList(winnerList);
        System.out.println(winnerStr);
    }
}
