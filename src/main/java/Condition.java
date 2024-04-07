public class Condition {
    private final int standard = 3;

    private int generateRandom() {
        int randomNum = (int) (Math.random() * 9);
        return randomNum;
    }

    public boolean checkCondition() {
        if (generateRandom() > standard) {
            return true;
        }
        return false;
    }
}
