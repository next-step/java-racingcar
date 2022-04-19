package racing.view;

import racing.domain.Car;

import java.util.List;

public class ResultView {

    public void printCarsPosition(List<Car> cars) {
        int index = 1;
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int distance = 0; distance < car.getDistance(); distance++) {
                System.out.print("-");
            }
            index++;
            System.out.println();
        }

        System.out.println();
    }

    public void printWinners(List<Car> cars) {
        StringBuilder winnerNames = new StringBuilder();
        for (Car car : cars) {
            appendComma(winnerNames);
            winnerNames.append(car.getName());
        }
        System.out.println(winnerNames+"가 최종 우승했습니다.");
    }

    private void appendComma(StringBuilder name) {
        if(name.length() > 0) {
            name.append(",");
        }
    }

}
