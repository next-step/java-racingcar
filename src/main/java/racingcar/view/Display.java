package racingcar.view;

import racingcar.domain.Distances;

public interface Display {
    void show(Distances distances);
    
    void showWinners(Distances distances);
}
