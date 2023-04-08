package view;

import domain.CarNumber;

import java.util.Scanner;

public class CarNumberInputView implements InputView<CarNumber> {
    @Override
    public CarNumber receive() {
        printQuestion();
        return receiveInput();
    }

    private CarNumber receiveInput() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return new CarNumber(number);
    }

    private void printQuestion() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

}
