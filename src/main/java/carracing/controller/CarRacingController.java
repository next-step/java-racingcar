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

    private CarRacingService carRacingService;

    public CarRacingController() {
        this.carRacingService = new CarRacingService();
    }

    public CarRacingResponse executeCarRacing(CarRacingRequest carRacingRequest) {
        RacingRegisterInfo racingRegisterInfo = new RacingRegisterInfo(carRacingRequest.getRacingCarCount(), carRacingRequest.getRoundCount());
        return this._assembleResponse(carRacingService.executeCarRacing(racingRegisterInfo));
    }

    private CarRacingResponse _assembleResponse(RacingResult racingResult) {
        CarRacingResponse carRacingResponse = new CarRacingResponse();
        List<RoundResultInfo> roundResultInfoList = new ArrayList<>();

        for (RoundResult roundResult : racingResult.getRoundResultList()) {
            RoundResultInfo roundResultInfo = new RoundResultInfo();
            roundResultInfo.setRoundNumber(roundResult.getRoundNumber());
            roundResultInfo.setRacingScoreInfoList(_assembleRacingScoreInfo(roundResult.getRacingScores()));
            roundResultInfoList.add(roundResultInfo);
        }

        carRacingResponse.setRoundResultList(roundResultInfoList);
        return carRacingResponse;
    }

    private List<RacingScoreInfo> _assembleRacingScoreInfo(RacingScores racingScores) {
        List<RacingScoreInfo> racingScoreInfoList = new ArrayList<>();

        for (RacingScore racingScore : racingScores.getRacingScoreList()) {
            RacingScoreInfo racingScoreInfo = new RacingScoreInfo();
            racingScoreInfo.setCarNumber(racingScore.getCarNumber());
            racingScoreInfo.setScore(racingScore.getScore());
            racingScoreInfoList.add(racingScoreInfo);
        }

        return racingScoreInfoList;
    }
}
