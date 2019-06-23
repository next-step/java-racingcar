package racinggame;

public class RacingGameParameters {
    private final int gameRound;
    private final int carQuantity;
    private final CarNames carNames;
    private final MoveDecider moveDecider;

    public RacingGameParameters(int gameRound, String carNameString, MoveDecider moveDecider) {
        carNames = new CarNames(carNameString);
        int carQuantity = carNames.getCarNameList().size();
        /*
        RacingGameParameters 에서는 GameRound 생성을 하지 않기 떄문에 오류가 나지 않습니다.
        Production 코드에서는 RacingGame 을 생성하면서 오류가 납니다.
        이 부분에 인자 검사를 하는건 뭔가 테스트코드만을 위해서 넣는 느낌이 들어서 일부러 넣지 않았습니다.
        어떻게 하는게 좋은 방법일까요?
         */
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

