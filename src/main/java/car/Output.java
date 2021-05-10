package car;

import java.util.Arrays;
import java.util.List;

public class Output {
    private Drive drive = new Drive();
    private List<Car> cars;

    public Output(List<Car> cars) {
        this.cars = cars;
    }

    public String printLines(int km) {
        String lines = "";
        for (int i = 0; i < km; i++) {
            lines = lines + "-";
        }
        return lines;
    }

    public void printCars() {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).getName() + " : " + printLines(cars.get(i).getKm()));
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

        int[] kms = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            kms[i] = cars.get(i).getKm();
        }

        Arrays.sort(kms);

        int max = kms[kms.length - 1];

        for (int i = 0; i < cars.size(); i++) {
            winners.append(getWinner(cars.get(i), max));
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
