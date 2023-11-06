package car;

import java.util.List;
import java.util.Scanner;

public class InputOutput {
    private static final Scanner sc = new Scanner(System.in);

    public static int carIO() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return sc.nextInt();
    }

    public static int moveIO() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return sc.nextInt();
    }

    public static void main(String[] args) {
        List<Car> cars= CarService.generate(carIO());
        int moveCount = moveIO();

        for(int i = 0 ; i < moveCount; i++) {
            for(Car car: cars) {
                car.move(CarService.randomValue());
                System.out.println(car.moveMark());
            }
            System.out.println();
        }
    }
}
