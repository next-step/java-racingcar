package step4.domain.startegy.name;

public class NameLengthLessThanFive implements NamingStrategy {

    private final int MAXIMUM = 5;
    private final int MINIMUM = 0;

    @Override
    public boolean isValidate(String name) {
        return (getNameLength(name) >= MINIMUM && getNameLength(name) <= MAXIMUM);
    }

    private int getNameLength(String name) {
        return name.length();
    }

}
