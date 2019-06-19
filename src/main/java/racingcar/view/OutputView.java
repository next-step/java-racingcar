package racingcar.view;

import racingcar.model.CarInformation;
import racingcar.model.Position;

import java.util.List;

public class OutputView {
    private static final String CAR_MARK = "-";

    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printCars(List<CarInformation> informationList) {
        for (CarInformation information : informationList) {
            System.out.print(information.getName() + " : ");
            printPosition(information.getPosition());
        }
        System.out.println();
    }

    private static void printPosition(Position position) {
        for (int i = 0; i <= Position.toInteger(position); i++) {
            System.out.print(CAR_MARK);
        }
        System.out.println();
    }

    public static void printWinners(List<CarInformation> winners) {
        System.out.print(winners.get(0).getName());
        for (int i = 1; i < winners.size(); i++) {
            System.out.print(", " + winners.get(i).getName());
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
