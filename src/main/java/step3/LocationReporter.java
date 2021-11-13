package step3;

import java.util.List;

public class LocationReporter implements Contest.ReportingLocation {
    @Override
    public void report(List<Car> participants) {
        participants.forEach((car) ->
                System.out.println(new String(new char[car.location + 1]).replace("\0", "-"))
        );
        System.out.println();
    }
}
