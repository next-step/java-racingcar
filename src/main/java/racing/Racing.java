package racing;

public class Racing {
    public int car_count;
    public int try_count;

    public static Racing start() {
        InputView inputView = InputView.create();
        return new Racing(inputView.car_count,inputView.try_count);
    }

    public Racing(int inputCarCount, int inputTryCount) {
        if(isNegative(inputCarCount,inputTryCount)){
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        this.car_count = inputCarCount;
        this.try_count = inputTryCount;
    }

    private boolean isNegative(int inputCarCount, int inputTryCount) {
        return inputCarCount < 0 || inputTryCount < 0;
    }


}
