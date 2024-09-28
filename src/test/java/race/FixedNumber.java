package race;

public class FixedNumber implements RandomNumber {

    private int fixNumber;

    public FixedNumber(int fixNumber) {
        this.fixNumber = fixNumber;
    }

    @Override
    public int randomNumber() {
        return fixNumber;
    }
}
