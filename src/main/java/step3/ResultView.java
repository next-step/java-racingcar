package step3;
import java.util.List;

public class ResultView {


    public void printPosition(int positions){
        for (int i = 0; i < positions; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void showResult(List<RacingCar> racingCars){
        System.out.println("실행결과");
        for (RacingCar car : racingCars){
            printPosition(car.currentPosition());
        }
    }

}
