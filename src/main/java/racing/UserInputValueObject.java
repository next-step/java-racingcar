package racing;

public class UserInputValueObject {
    private String inputCarCount;
    private String inputTime;

    UserInputValueObject(final String inputCarCount, final String inputTime) {
        this.inputCarCount = inputCarCount;
        this.inputTime = inputTime;
    }

    public String getInputCarCount() {
        return this.inputCarCount;
    }

    public String getInputCarTime() {
        return this.inputTime;
    }

}
