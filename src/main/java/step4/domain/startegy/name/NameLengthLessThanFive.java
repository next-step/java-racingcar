package step4.domain.startegy.name;

public class NameLengthLessThanFive implements NamingStrategy {

    private final int MAXIMUM = 5;
    private final int MINIMUM = 0;

    private static NameLengthLessThanFive nameLengthLessThanFive;

    public static NameLengthLessThanFive getInstance() {
        if (isInstanceNull()) nameLengthLessThanFive = new NameLengthLessThanFive();
        return nameLengthLessThanFive;
    }

    private static boolean isInstanceNull() {
        return nameLengthLessThanFive == null;
    }

    @Override
    public boolean isValidate(String name) {
        return (getNameLength(name) >= MINIMUM && getNameLength(name) <= MAXIMUM);
    }

    private int getNameLength(String name) {
        return name.length();
    }

}
