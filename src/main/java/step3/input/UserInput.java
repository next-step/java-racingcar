package step3.input;

public class UserInput {
    private final int carNumber;
    private final int tryNumber;

    public UserInput(final int carNumber, final int tryNumber) {
        this.carNumber = carNumber;
        this.tryNumber = tryNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getTryNumber() {
        return tryNumber;
    }

    @Override
    public String toString() {
        return "UserInput{" +
                "carNumber=" + carNumber +
                ", tryNumber=" + tryNumber +
                '}';
    }
}
