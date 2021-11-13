package step3.view;

import step3.domain.Car;
import step3.domain.Contest;

import java.util.List;

public class LocationReporter implements Contest.ReportingLocation {
    @Override
    public void report(List<Car> participants) {
        participants.forEach((car) ->
                System.out.println(new String(new char[car.getLocation() + 1]).replace("\0", "-"))
        );
        System.out.println();
    }
}
