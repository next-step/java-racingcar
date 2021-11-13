package step4;

public class CarName {

    private String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNotNull(name);
        validateNotEmpty(name);
        validateLengthShorterOrEqualThan5(name);
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

    private void validateLengthShorterOrEqualThan5(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != CarName.class) {
            return false;
        }
        CarName other = (CarName) o;
        return this.name.equals(other.name);
    }
}
