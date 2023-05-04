package racinggame.common.constants;

public enum RexFormatConstants {

    CARS_NAME_REX_FORMAT_TEXT(","),

    ;

    private final String value;

    RexFormatConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
