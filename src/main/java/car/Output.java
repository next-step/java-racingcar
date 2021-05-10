package car;

import java.util.Arrays;
import java.util.List;

public class Output {
    private final Drive drive = new Drive();
    private final List<Car> cars;

    public Output(List<Car> cars) {
        this.cars = cars;
    }

    public String printLines(Car car) {
        StringBuilder lines = new StringBuilder();
        for (int i = 0; i < car.getKm(); i++) {
            lines.append("-");
        }
        return lines.toString();
    }

    public void printCars() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + printLines(car));
        }
        System.out.println("");
    }

    public String getWinner(Car car, int max) {
        if (car.getKm() == max)
            return car.getName() + ',';
        return "";
    }

    public void printWinner() {
        StringBuilder winners = new StringBuilder();
        int maxKm = 0;

        for (Car car : cars) {
            maxKm = Math.max(maxKm, car.getKm());
        }

        for (Car car : cars) {
            winners.append(getWinner(car, maxKm));
        }

        System.out.println("최종 우승자: " + winners.substring(0, winners.length() - 1));
    }

    public void carRacing(int count) {
        int nowCount = 0;

        System.out.println("실행 결과");

        while (nowCount < count) {
            drive.carDrive(cars);

            printCars();

            nowCount++;
        }

        printWinner();
    }
}
