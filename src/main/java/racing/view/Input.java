package racing.view;

import java.util.Scanner;

public class Input {
    private final String CAR_CNT_MSG = "자동차 대수는 몇 대 인가요?";
    private final String TRY_CNT_MSG = "시도할 회수는 몇 회 인가요?";
    private final String CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private Scanner scanner = new Scanner(System.in);

    public int readCarCount(){
        System.out.println(CAR_CNT_MSG);
        return scanner.nextInt();
    }

    public int readTryCnt(){
        System.out.println(TRY_CNT_MSG);
        return scanner.nextInt();
    }

    public String[] readCars(){
        System.out.println(CAR_NAME_MSG);
        String string =  scanner.next();
        String[] carNames = string.split(",");
        return carNames;
    }

}
