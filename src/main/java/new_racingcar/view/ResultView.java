package new_racingcar.view;

import new_racingcar.constant.MsgConstants;
import new_racingcar.domain.Car;
import new_racingcar.domain.Round;

import java.util.List;

public class ResultView {

    public void printGrandPrixRecords(List<Round> rounds) {
        System.out.println("");
        System.out.println(MsgConstants.RESULT_RACING_END_MESSAGE);

        rounds.stream()
                .forEach(r -> printRound(r.getRoundInfo()));

        printRacingWinner(rounds.get(rounds.size()-1));
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

    private void printRacingWinner(Round round) {
        String winners = round.getWinnerNames(round.getMaxDistance());
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
