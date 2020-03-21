package racinggame;

import java.util.ArrayList;

/**
 * 1. Car의 List 필드
 * 1. Car의 수 필드
 * 1. 진행할 게임 수 필드
 * 1. NumberVo 이용하여 입력값이 정수 인지 체크
 * 1. NumberVo 이용하여 입력 값이 1 이상인지 체크
 */
public class InputView {
    private int carCount;
    private int gameCount;
    private ArrayList<Integer> cars = new ArrayList<>();

    public InputView(String carCount, String gameCount) {
        validateInputData(carCount, gameCount);
    }

    /**
     * NumberVo 이용하여 입력값이 정수 인지 체크
     * NumberVo 이용하여 입력 값이 1 이상인지 체크
     */
    private void validateInputData(String carCount, String gameCount) {
        this.carCount = NumberVo.validateInteger(carCount);
        this.gameCount = NumberVo.validateInteger(gameCount);
        if (!NumberVo.isGreaterThan1(this.carCount) || !NumberVo.isGreaterThan1(this.gameCount)) {
            throw new IllegalArgumentException("1이상의 값을 입력해야 합니다.");
        }
    }

    public ArrayList<Integer> getCars() {
        return cars;
    }
}
