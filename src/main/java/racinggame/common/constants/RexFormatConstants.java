package racinggame.common.constants;

public enum RexFormatConstants {

    CARS_NAME_REX_FORMAT_TEXT(","),
    LAST_COMMA_REMOVE_REX_FORMAT_TEXT(",$"),

    ;

    private final String format;

    RexFormatConstants(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

}
