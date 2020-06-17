package step3;
import java.util.List;

public class ResultView {

    public void printPosition(int positions){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < positions; i++) {
            result.append("-");
        }
        System.out.println(result.toString());
    }

    public void showResult(List<RacingCar> racingCars){
        System.out.println("실행결과");
        for (RacingCar car : racingCars){
            printPosition(car.currentPosition());
        }
    }

}
