package racinggame;

import racinggame.dto.RaceInputDTO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RaceInputReader {
    private RaceInputReader() {
    }

    private static final Scanner sc = new Scanner(System.in);

    public static RaceInputDTO raed() {
        try {
            System.out.println("경기할 자동차는 몇 대 인가요?");
            int carCount = sc.nextInt();

            System.out.println("경기는 회수는 몇 회 진행 할까요?");
            int roundCount = sc.nextInt();

            return new RaceInputDTO(roundCount, carCount);
        } catch (InputMismatchException e) {
            System.err.println("숫자만 입력할 수 있습니다.");
            throw e;
        } catch (Exception e) {
            System.err.println("에러가 발생 했습니다." + " " + e);
            throw e;
        }
    }
}
