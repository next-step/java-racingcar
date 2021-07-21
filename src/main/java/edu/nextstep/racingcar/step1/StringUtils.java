package edu.nextstep.racingcar.step1;

public class StringUtils {

    private final String param;

    public StringUtils(String param) {
        this.param = param;
    }

    public String[] splitByComma() {
        return this.param.split(",");
    }

    public String removeBracket() {
        return this.param.substring(1, this.param.length() - 1);
    }

    public char getCharacter(int index) {
        return this.param.charAt(index);
    }
}
