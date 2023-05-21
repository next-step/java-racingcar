package study.racingcar;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class InputView {

    Random random = new Random();

    public ResultView resultView = new ResultView();

    public int scanNumber() {
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException imException) {
            System.out.println("숫자만 입력해주세요.");
            number = scanNumber();
        }
        return number;
    }

    public String scanString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String[] splitString(String fullString) {
        String[] result =  fullString.split(Race.CAR_NAME_SPLIT_MARK);
        for (String str : result) {
            checkString(str);
        }
        return result;
    }

    public void checkString(String str) {
        if (str.length() > Race.CAR_NAME_LIMIT) {
            System.out.println(resultView.viewQuestionMessage("NAME_ERROR"));
            Race race = new Race();
            race.race();
        }
    }

    public int randomNumber() {
        return random.nextInt(10);
    }
}
