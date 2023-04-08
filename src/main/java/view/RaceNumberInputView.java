package view;

import domain.CarNumber;
import domain.RaceNumber;

import java.util.Scanner;

public class RaceNumberInputView implements InputView<RaceNumber> {
    @Override
    public RaceNumber receive() {
        printQuestion();
        return receiveInput();
    }

    private RaceNumber receiveInput() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return new RaceNumber(number);
    }

    private void printQuestion() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }
}
