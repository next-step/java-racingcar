package carracing;

/*
 * InputView
 *
 * Version 1.0.0
 *
 * 2021-11-08
 *
 * author jiseok-choi
 */
public class InputView {

    private static final String ERR_MSG_FORMAT_NUM = "입력값의 숫자 형식을 확인해주세요";

    private int carCount = 0;   /* 차량 대수 */
    private int tryCount = 0;   /* 주행 횟수 */

    private int totalDrivingCount = 0;

    public InputView() {
    }

    public InputView(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    /**
     * 입력값 검증 기능 생성자
     */
    public InputView(String carCount, String tryCount) {
        try {
            this.carCount = Integer.parseInt(carCount);
            this.tryCount = Integer.parseInt(tryCount);
            this.totalDrivingCount = this.carCount * this.tryCount;
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(ERR_MSG_FORMAT_NUM);
        }
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public int getTotalDrivingCount() {
        return totalDrivingCount;
    }
}
