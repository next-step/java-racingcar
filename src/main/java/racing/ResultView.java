package racing;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    public static void printResult(List<RacingCar> racingCars) {
        System.out.println();
        racingCars.forEach(racingCar -> {
            System.out.println(racingCar.toString());
        });
    }

    public static void printWinner(List<RacingCar> racingCars) {
        IntStream.range(0, racingCars.size())
                 .forEach(i -> {
                     if (i != 0 && racingCars.size() != i) {
                         System.out.print(", ");
                     }
                     System.out.print(racingCars.get(i).getCarName());
                 });
        System.out.print("가(이) 최종 우승했습니다.");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
