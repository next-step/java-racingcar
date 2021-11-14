package carracing;

import java.util.Arrays;
import java.util.List;

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
    private static final String SPLIT_REGEX = ",";
    private static final String CAR_NAME_BLANK = " ";
    private static final String CAR_NAME_EMPTY = "";

    private int carCount = 0;   /* 차량 대수 */
    private int tryCount = 0;   /* 주행 횟수 */

    private int totalDrivingCount = 0;

    private List<String> carList;

    public InputView() {
    }

    public InputView(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    /**
     * 입력값 검증 기능 생성자
     */
    public InputView(String carStringList, String tryCount) {
        splitCars(carStringList);
        try {
            this.tryCount = Integer.parseInt(tryCount);
            this.totalDrivingCount = this.carCount * this.tryCount;
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(ERR_MSG_FORMAT_NUM);
        }
    }

    public void splitCars(String carStringList) {
        carList = Arrays.asList(carStringList.replace(CAR_NAME_BLANK, CAR_NAME_EMPTY).split(SPLIT_REGEX));
        this.carCount = carList.size();
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

    public List<String> getCarList() {
        return carList;
    }
}
