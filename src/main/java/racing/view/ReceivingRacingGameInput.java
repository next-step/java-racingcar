package racing.view;

import java.util.Scanner;

public class ReceivingRacingGameInput {
    private final Scanner scanner;

    public ReceivingRacingGameInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String receiveCarNames() {
        String carNames;
        do{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
            carNames = scanner.nextLine();
        }while(isEmpty(carNames));
        return carNames;
    }

    private boolean isEmpty(String carNames) {
        return carNames == null || carNames.isEmpty();
    }

    public int receiveRoundNumber() {
        int roundNumber = 0;
        try{
            System.out.println("시도할 회수는 몇회인가요?");
            String receivedInput = scanner.nextLine();
            roundNumber = Integer.parseInt(receivedInput);
        }catch (NumberFormatException numberFormatException) {
            receiveRoundNumber();
        }
        return roundNumber;

    }
}
