package race.car;

public class ErrorMessage {

    private static String NULL_EXCEPTION = "Null을 입력하였습니다. 숫자를 입력해주세요";
    private static String EMPTY_EXCEPTION = "입력하지 않으셨습니다. 숫자를 입력해주세요";
    private static String NUMBERFORMATEXCEPTION = "문자를 입력하였습니다. 숫자를 입력해주세요";
    private static String ARRAYINDEXOUTOFBOUNDSEXCEPTION = "자동차의 갯수를 1개이상으로 입력해주세요";
    private static String INDEXOUTOFBOUNDSEXCEPTION = "이름 길이가 5초과하였습니다.";

    private ErrorMessage() {

    }

    public static String getNullException() {
        return NULL_EXCEPTION;
    }

    public static String getEmptyException() {
        return EMPTY_EXCEPTION;
    }

    public static String getNUMBERFORMATEXCEPTION() {
        return NUMBERFORMATEXCEPTION;
    }

    public static String getARRAYINDEXOUTOFBOUNDSEXCEPTION() {
        return ARRAYINDEXOUTOFBOUNDSEXCEPTION;
    }

    public static String getINDEXOUTOFBOUNDSEXCEPTION() {
        return INDEXOUTOFBOUNDSEXCEPTION;
    }
}
