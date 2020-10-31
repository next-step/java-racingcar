package study.step3;

import java.util.Set;

interface RacingInfoProvider {
    Set<Car> getCars();

    int countSteps();
}
