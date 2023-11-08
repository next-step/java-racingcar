package champion;

import java.util.List;
import java.util.Scanner;

import static champion.InputView.*;

public class ResultView {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] names = carNamesIO();
        List<Car> cars = CarService.generate(names);
        int moveCount = moveIO();

        System.out.println("\n실행 결과");

        for (int i = 0; i < moveCount; i++) {
            CarService.repeatMove(cars);
            printMark(cars);
        }

        printChampion(cars);

    }


}
