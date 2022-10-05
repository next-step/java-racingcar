package step3.domain;

public class Sepatation {

    private static final String SEPARATOR = ",";

    public String[] nameSeparation(String inputName) {
        return inputName.split(SEPARATOR);
    }
}
