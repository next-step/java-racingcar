package carracing.controller;

import carracing.controller.dto.CarRacingRequest;
import carracing.controller.dto.CarRacingResponse;
import carracing.controller.dto.RacingScoreInfo;
import carracing.controller.dto.RoundResultInfo;
import carracing.service.CarRacingService;
import carracing.service.dto.*;

import java.util.ArrayList;
import java.util.List;

/**
 * CarRacingController
 * description 자동차 경주 API
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 */
public class CarRacingController {

    private final CarRacingService carRacingService;

    public CarRacingController() {
        this.carRacingService = new CarRacingService();
    }

    public CarRacingResponse executeCarRacing(CarRacingRequest carRacingRequest) {
        return assembleResponse(carRacingService.executeCarRacing(carRacingRequest));
    }

    private CarRacingResponse assembleResponse(RacingResult racingResult) {
        List<RoundResultInfo> roundResultInfoList = new ArrayList<>();
        for (RoundResult roundResult : racingResult.getRoundResultList()) {
            roundResultInfoList.add(new RoundResultInfo(roundResult.getRoundNumber(), assembleRacingScoreInfo(roundResult.getRacingScores())));
        }
        return new CarRacingResponse(roundResultInfoList);
    }

    private List<RacingScoreInfo> assembleRacingScoreInfo(RacingScores racingScores) {
        List<RacingScoreInfo> racingScoreInfoList = new ArrayList<>();
        for (RacingScore racingScore : racingScores.getRacingScoreList()) {
            racingScoreInfoList.add(new RacingScoreInfo(racingScore.getCarName(), racingScore.getScore()));
        }
        return racingScoreInfoList;
    }
}
