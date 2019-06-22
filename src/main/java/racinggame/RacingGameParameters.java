package racinggame;

public class RacingGameParameters {
    private final int gameRound;
    private final int carQuantity;
    private final CarNames carNames;
    private final MoveDecider moveDecider;

    public RacingGameParameters(int gameRound, String carNameString, MoveDecider moveDecider) {
        carNames = new CarNames(carNameString);
        int carQuantity = carNames.getCarNameList().size();
        this.gameRound = gameRound;
        this.carQuantity = carQuantity;
        this.moveDecider = moveDecider;
    }

    public MoveDecider getMoveDecider() {
        return moveDecider;
    }

    public int getCarQuantity() {
        return carQuantity;
    }

    public int getGameRound() {
        return gameRound;
    }

    public CarNames getCarNames() {
        return carNames;
    }
}

