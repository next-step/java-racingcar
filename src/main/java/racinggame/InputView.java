package racinggame;

import java.util.ArrayList;

/**
 * 1. 입력값이 정수 인지 체크
 * 1. 입력값1 크기의 List 생성
 * 1. List의 크기가 1 이상인지 체크
 * 1. 1에서 생성한 List에 랜덤 숫자 insert
 */
public class InputView {
    private ArrayList<Integer> cars;

    protected InputView(String carSize) {
        validateInteger(carSize);
    }

    private void validateInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 입력 되었습니다.");
        }
    }


}
