package study.step3.view;

import java.util.List;

public class OutputView {

    private static final String TEXT_RESULT = "실행 결과";
    private static final String OUTPUT_TEXT = "-";
    private static final String TEXT_WINNER = "가 최종 우승했습니다.";


    public void outputTextOfResult() {
        System.out.println("\n" + TEXT_RESULT);
    }

    public void outputPositionOfCarsWithName(List<String> carNames, List<Integer> positionOfCars) {
        int countOfCars = positionOfCars.size();

        for (int i = 0; i < countOfCars; i++) {
            System.out.print(carNames.get(i) + " : ");
            int position = positionOfCars.get(i);

            outputPositionOfCar(position);
        }
        System.out.println();
    }

    private void outputPositionOfCar(int position) {
        for (int j = 0; j < position; j++) {
            System.out.print(OUTPUT_TEXT);
        }
        System.out.println();
    }

    public void outputWinners(List<String> winners) {
        int countOfWinners = winners.size();

        for (int i = 0; i < countOfWinners - 1; i++) {
            System.out.print(winners.get(i) + ", ");
        }
        System.out.print(winners.get(countOfWinners - 1));
        System.out.println(TEXT_WINNER);
    }
}
