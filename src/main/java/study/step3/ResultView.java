package study.step3;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void output(Cars carList){
        printPosition(carList.getCars());
        System.out.println();
    }

    private void printPosition(List<Car> cars){
        for(Car car : cars){
            printRandomRaceCarPosition(car.position());
        }
    }

    private void printRandomRaceCarPosition(Position position){
        for(int i = 0;i < position.position();i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void winners(Cars cars) {
        String result = String.join(",", cars.winners()
                .stream()
                .map(car -> car.name().name())
                .collect(Collectors.toList()));
        System.out.println(result + "가 최종우승했습니다.");
    }

}
