package racingcar.service;

import racingcar.domain.Records;

public interface GameService {
    public void init(String gameInstanceNames, int stepNumber);

    public Records run();

}
