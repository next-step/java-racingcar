package step4;

public class CarName {

    private String name;

    public CarName(String name) {
        validateNotNull(name);
        validateNotEmpty(name);
        this.name = name;
    }

    private void validateNotNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNotEmpty(String name) {
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
    }
}
