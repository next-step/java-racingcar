package game.race.view;

import java.util.List;

import game.race.Car;
import game.race.dto.RaceDto;

public class ResultView {

    private static final String SHOW_RESULT = "실행 결과";
    private static final String END_MARK = "";
    private static final String MARK = "-";

    public void showPrompt() {
        System.out.println(SHOW_RESULT);
    }

    public void showCars(RaceDto raceDto, List<Car> cars) {
        for (int idx = 0; idx < cars.size(); idx++) {
            printMark(raceDto.getVehicleNames().get(idx), cars.get(idx).getMoveCount());
        }

        System.out.println(END_MARK);
    }

    private void printMark(String vehicleName, int moveCount) {
        String tireMark = (moveCount == 0) ? MARK : MARK.repeat(moveCount);
        System.out.println(vehicleName + " : " + tireMark);
    }

    public void print(List<String> winners) {
        for (int i = 0; i < winners.size(); i++) {
            if (finalPrint(winners, i)) {
                return;
            }

            System.out.print(winners.get(i) + ", ");
        }
    }

    private static boolean finalPrint(List<String> winners, int i) {
        if (winners.size() == 1) { // only one winner
            System.out.println(winners.get(i) + "가 최종 우승했습니다.");
            return true;
        }

        if (i == winners.size() - 1) { // more winners
            System.out.println(winners.get(i) + "가 최종 우승했습니다.");
            return true;
        }

        return false;
    }
}
