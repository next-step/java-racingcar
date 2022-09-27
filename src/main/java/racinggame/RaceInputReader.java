package racinggame;

import racinggame.dto.RaceInputDTO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RaceInputReader {

    public static final String CAR_NAME_SEPERATOR = ",";

    private RaceInputReader() {
    }

    private static final Scanner sc = new Scanner(System.in);

    public static RaceInputDTO raed() {
        try {
            System.out.println("자동차 이름을 입력해 주세요 (여러개인 경우 , 로 구분)");
            String carNames = sc.nextLine();

            System.out.println("경기는 회수는 몇 회 진행 할까요?");
            int roundCount = sc.nextInt();

            return new RaceInputDTO(roundCount, split(carNames));
        } catch (InputMismatchException e) {
            System.err.println("숫자만 입력할 수 있습니다.");
            throw e;
        } catch (Exception e) {
            System.err.println("에러가 발생 했습니다." + " " + e);
            throw e;
        }
    }

    private static String[] split(String carNames) {
        return carNames.replace(" ", "").split(CAR_NAME_SEPERATOR);
    }
}
