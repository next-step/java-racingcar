package racing.view;

import racing.domain.Car;

public class ResultView {

    public void displayRaceResults(final Car[] cars, final int rounds) {
        System.out.println("\n실행 결과");

        for (int round = 0; round < rounds; round++) {
            displayRound(cars, round);
            System.out.println();
        }
    }

    private void displayRound(final Car[] cars, final int round) {
        for (Car car : cars) {
            int position = car.getPosition(round);
            System.out.println("-".repeat(position));
        }
    }
}