package study;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {

    String questionCarCountMessage = "자동차 대수는 몇 대 인가요?";
    String questionTryCountMessage = "시도할 회수는 몇 회 인가요?";
    String questionNoMessage = "NO MESSAGE";

    String forwardMessage = "FORWARD";
    String stopMessage = "STOP";

    Random random = new Random();

    public String questionMessage(String type) {
        if (type.equals("TRY")) {
            return questionTryCountMessage;
        } else if (type.equals("CAR")) {
            return questionCarCountMessage;
        }
        return questionNoMessage;
    }

    public int scanNumber() {
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException imException) {
            System.out.println("숫자만 입력해주세요.");
            scanNumber();
        }finally {
            scanner.close();
        }
        return number;
    }

    public String forwardAndStop() {
        int number = random.nextInt(10);
        String result = "";
        if(number >= 4) {
            result = forwardMessage;
        }else {
            result = stopMessage;
        }
        return result;
    }

}
