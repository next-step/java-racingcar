package com.nextstep.javaRacing.view;

import java.util.Scanner;

public class InputView {

    private final int cars;
    private final int turns;

    public InputView(int cars, int turns) {
        this.cars = cars;
        this.turns = turns;
    }

    public InputView() {
        System.out.println("몇 대의 차량이 있나요? : ");
        cars = scanNumber();
        System.out.println("몇 회 반복할까요? : ");
        turns = scanNumber();
    }

    private int scanNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }

    public int cars() {
        return this.cars;
    }

    public int turns() {
        return this.turns;
    }
}
