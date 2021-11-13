package step3.view;

import step3.domain.Contest;
import step3.domain.Location;

import java.util.List;

public class LocationReporter implements Contest.ReportingLocation {
    private static final String empty = "\0";
    private static final String marker = "-";
    private static final int START_LINE = 1;

    @Override
    public void report(List<Location> locations) {
        locations.forEach(this::print);
    }

    private void print(Location location) {
        System.out.println(new String(new char[location.getValue() + START_LINE]).replace(empty, marker));
    }
}
