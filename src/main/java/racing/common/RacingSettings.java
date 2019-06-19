package racing.common;

public enum RacingSettings {
    MOVING_START_COUNT(0),
    CAR_NAME_SEPARATOR(",");

    private int value;
    private String str;
    
    RacingSettings(int value) {
        this.value = value;
    }
    
    RacingSettings(String str) {
        this.str = str;
    }
    
    public int getValue() {
        return value;
    }
    
    public String getStr() {
        return str;
    }
}
