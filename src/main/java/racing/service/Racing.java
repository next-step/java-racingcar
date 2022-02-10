package racing.service;

import java.util.ArrayList;
import java.util.List;
import racing.domain.Car;
import racing.dto.RacingInfoDto;
import racing.domain.Round;
import racing.vo.CarResultVO;
import racing.domain.RoundResult;

public class Racing {

    private final List<Car> cars;
    private final Round round;
    private final List<RoundResult> results;
    private int roundNumber;

    public Racing(RacingInfoDto info) {
        cars = info.getCars();
        round = info.getRound();
        roundNumber = round.getRoundNumber();
        results = new ArrayList<>();
    }

    public void race() {
        while (isInProgress(roundNumber)) {
            runGame();
        }
    }

    private boolean isInProgress(int roundNumber) {
        return roundNumber > 0;
    }

    private void runGame() {
        List<CarResultVO> resultVO = round.play(cars);
        results.add(new RoundResult(resultVO));
        roundNumber--;
    }

    public RoundResult getLastResult() {
        final int LAST_INDEX = results.size() - 1;
        return results.get(LAST_INDEX);
    }

    public List<RoundResult> getRoundResults() {
        return results;
    }
}
