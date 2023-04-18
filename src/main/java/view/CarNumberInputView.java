package view;

import domain.NumberOfCars;

import java.util.Scanner;

public class CarNumberInputView implements InputView<NumberOfCars> {
    @Override
    public NumberOfCars receive() {
        printQuestion();
        return receiveInput();
    }

    private NumberOfCars receiveInput() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return new NumberOfCars(number);
    }

    private void printQuestion() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

}
