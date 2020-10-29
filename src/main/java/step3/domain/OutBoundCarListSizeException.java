package step3.domain;

public class OutBoundCarListSizeException extends IllegalArgumentException{

    public OutBoundCarListSizeException() {
        super("자동차 갯수 사이즈를 잘못 입력하셨습니다.");
    }
}
