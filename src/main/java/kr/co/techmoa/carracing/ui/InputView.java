package kr.co.techmoa.carracing.ui;

import kr.co.techmoa.carracing.model.Car;

import java.util.Scanner;

public class InputView {

    public void view() {

        Car car = new Car();

        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        car.setOwnCar(scanner.nextInt());

        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner1 = new Scanner(System.in);
        car.setTryNumber(scanner1.nextInt());
    }
}
