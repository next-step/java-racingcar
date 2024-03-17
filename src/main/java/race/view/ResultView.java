package race.view;

import race.domain.Car;

import java.util.List;

public class ResultView {

    private static final String FORWARD_SIGN = "-";

    public void printResult() {
        System.out.println("실행 결과\n");
    }

    public void showResult(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i).getName()+" : "+FORWARD_SIGN.repeat(carList.get(i).getPosition()));
        }
        System.out.println();
    }

    public void showWinners(List<String> winnerNames) {
        for (int i = 0; i < winnerNames.size(); i++) {
            System.out.print(winnerNames.get(i));
            printComma(i, winnerNames.size());
        }
        System.out.println("가 최종 우승했습니다.");
    }

    private void printComma(int index, int size) {
        if (index < size - 1)
            System.out.print(", ");
    }
}
