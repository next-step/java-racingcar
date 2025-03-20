package step3.view.output;

import step3.game.domain.car.Car;
import step3.game.domain.car.Players;

public class ConsoleOutputView implements OutputView {

    public static final String WINNER_DELIMITER = ", ";
    public static final String CAR_MOVE_SYMBOL = "-";

    @Override
    public void result() {
        System.out.println("실행 결과");
    }

    @Override
    public String carDistance(Integer distance) {
        return CAR_MOVE_SYMBOL.repeat(distance);
    }

    @Override
    public void endOfThisTurn(Players players) {
        for (Car car : players.getCars()) {
            System.out.printf("%s : %s%n", car.name.getCarName(), carDistance(car.getDistance()));
        }
        System.out.println();
    }

    @Override
    public void finalResult(Players players) {
        System.out.println(String.join(WINNER_DELIMITER, players.finalResult()) + "가 최종 우승했습니다.");
    }
}
