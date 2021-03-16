package new_racingcar.view;

import new_racingcar.constant.MsgConstants;
import new_racingcar.domain.Car;
import new_racingcar.domain.RoundRecord;

import java.util.List;

public class ResultView {

    public void printGrandPrixRecords(List<RoundRecord> roundRecords) {
        System.out.println("");
        System.out.println(MsgConstants.RESULT_RACING_END_MESSAGE);

        roundRecords.stream()
                .forEach(r -> printRound(r.getRoundInfo()));

        printRacingWinner(roundRecords.get(roundRecords.size()-1));
    }

    private void printRound(List<Car> cars) {
        cars.stream()
                .forEach(c -> printLab(c.getName(), c.getDistance()));

        System.out.println("");
    }

    private void printLab(String name, int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name + " : ");
        for (int i = 0; i < distance; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }

    private void printRacingWinner(RoundRecord roundRecord) {
        String winners = roundRecord.getWinnerNames(roundRecord.getMaxDistance());
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
