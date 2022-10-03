package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.CarSnapshot;
import racinggame.dto.RaceResultDTO;
import racinggame.domain.RoundSnapshot;

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

        for (RoundSnapshot roundSnapshot : raceResultDTO.getRoundSnapshots()) {
            readRoundSnapshot(roundSnapshot);
            changeLine();
        }

        raceResult.append(winnersName(raceResultDTO.getWinners()) + "가 최종 우승했습니다.");
    }

    private String winnersName(List<Car> winners) {
        return winners.stream()
                .map(Car::name)
                .collect(Collectors.joining(", "));
    }

    private void readRoundSnapshot(RoundSnapshot roundSnapshot) {
        roundSnapshot.getCarSnapshots().forEach(this::readCarMoveInfo);
    }

    private void readCarMoveInfo(CarSnapshot carSnapshot) {
        readName(carSnapshot);
        readDistance(carSnapshot);
        changeLine();
    }

    private void changeLine() {
        raceResult.append(System.lineSeparator());
    }

    private void readName(CarSnapshot carSnapshot) {
        raceResult.append(carSnapshot.name());
        raceResult.append(" : ");
    }

    private void readDistance(CarSnapshot carSnapshot) {
        for (int i = 0; i < carSnapshot.distance(); i++) {
            raceResult.append(PRINT_DISTANCE_MARK);
        }
    }
}
