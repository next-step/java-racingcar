package step3;

public class Racing {
    private final int carNumber;
    private final int tryNumber;
    public static Racing createRacing(int carNumber, int tryNumber) {
        return new Racing(carNumber, tryNumber);
    }

    public Racing(int carNumber, int tryNumber) {
        this.carNumber = carNumber;
        this.tryNumber = tryNumber;
    }


    public int getCarNumberOfParticipants() {
        return this.carNumber;
    }

    public int getTryNumber() {
        return this.tryNumber;
    }
}
