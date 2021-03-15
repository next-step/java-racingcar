package racingcar.service;

import racingcar.domain.Records;

public interface GameService {
    public void init(int gameInstanceNumber, int stepNumber);

    public Records run();

}
