package step4.view;

import step4.domain.Car;

import java.util.List;

public class ResultView {
    private static final String EXECUTION = "\n실행 결과";
    private static final String ROUND_SEPARATION = "\n";

    public void printResultView() {
        System.out.println(EXECUTION);
    }

    public void separateRound() {
        System.out.println(ROUND_SEPARATION);
    }

    public void printCarLocation(int location) {
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printCarName(Car car) {
        System.out.print(car.getName() + " : ");
    }

    public void printWinners(List<Car> winners) {
        for (int i = 0; i < winners.size() - 1; i++) {
            System.out.print(winners.get(i).getName() + ", ");
        }
        System.out.print(winners.get(winners.size() - 1).getName() + "가 우승하였습니다");
    }

}
