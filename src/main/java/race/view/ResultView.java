package race.view;

import race.Car;
import race.Cars;

import static java.lang.System.out;

public class ResultView {

    private static int HIGH_DISTANCE = -1;

    public void operate(Cars cars, int tryCount) {
        int finalRound = tryCount;
        out.println("실행 결과");
        printCarsByRound(cars, finalRound);
        printWinner(cars, tryCount);
    }

    private void printWinner(Cars cars, int finalRound) {
        String winners = cars.getWinner(HIGH_DISTANCE);
        out.println(winners + "가 최종 우승했습니다.");
    }

    private void printCarsByRound(Cars cars, int finalRound) {
        for (int i = 0; i <= finalRound; i++) {
            int round = i;
            cars.getCars().forEach(car -> printCar(car, round));
            out.println();
        }
    }

    private void printCar(Car car, int round) {
        String carName = car.getName();
        int distance = car.getDistanceByRound(round);

        if (isHighDistance(distance)) {
            HIGH_DISTANCE = distance;
        }

        out.print(carName + " : ");
        out.print("-");
        for (int i = 0; i < distance; i++) {
            out.print("-");
        }
        out.println();
    }

    private boolean isHighDistance(int distance) {
        return HIGH_DISTANCE < distance;
    }

    public ResultView() {

    }

}
