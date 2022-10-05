package racing_car_with_winner.view;

import racing_car_with_winner.model.car.CarName;
import racing_car_with_winner.model.car.MoveResult;

public class GameDashBoard {
    private static final String format = "%s : %s";
    private final UserOutputInterface userOutputInterface;

    public GameDashBoard(UserOutputInterface userOutputInterface) {
        this.userOutputInterface = userOutputInterface;
    }

    public void show(CarName carName, MoveResult moveResult) {
        userOutputInterface.show(String.format(format, carName.getValue(), moveResult.getMoveCount()));
    }
}
