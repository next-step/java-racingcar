package new_racingcar;

import java.util.List;

public class ResultView {

    public void printGameStart() {
        System.out.println("");
        System.out.println("경기 결과");
    }

    public void printGrandPrixRecords(List<Round> rounds) {
        rounds.stream()
                .forEach(r -> printRound(r.getRoundInfo()));

        System.out.println("경기가 종료되었습니다");
    }

    private void printRound(List<Car> cars) {
        cars.stream()
                .forEach(c -> printLab(c.getDistance()));

        System.out.println("");
    }

    private void printLab(int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }
}
