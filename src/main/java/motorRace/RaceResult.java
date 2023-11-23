package motorRace;

import java.util.ArrayList;
import java.util.List;

// 경주 결과를 관리하는 책임
public class RaceResult {
    private List<RoundResult> raceCarPostionResultList;

    public RaceResult() {
        this.raceCarPostionResultList = new ArrayList<>();
    }

    public void saveRound(RacingCars racingCars){
        raceCarPostionResultList.add(new RoundResult(racingCars));
    }

    public class RoundResult {
        private List<Integer> raceCarPositionList;

        public RoundResult(RacingCars raceResultRacingCars){
            List<Integer> positionList = new ArrayList<>();
            raceResultRacingCars.getRacingCarList().forEach(
                    racingCar -> {
                        positionList.add(racingCar.getPosition());
                    }
            );
            this.raceCarPositionList = positionList;
        }

        public List<Integer> getRaceCarPositionList() {
            return raceCarPositionList;
        }
    }

    public List<RoundResult> getRaceCarPostionResultList() {
        return raceCarPostionResultList;
    }
}
