package racing.domain;

public final class NameParser {
    private NameParser() {}

    public static String[] parse(final String nameString) {
        if (!isValid(nameString)) {
            throw new IllegalArgumentException();
        }
        return nameString.split(",");
    }

    private static boolean isValid(final String nameString) {
        return (nameString != null && nameString.trim().length() != 0);
    }
}
