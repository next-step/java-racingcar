public class CountTry {
    private int countTry;

    public CountTry(int input) {
        if (input < 1) {
            throw new RuntimeException("시도 횟수는 0이상이어야 합니다.")
        }
    }

}
