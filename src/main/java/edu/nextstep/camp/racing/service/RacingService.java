package edu.nextstep.camp.racing.service;

import edu.nextstep.camp.racing.model.RacingResult;
import edu.nextstep.camp.racing.model.RacingStartInput;
import edu.nextstep.camp.racing.repo.RacingRepository;

public class RacingService {

    public RacingResult startRace(RacingStartInput racingStartInput) {
        RacingRepository racingRepository = new RacingRepository(racingStartInput);

        for (int racingIdx = 0; racingIdx < racingStartInput.getMovingCnt(); racingIdx++) {
            racingRepository.move(racingIdx);
        }

        return racingRepository.racingResult();
    }
}
