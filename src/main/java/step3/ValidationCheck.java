package step3;

import org.apache.commons.lang3.ObjectUtils;

public class ValidationCheck {

    public void checkInputCarNumber(int carNumber) {
        if (ObjectUtils.equals(null, carNumber)) {
            throw new IllegalArgumentException("경주에 출전하는 차량이 없습니다(NULL). 재입력해주세요.");
        }
        if (carNumber == 0) {
            throw new IllegalArgumentException("경주에 출전하는 차량은 적어도 1대 이상이어야 합니다. 재입력해주세요.");
        }
    }

    public void checkInputTryCount(int tryCount) {
        if (ObjectUtils.equals(null, tryCount)) {
            throw new IllegalArgumentException("경주에 출전하는 차량이 없습니다(NULL). 재입력해주세요.");
        }
        if (tryCount == 0) {
            throw new IllegalArgumentException("경주 시행 횟수는 적어도 1회 이상이어야 합니다. 재입력해주세요.");
        }
    }

    public void checkCarNumber(int carNumber, int[] carPositions) {
        if (carNumber != carPositions.length) {
            throw new IllegalArgumentException("입력한 값과 출전하는 차량의 수가 일치하지 않습니다.");
        }
    }

    public void checkRandomValue(int randomNum) {
        if (randomNum > 9 || randomNum < 0) {
            throw new IllegalArgumentException("주어진 랜덤 값의 범위에 해당하지 않습니다.(랜덤값: 0~9)");
        }
    }

    public void checkGo(int randomNum) {
        if (randomNum < 4) {
            throw new IllegalArgumentException("전진 할 수 없는 랜덤 값 입니다.");
        }
    }
}
