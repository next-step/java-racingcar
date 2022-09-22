package step_3;

import step_3.dto.RaceConfigurationDTO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RaceConfigurationScanner {

    public RaceConfigurationDTO scan() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("자동차 대수는 몇 대 인가요?");
            int carCount = sc.nextInt();

            System.out.println("시도할 회수는 몇 회 인가요?");
            int roundCount = sc.nextInt();

            return new RaceConfigurationDTO(carCount, roundCount);
        } catch (InputMismatchException e) {
            System.err.println("숫자만 입력할 수 있습니다.");
            throw e;
        } catch (Exception e) {
            System.err.println("에러가 발생 했습니다." + e);
            throw e;
        }
    }
}
