package step5.exception;

public class OutBoundCarListSizeException extends IllegalArgumentException {

    private final static String OUT_BOUND_CAR_LIST_SIZE_FIRST_WORD= "자동차 갯수 사이즈는 ";
    private final static String OUT_BOUND_CAR_LIST_SIZE_SECOND_WORD= " 개를 미만 입력할 수 없습니다.";

    public OutBoundCarListSizeException(int limitSize) {
        super(OUT_BOUND_CAR_LIST_SIZE_FIRST_WORD  + limitSize + OUT_BOUND_CAR_LIST_SIZE_SECOND_WORD);
    }
}
