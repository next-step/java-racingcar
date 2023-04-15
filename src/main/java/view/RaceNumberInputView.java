package view;

import domain.NumberOfRaces;

import java.util.Scanner;

public class RaceNumberInputView implements InputView<NumberOfRaces> {
    @Override
    public NumberOfRaces receive() {
        printQuestion();
        return receiveInput();
    }

    private NumberOfRaces receiveInput() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return new NumberOfRaces(number);
    }

    private void printQuestion() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }
}
