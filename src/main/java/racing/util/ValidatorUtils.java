package racing.util;

import racing.domain.Condition;
import racing.message.ErrMsg;

public class ValidatorUtils {
    public static void name(String text) {
        if (!Condition.checkName(text)) {
            throw new RuntimeException(ErrMsg.NAME_FORMAT_ERR.getMsg());
        }
    }
}
