package racinggame.domain;

public class CarName {

    private String name;

    public CarName(String name) {
        if (isBlank(name)) {
            throw new RuntimeException();
        }
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }
}
