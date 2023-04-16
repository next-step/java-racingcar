package carRacing.view;

import carRacing.domain.Car;

import java.util.List;


public class ResultView {

    public void outputResult(List<Car> cars){
        int carNumber = 0;
        for (Car car : cars) {
            carNumber += 1;
            System.out.print(carNumber + " : ");
            int carLocation = car.getLocation();
            for (int i = 0; i < carLocation; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void resultStart(){
        System.out.println("\n실행결과");
    }
}
