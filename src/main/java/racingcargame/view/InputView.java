package racingcargame.view;

import racingcargame.domain.RacingCarName;
import racingcargame.exception.WordCountException;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public String inputNameOfCars() throws WordCountException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return checkWordCount(scanner.nextLine());
    }

    public int inputCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public void close() {
        scanner.close();
    }

    public String checkWordCount(String nameOfCars) throws WordCountException {
        String[] carsName = nameOfCars.split(",");
        RacingCarName racingCarName;
        for (String carName : carsName) {
            racingCarName = new RacingCarName(carName);
            racingCarName.wordCountException(carName);
        }
        return nameOfCars;
    }
}