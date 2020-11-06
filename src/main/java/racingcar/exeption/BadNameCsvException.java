package racingcar.exeption;

import racingcar.asset.ExceptionConst;

public class BadNameCsvException extends RuntimeException {
    public BadNameCsvException() {
        super(ExceptionConst.BAD_NAME_CSV_MSG);
    }
}
