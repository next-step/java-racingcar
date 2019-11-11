package racingcar.domain;

public class CarRecord {

    private static final String LOCATION_EXPRESSION_STRING = "-";

    private String name;
    private int location;

    public CarRecord(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public static CarRecord of(Car car) {
        return new CarRecord(car.getName(), car.getLocation());
    }

    public String getPrintRecordFormat() {
        return String.format("%s : %s", name, makeLocation());
    }

    private String makeLocation() {
        StringBuilder locationBuilder = new StringBuilder();
        for (int i = 0; i < location; i++) {
            locationBuilder.append(LOCATION_EXPRESSION_STRING);
        }
        return locationBuilder.toString();
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public boolean equalsLocation(int winnerLocation) {
        return location == winnerLocation;
    }
}
