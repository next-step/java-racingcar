package carRace.step5.domain.util;

public class CarNamesCheck {

    public static String[] checkCarNames(String paramValue) {
        isEmptyAndNullCheck(paramValue);

        for (String carName : paramValue.split(",")) {
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
     * empty 또는 null 체크
     *
     * @param paramValue
     */
    private static void isEmptyAndNullCheck(String paramValue) {
        if ("".equals(paramValue) || paramValue == null) {
            throw new NullPointerException(ErrorMessage.getEmptyException());
        }
    }
}
