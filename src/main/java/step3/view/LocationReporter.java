package step3.view;

import step3.domain.Contest;

import java.util.List;

public class LocationReporter implements Contest.ReportingLocation {
    private static final String empty = "\0";
    private static final String marker = "-";

    @Override
    public void report(List<Integer> locations) {
        locations.forEach(this::print);
    }

    private void print(int location) {
        System.out.println(new String(new char[location + 1]).replace(empty, marker));
    }
}
