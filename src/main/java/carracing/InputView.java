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

    private int carCount = 0;
    private int tryCount = 0;

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void valid(String carCount, String tryCount) {
        try {
            this.carCount = Integer.parseInt(carCount);
            this.tryCount = Integer.parseInt(tryCount);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(ERR_MSG_FORMAT_NUM);
        }
    }

}
