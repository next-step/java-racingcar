package racingcar;

public enum DataKey {
    CARNUMBER("carNumber"),
    TRYNUMBER("tryNumber");

    private String keyName;

    DataKey(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyName() {
        return keyName;
    }
}
