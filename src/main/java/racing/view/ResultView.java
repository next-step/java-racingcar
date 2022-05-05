package racing.view;

import racing.domain.Car;

import java.util.List;

public class ResultView {

    public void printCurrentStage(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }

        System.out.println();
    }

    private void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int position = 0; position < car.getPosition().getValue(); position++) {
            System.out.print("-");
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
