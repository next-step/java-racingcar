package racinggame.view;

import racinggame.domain.entity.Contest;
import racinggame.domain.value.Location;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerView implements Contest.ReportingWinner {
    @Override
    public void report(List<Location> locations) {
        Location maxLocation = Collections.max(locations, Comparator.comparingInt(Location::getValue));
        List<Location> winningLocations = locations.stream().filter(l -> l.getValue() == maxLocation.getValue()).collect(Collectors.toList());
        System.out.printf("우승자는 %s 입니다.", winningLocations.stream().map(l -> l.getCarName()).collect(Collectors.joining(",")));
    }
}
