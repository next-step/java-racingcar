package racing.utils;

import racing.Constant;
import racing.dto.GameVO;

public class ValidationUtil {

    public static void validateInput(GameVO vo) {
        if (vo.getCarNames().length <= 0) {
            throw new IllegalArgumentException(Constant.CAR_NUMBER_VALIDATION_ERROR);
        }

        if (vo.getRoundNo() <= 0) {
            throw new IllegalArgumentException(Constant.ROUND_NUMBER_VALIDATION_ERROR);
        }
    }
}
