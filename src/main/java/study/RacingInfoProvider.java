package study;

import java.util.Set;

interface RacingInfoProvider {
    Set<Car> getCars();

    int countSteps();
}
