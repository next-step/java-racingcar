package step3;

import java.util.Scanner;

public class InputView {

    ValidationCheck validationCheckCheck = new ValidationCheck();
    Scanner sc = new Scanner(System.in);


    public String[] inputPlayerName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String playerNames = sc.nextLine();
        // 유효성체크 필요 (, 가 포함된 문자열인지)
        // "," 단위로 쪼개는 것 필요
        String[] eachName = playerNames.split(",");
        return eachName;
    }

    public int inputCarNumber() {
        System.out.println("자동차 대수는 몇대 인가요?");
        int carNumber = sc.nextInt();
        // Player 수와 차 대수가 동일한지 유효성 체크
        validationCheckCheck.checkInputCarNumber(carNumber);
        return carNumber;
    }

    public int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryCount = sc.nextInt();
        validationCheckCheck.checkInputTryCount(tryCount);
        return tryCount;
    }
}
