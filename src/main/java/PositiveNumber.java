public class PositiveNumber {
    private final int positiveNumber;

    private PositiveNumber(int positiveNumber) {
        this.positiveNumber = positiveNumber;
    }
    public static PositiveNumber create(int positiveNumber) {
        if (positiveNumber < 0) {
            throw new RuntimeException();
        }
        return new PositiveNumber(positiveNumber);
    }

    public static PositiveNumber createFromString(String positiveNumberByString) {
        int positiveNumber = Integer.parseInt(positiveNumberByString);
        if (positiveNumber < 0) {
            throw new RuntimeException();
        }
        return new PositiveNumber(positiveNumber);
    }

    public int getFilteredNumber(){
        return this.positiveNumber;
    }

    public int sum(PositiveNumber positiveNumber) {
        return positiveNumber.sum(this);
    }
}
