package step3.domain;

public enum Separator {

    SPLIT_CAR_NAME_SEPARATOR(",", "쉼표"),
    PROGRESS_DRAW_SEPARATOR("-", "대시");

    private final String separator;
    private final String desc;

    Separator(String separator, String desc) {
        this.separator = separator;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getSeparator() {
        return separator;
    }
}

