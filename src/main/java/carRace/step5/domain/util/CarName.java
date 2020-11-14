package carRace.step5.domain.util;

public class CarName {

    private static String carNames;

    private CarName(){

    }

    public static String[] checkCarNames(String paramValue) {
        checkNamesValue(paramValue);

        for(String carName : paramValue.split(",")){
            checkNameLength(carName);
        }

        return paramValue.split(",");
    }


    private static void checkNameLength(String paramValue) {
        if (paramValue.length() > 5) {
            throw new IndexOutOfBoundsException(ErrorMessage.getINDEXOUTOFBOUNDSEXCEPTION());
        }
    }

    /**
     * 이름 체크
     *
     * @param paramValue
     */
    private static void checkNamesValue(String paramValue) {
        isNullCheck(paramValue);
        isEmptyCheck(paramValue);
    }


    /**
     * empty 체크
     *
     * @param paramValue
     */
    private static void isEmptyCheck(String paramValue) {
        if ("".equals(paramValue)) {
            throw new NumberFormatException(ErrorMessage.getEmptyException());
        }
    }

    /**
     * null 체크
     *
     * @param paramValue
     */
    private static void isNullCheck(String paramValue) {
        if (paramValue == null) {
            throw new NullPointerException(ErrorMessage.getNullException());
        }
    }

}
