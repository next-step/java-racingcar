package carracing.view;

import java.util.Arrays;
import java.util.List;

/*
 * InputInfo
 *
 * Version 1.0.0
 *
 * 2021-11-08
 *
 * author jiseok-choi
 */
public class InputInfo {

    private static final String ERR_MSG_FORMAT_NUM = "입력값의 숫자 형식을 확인해주세요";
    private static final String SPLIT_REGEX = ",";
    private static final String CAR_NAME_BLANK = " ";
    private static final String CAR_NAME_EMPTY = "";

    private int carCount = 0;   /* 차량 대수 */
    private final int tryCount;   /* 주행 횟수 */

    private List<String> carStringList;

    /**
     * 입력값 검증 기능 생성자
     */
    public InputInfo(String carStringList, String tryCount) {
        splitCars(carStringList);
        try {
            this.tryCount = Integer.parseInt(tryCount);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(ERR_MSG_FORMAT_NUM);
        }
    }

    public void splitCars(String carStringList) {
        String carNameLump = carStringList.replace(CAR_NAME_BLANK, CAR_NAME_EMPTY);
        String[] carNames = carNameLump.split(SPLIT_REGEX);
        this.carStringList = Arrays.asList(carNames);
        this.carCount = this.carStringList.size();
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<String> getCarStringList() {
        return carStringList;
    }
}
