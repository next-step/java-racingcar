package race;

public class CarName {
    private final String name;

    public CarName(String name) {
        if(name == null || name.trim().isEmpty() || name.trim().length() > 5) {
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }
}
