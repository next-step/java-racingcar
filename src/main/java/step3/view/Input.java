package step3.view;

import step3.model.CarList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private Integer countOfCar;
    private Integer countOfTry;

    public Integer getCountOfTry() {
        return countOfTry;
    }

    public Integer getCountOfCar() { return countOfCar;}

    public void inputView() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        this.countOfCar = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        this.countOfTry = scanner.nextInt();
    }
}
