package step2;

public enum ValidatorEnum {
    BLANK(" "),
    NULL_UPPERCASE("NULL"),
    NULL_LOWERCASE("null"),
    EMPTY(""),
    OK("OK");


    private final String notOperation;

    ValidatorEnum(String notOperation) {
        this.notOperation = notOperation;
    }

    public static ValidatorEnum notOperationAndThrow(String operator) {
        for (ValidatorEnum validatorEnum : ValidatorEnum.values()) {
            if (validatorEnum.notOperation.equals(operator)) {
                return validatorEnum;
            }
        }
        return ValidatorEnum.OK;
    }
}
