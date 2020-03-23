package racing;

import java.util.Scanner;

public class InputView {
    Scanner scanner;
    RacingVO racingVO;
    int carNumber;
    int count;

    public InputView() {
        scanner = new Scanner(System.in);
        racingVO = RacingVO.getInstance();
    }

    public RacingVO inputValue() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        carNumber = validNumberCheck(scanner.nextInt());
        System.out.println("시도할 회수는 몇 회 인가요?");
        count = validNumberCheck(scanner.nextInt());
        return settingRacingVO(carNumber, count);
    }

    public RacingVO settingRacingVO(int carNumber, int count) {
        racingVO.setCarNumber(carNumber);
        racingVO.setCount(count);
        racingVO.setCarPositions(new int[racingVO.getCarNumber()]);
        return racingVO;
    }

    public int validNumberCheck(int checkVal) {
        if (checkVal <= 0) {
            throw new IllegalArgumentException("자동차 대수 및 시도할 회수는 1 이상이어야 합니다.");
        } else {
            return checkVal;
        }
    }
}