package racinggame.view;

import racinggame.domain.Car;
import racinggame.dto.CarMoveInfo;
import racinggame.dto.RaceResultDTO;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResultView {

    private static final String PRINT_DISTANCE_MARK = "-";
    private final StringBuilder raceResult = new StringBuilder();

    public void printResult() {
        System.out.println(raceResult);
    }

    public void readRaceResult(RaceResultDTO raceResultDTO) {
        changeLine();
        raceResult.append("실행 결과");
        changeLine();

        for (List<CarMoveInfo> carMoveInfosPerRound : raceResultDTO.getRaceResult()) {
            readCarMoveInfosPerRound(carMoveInfosPerRound);
            changeLine();
        }

        raceResult.append(winnersName(raceResultDTO.winners()) + "가 최종 우승했습니다.");
    }

    private String winnersName(List<Car> winners) {
        return winners.stream()
                .map(Car::name)
                .collect(Collectors.joining(", "));
    }

    private void readCarMoveInfosPerRound(List<CarMoveInfo> carMoveInfos) {
        carMoveInfos.forEach(this::readCarMoveInfo);
    }

    private void readCarMoveInfo(CarMoveInfo carMoveInfo) {
        readName(carMoveInfo);
        readDistance(carMoveInfo);
        changeLine();
    }

    private void changeLine() {
        raceResult.append(System.lineSeparator());
    }

    private void readName(CarMoveInfo carMoveInfo) {
        raceResult.append(carMoveInfo.name());
        raceResult.append(" : ");
    }

    private void readDistance(CarMoveInfo carMoveInfo) {
        for (int i = 0; i < carMoveInfo.distance(); i++) {
            raceResult.append(PRINT_DISTANCE_MARK);
        }
    }
}
