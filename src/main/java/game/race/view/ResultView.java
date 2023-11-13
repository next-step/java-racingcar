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

    public static void printWinners(List<String> winners) {
        String winner = String.join(", ", winners);
        System.out.println(winner + "가 최종 우승했습니다.");
    }
}
