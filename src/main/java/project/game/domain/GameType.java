package project.game.domain;

public enum GameType {
    RANDOM(new RandomlyMoveRule(new RealRandomNumberProvider(10)));

    private MoveRule mMoveRule;

    GameType(MoveRule moveRule) {
        mMoveRule = moveRule;
    }

    public MoveRule getMoveRule() {
        return mMoveRule;
    }
}
