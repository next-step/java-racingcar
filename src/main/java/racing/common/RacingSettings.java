package racing.common;

public enum RacingSettings {
    MAX_CAR_COUNT(10),
    MAX_TIME(50),
    MIN_CAR_COUNT(1),
    MIN_TIME(1),
    MAX_RANDOM_MOVABLE_NUMBER(9),
    MIN_RANDOM_MOVABLE_NUMBER(0),
    MIN_MOVABLE_NUMBER(4);
    private int value;
    
    RacingSettings(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
