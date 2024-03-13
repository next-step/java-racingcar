package racingcar.domain;


public class NameSeparator {

    private static final String NAME_SEPARATE_REGEX = ",";

    public static String[] separate(String name) {
        return name.split(NAME_SEPARATE_REGEX);
    }

}
