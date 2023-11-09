package game.race.view;

import java.util.ArrayList;
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
            printMark(raceDto.getVehicleNames().get(idx),
                      cars.get(idx).getMoveCount());
        }

        System.out.println(END_MARK);
    }

    private void printMark(String vehicleName, int moveCount) {
        String tireMark = (moveCount == 0) ? MARK : MARK.repeat(moveCount);
        System.out.println(vehicleName + " : " + tireMark);
    }

    public void printWinner(List<Car> cars) {
        print(getWinners(cars));
    }

    public static List<String> getWinners(List<Car> cars) {
        int maxMoveCount = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }

        for (Car car : cars) {
            if (maxMoveCount == car.getMoveCount()) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public void print(List<String> winners) {
        for (int i = 0; i < winners.size(); i++) {
            if (winners.size() == 1) {
                System.out.println(winners.get(i) + "가 최종 우승했습니다.");
                return;
            }

            if (i == winners.size() -1) {
                System.out.println(winners.get(i) + "가 최종 우승했습니다.");
                return;
            }

            System.out.print(winners.get(i) + ", ");
        }
    }
}
