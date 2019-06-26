package step4;

import org.apache.commons.lang3.ObjectUtils;

public class ValidationCheck {

    void checkInputPlayerName(String playerNames) {
        if (ObjectUtils.equals(null, playerNames)) {
            throw new IllegalArgumentException("경주에 출전하는 사람이 없습니다(NULL). 재입력해주세요.");
        }
        if (playerNames.isEmpty()) {
            throw new IllegalArgumentException("경주에 출전하는 사람이 없습니다(Empty). 재입력해주세요.");
        }
    }

    void checkInputSplitName(String[] eachName) {
        if (eachName.length == 0) {
            throw new IllegalArgumentException("경주에 출전하는 사람이 없습니다(NULL). 구분자(,)를 이용하여 입력해주세요.");
        }
        if (ObjectUtils.equals(null, eachName)) {
            throw new IllegalArgumentException("경주에 출전하는 사람이 없습니다(NULL). 구분자(,)를 이용하여 입력해주세요.");
        }
    }

    void checkInputTryCount(int tryCount) {
        if (ObjectUtils.equals(null, tryCount)) {
            throw new IllegalArgumentException("경주 시행 횟수는 적어도 1회 이상이어야 합니다(NULL). 재입력해주세요.");
        }
        if (tryCount == 0) {
            throw new IllegalArgumentException("경주 시행 횟수는 적어도 1회 이상이어야 합니다. 재입력해주세요.");
        }
    }

    void checkCarNumber(int carNumber, int carPositionSize) {
        if (carNumber != carPositionSize) {
            throw new IllegalArgumentException("입력한 값과 출전하는 차량의 수가 일치하지 않습니다.");
        }
    }

    void checkRandomValue(int randomNum) {
        if (randomNum > 9 || randomNum < 0) {
            throw new IllegalArgumentException("주어진 랜덤 값의 범위에 해당하지 않습니다.(랜덤값: 0~9)");
        }
    }

    void checkGo(int randomNum) {
        if (randomNum < 4) {
            throw new IllegalArgumentException("전진 할 수 없는 랜덤 값 입니다.");
        }
    }
}
