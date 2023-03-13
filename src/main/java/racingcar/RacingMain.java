package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingMain {
    public static void main(String[] args) {
        Scanner inputCarNames = new Scanner(System.in);
        System.out.println("input name : ");
        String[] carName = (inputCarNames.next()).split(",");
        for (String name : carName) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        System.out.println("rotation count : ");
        int rotation = inputCarNames.nextInt();
        inputCarNames.close();

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carName.length; ++i) {
            carList.add(new Car(carName[i]));
        }

        RacingGame.race(carList, rotation);
    }
}
