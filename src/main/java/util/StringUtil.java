package util;

public class StringUtil {

    public static String[] participantsSplit(String carName) {

        if (carName == null || carName.length() == 0) {
            throw new IllegalArgumentException("참가자는 1명 이상이어야 합니다.");
        }

        return carName.split(",");
    }

}
