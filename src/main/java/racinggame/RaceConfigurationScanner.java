package racinggame;

import racinggame.dto.RaceConfigurationDTO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RaceConfigurationScanner {

    private static final String ASK_CAR_COUNT_MESSAGE = "경기할 자동차는 몇 대 인가요?";
    private static final String ASK_RACE_COUNT_MESSAGE = "경기는 회수는 몇 회 진행 할까요?";
    private static final String INPUT_IS_NOT_NUMBER_MESSAGE = "숫자만 입력할 수 있습니다.";
    private static final String COMMON_ERROR_MESSAGE = "에러가 발생 했습니다.";

    private static final Scanner sc = new Scanner(System.in);

    public RaceConfigurationDTO scan() {
        try {
            System.out.println(ASK_CAR_COUNT_MESSAGE);
            int carCount = sc.nextInt();

            System.out.println(ASK_RACE_COUNT_MESSAGE);
            int roundCount = sc.nextInt();

            return new RaceConfigurationDTO(carCount, roundCount);
        } catch (InputMismatchException e) {
            System.err.println(INPUT_IS_NOT_NUMBER_MESSAGE);
            throw e;
        } catch (Exception e) {
            System.err.println(COMMON_ERROR_MESSAGE + " " + e);
            throw e;
        }
    }
}
