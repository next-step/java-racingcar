package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingMain {
    public static void main(String[] args) {
        Scanner carNames = new Scanner(System.in);
        System.out.println("input name : ");
        String[] carName = (carNames.next()).split(",");
        for (String name : carName) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        System.out.println("rotation count : ");
        int rotation = carNames.nextInt();
        carNames.close();

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carName.length; ++i) {
            carList.add(new Car(carName[i]));
        }

        RacingGame.race(carList,rotation);
    }
}
