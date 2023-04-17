package racingcar.service;

public class CarNameManagement {
    private String[] names;
    private final int NAME_STANDARD = 5;
    private final int ZERO = 0;
    private final String DELIMITER = ",";

    public CarNameManagement(String nameOfCars) {
        this.names = validateNameOfCars(split(nameOfCars));
    }

    private String[] validateNameOfCars(String[] names) {
        for(String name: names) {
            if (name.length() > NAME_STANDARD) {
                throw new RuntimeException("over 5 length");
            }
        }
        return names;
    }

    private String[] split(String nameOfCars) {
        if (nameOfCars.length() == ZERO) {
            throw new RuntimeException("player zero");
        }

        return nameOfCars.split(DELIMITER);
    }

    public String[] getNames() {
        return names;
    }
}
