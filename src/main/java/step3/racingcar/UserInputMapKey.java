package step3.racingcar;

public enum UserInputMapKey {
    CAR_COUNTS("carCounts"),
    GAME_TRY_COUNTS("gameTryCounts");

    private final String key;

    private UserInputMapKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
