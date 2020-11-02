package step4.exception;

public class ValidateLengthOfCarName extends IllegalArgumentException {

    private final static String VALIDATE_LENGTH_OF_CAR_NAME_FIRST_WORD = "자동차 갯수는 " ;
    private final static String VALIDATE_LENGTH_OF_CAR_NAME_SECOND_WORD = " 넘을수 없습니다." ;
    public ValidateLengthOfCarName(int limitCount) {
        super(VALIDATE_LENGTH_OF_CAR_NAME_FIRST_WORD + limitCount + VALIDATE_LENGTH_OF_CAR_NAME_SECOND_WORD);
    }
}
