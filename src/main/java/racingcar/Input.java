package racingcar;

import java.util.List;

/**
 * 사용자로부터 입력값을 받기 위한 처리를 수행한다.
 * 자동차 이름과 이동할 횟수를 입력 받는다.
 */
public interface Input {
    List<String> getCarNames();

    int getTryCount();
}
