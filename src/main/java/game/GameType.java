package game;

public enum GameType {
    RANDOM(new RandomlyMoveRule(new RandomNumberProviderImpl(10)));

    private MoveRule mMoveRule;

    GameType(MoveRule moveRule) {
        mMoveRule = moveRule;
    }

    public MoveRule getMoveRule() {
        return mMoveRule;
    }
}
