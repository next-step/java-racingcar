package racing.model;

public class CarName {

    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        if (checkNameLengthExceed(name)) {
            throw new IllegalArgumentException("차 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다. input: " + name);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean checkNameLengthExceed(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

}
