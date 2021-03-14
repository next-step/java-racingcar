package step3.view;

import step3.object.Car;
import java.util.List;

public class ResultView {

    public void displayMove(List<Car> carList) {
        for(Car car : carList){
            renderDrive(car);
        }
        System.out.println();
    }

    private void renderDrive(Car car) {
        StringBuffer line = new StringBuffer();
        for(int i = 0; i < car.getGoCount(); i++){
            line.append("-");
        }
        System.out.println(line.toString());
    }

}
