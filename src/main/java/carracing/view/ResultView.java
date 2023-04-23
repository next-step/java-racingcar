package carracing.view;

import carracing.Car;

public class ResultView {
    private static final String MOVE_MARK = "-";

    public String print(Car car) {
        StringBuilder builder = new StringBuilder();
        builder.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            builder.append(MOVE_MARK);
        }
        return builder.toString();
    }
}
