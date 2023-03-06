package car.ui;

import car.domain.Name;
import car.domain.Position;

public class View {

    private final Name name;
    private final Position position;

    public View(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String printStatus() {
        return String.format("%s : %s", this.name.getName(), getPosition());
    }

    private String getPosition() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < position.getPosition(); i++) {
            sb.append("-");
        }

        return sb.toString();
    }
}
