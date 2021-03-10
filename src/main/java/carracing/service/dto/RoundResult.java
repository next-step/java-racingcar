package carracing.service.dto;

import carracing.service.CarRacingValidator;

/**
 * RoundResult
 * description 경기 한 라운드 결과
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 */
public class RoundResult {

    private CarRacingValidator carRacingValidator;

    private int roundNumber;
    private RacingScores racingScores;

    public RoundResult() {
        this.carRacingValidator = new CarRacingValidator();
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public RacingScores getRacingScores() {
        return racingScores;
    }

    public void registerRoundResult(int roundNumber, RacingScores racingScores) {
        _validateRoundNumber(roundNumber);
        _validateRacingScores(racingScores);
        this.roundNumber = roundNumber;
        this.racingScores = racingScores;
    }

    private void _validateRoundNumber(int roundNumber) {
        carRacingValidator.validateRoundCount(roundNumber);
        if (this.roundNumber == roundNumber) {
            throw new IllegalArgumentException("해당 경기 정보는 이미 등록되었습니다.");
        }
    }

    private void _validateRacingScores(RacingScores racingScores) {
        if(racingScores==null || racingScores.getScoreCount()==0) {
            throw new IllegalArgumentException("경기 정보가 존재하지 않습니다.");
        }
    }
}
