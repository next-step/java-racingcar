package racingcar.domain;


public class NameSeparator {

    private final static String NAME_SEPARATE_REGEX = ",";
    private final String nameString;

    public NameSeparator(String nameString) {
        this.nameString = nameString;
    }

    public String[] separate() {
        return this.nameString.split(NAME_SEPARATE_REGEX);
    }

}
