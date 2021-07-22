package racing_car.step03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InputView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int count = sc.nextInt();
        System.out.println("시도할 회수는 몇 회인가요?");
        int attempt = sc.nextInt();
        Race race = new Race();
        race.car(count,attempt);

    }
}
