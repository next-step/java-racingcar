package car.ui;

import car.domain.Car;
import car.domain.Name;
import car.domain.Position;

public class View {

    private final Name name;
    private final Position position;

    private View(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void printStatus() {
        String status = String.format("%s : %s", this.name.getName(), getPosition());
        System.out.println(status);
    }

    private String getPosition() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < position.getPosition(); i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public static View from(Car car) {
        return new View(car.getName(), car.getPosition());
    }
}
