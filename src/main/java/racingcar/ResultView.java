package racingcar;

import java.util.List;

public class ResultView {
    public void printWinner(List<Car> cars){
        //sortCar 기능 -> 비지니스 로직
        StringBuilder winnersBuilder = new StringBuilder();
        cars.sort((car1, car2) -> car2.getPosition() - car1.getPosition());
        int maxScore = cars.get(0).getPosition();
        for (Car car : cars) {
            if (maxScore == car.getPosition()) {
                winnersBuilder.append(car.getName()).append(", ");

            }
        }
        //print 기능, 보여주기만 한다.
        //["a", "b", "c"]
        String winners = winnersBuilder.substring(0, winnersBuilder.length() - 2);
        System.out.println("최종 우승자: " + winners);
    }

    public void printCars(List<Car> cars){
        for (Car car : cars) {
            car.go();
            car.print();
        }
        System.out.println();
    }
}
