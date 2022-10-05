package racing_car_with_winner.view;

import java.util.List;
import java.util.stream.Collectors;

import racing_car_with_winner.model.car.Car;
import racing_car_with_winner.model.car.CarName;
import racing_car_with_winner.model.car.MoveResult;

public class GameDashBoard {
    private static final String SHOW_MOVE_RESULT_TEMPLATE = "%s : %s";
    private static final String SHOW_WINNER_TEMPLATE = "%s가 최종 우승했습니다.";
    private static final String MOVE = "-";
    private final UserOutputInterface userOutputInterface;

    public GameDashBoard(UserOutputInterface userOutputInterface) {
        this.userOutputInterface = userOutputInterface;
    }

    public void showMoveResult(CarName carName, MoveResult moveResult) {
        userOutputInterface.show(String.format(SHOW_MOVE_RESULT_TEMPLATE, carName.getValue(), convertMoveResultToView(moveResult.getMoveCount())));
    }

    private String convertMoveResultToView(int count) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            stringBuilder.append(MOVE);
        }

        return stringBuilder.toString();
    }

    public void showWinner(List<Car> winners) {
        userOutputInterface.show(String.format(SHOW_WINNER_TEMPLATE, getWinnerCarName(winners)));
    }

    private String getWinnerCarName(List<Car> winners) {
        return winners.stream()
                      .map(Car::getCarName)
                      .map(CarName::getValue)
                      .collect(Collectors.joining(","));
    }
}
