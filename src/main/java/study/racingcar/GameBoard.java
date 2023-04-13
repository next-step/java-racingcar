package study.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameBoard {
    public void run() {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = sc.nextInt();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }
    }
}
