package racinggame.view;

import racinggame.domain.entity.Contest;
import racinggame.domain.value.Location;

import java.util.List;

public class LocationView implements Contest.ReportingLocation {
    private static final String empty = "\0";
    private static final String marker = "-";
    private static final int START_LINE = 1;

    @Override
    public void report(List<Location> locations) {
        locations.forEach(this::render);
        System.out.println();
    }

    private void render(Location location) {
        String carName = location.getCarName();
        String locationExpression = new String(new char[location.getValue() + START_LINE]).replace(empty, marker);
        String expression = carName + " : " + locationExpression;
        System.out.println(expression);
    }
}
