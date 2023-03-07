package racingCar;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RacingCarMain {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputString = in.nextLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int trial = Integer.parseInt(in.nextLine());

        StringTokenizer stringTokenizer = new StringTokenizer(inputString, ",");
        while (stringTokenizer.hasMoreTokens()) {
            cars.add(new Car(stringTokenizer.nextToken()));
        }
        RacingCar racingCar = new RacingCar(trial);
        racingCar.run(cars);
        racingCar.showWinner();
    }
}
