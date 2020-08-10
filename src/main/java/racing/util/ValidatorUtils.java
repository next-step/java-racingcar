package racing.util;

import racing.domain.Condition;
import racing.message.ErrMsg;

import java.util.Arrays;

public class ValidatorUtils {
    public static void name(String text) {
        if (!Condition.checkName(text)) {
            throw new RuntimeException(ErrMsg.NAME_FORMAT_ERR.getMsg());
        }
    }

    public static void validName(String[] arrName) throws Exception {
        Arrays.stream(arrName).forEach(name -> {
            name(name);
        });
    }
}
