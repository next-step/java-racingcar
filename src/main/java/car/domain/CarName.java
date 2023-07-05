package car.domain;

public class CarName {
    private String name;
    CarName (String name) {
        validateCarName(name);
        this.name = name;
    }
    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new RuntimeException();
        }
    }
    public String getName() {
        return name;
    }
}
