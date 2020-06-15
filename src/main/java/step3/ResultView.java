package step3;
import java.util.List;

public class ResultView {

    public ResultView() {
        System.out.println("실행결과");
    }

    public void printPosition(int positions){
        for (int i = 0; i < positions; i++) {
            System.out.println("-");
        }
    }

    public void showResult(List<RacingCar> racingCars){
        for (RacingCar car : racingCars){
            printPosition(car.currentPosition());
        }
    }

}
