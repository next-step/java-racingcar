package racingcar;

import java.util.List;

public class ResultView {

    private static final String PATH_SYMBOL = "-";


    public void printEveryLocation(List<Car> carList) {
        carList.forEach(c -> System.out.println(this.printResult(c)));
        System.out.println();
    }

    public String printResult(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        printCarName(car, stringBuilder);
        printLocation(car, stringBuilder);
        return stringBuilder.toString();
    }

    private void printLocation(Car car, StringBuilder stringBuilder) {
        int count = 0;
        while (count < car.getCurrentLocation()) {
            stringBuilder.append(PATH_SYMBOL);
            count++;
        }
    }

    private void printCarName(Car car, StringBuilder stringBuilder) {
        stringBuilder.append(car.getCarName()).append(": ");
    }
}
