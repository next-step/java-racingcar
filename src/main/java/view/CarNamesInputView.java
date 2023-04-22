package view;

import domain.CarName;
import domain.NumberOfCars;
import view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarNamesInputView implements InputView<List<CarName>> {
    @Override
    public List<CarName> receive() {
        printQuestion();
        return receiveInput();
    }

    private List<CarName> receiveInput() {
        Scanner scanner = new Scanner(System.in);
        String carNameInput = scanner.next();
        return Arrays.stream(carNameInput.split(","))
                .map(CarName::create)
                .collect(Collectors.toList());
    }

    private void printQuestion() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }
}
