package racingcarwinnerrefactor.util;

import racingcarwinnerrefactor.Constants;
import racingcarwinnerrefactor.exception.NullOrEmptyException;

public class NameSplitUtil {
    public static String[] splitName(String names) {
        assertNotBlank(names);
        return names.split(Constants.DELIMITER);
    }

    private static void assertNotBlank(String names) {
        if(names.isBlank()) throw new NullOrEmptyException();
    }
}
