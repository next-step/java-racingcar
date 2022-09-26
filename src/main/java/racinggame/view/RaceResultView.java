package racinggame.view;

import racinggame.dto.CarMoveInfo;
import racinggame.dto.RaceResultDTO;

import java.util.List;

public class RaceResultView {

    private static final String PRINT_DISTANCE_MARK = "-";
    private final StringBuilder carMoveDistanceResult = new StringBuilder();

    public void printResult() {
        System.out.println(carMoveDistanceResult);
    }

    public void readRaceReslut(RaceResultDTO raceResultDTO) {
        List<List<CarMoveInfo>> raceResult = raceResultDTO.getRaceResult();

        for (List<CarMoveInfo> carMoveInfosPerRound : raceResult) {
            readCarMoveInfosPerRound(carMoveInfosPerRound);
            carMoveDistanceResult.append(System.lineSeparator());
        }
    }

    private void readCarMoveInfosPerRound(List<CarMoveInfo> carMoveInfos) {
        for (CarMoveInfo carMoveInfo : carMoveInfos) {
            readCarMoveInfo(carMoveInfo);
        }
    }

    private void readCarMoveInfo(CarMoveInfo carMoveInfo) {
        for (int i = 0; i < carMoveInfo.distance(); i++) {
            carMoveDistanceResult.append(PRINT_DISTANCE_MARK);
        }
        carMoveDistanceResult.append(System.lineSeparator());
    }
}
