package racing;

import java.util.Scanner;

public class InputView {
    Scanner scanner;
    RacingVO racingVO;
    int carNumber;
    int count;

    public InputView() {
        this.scanner = new Scanner(System.in);
        this.racingVO = RacingVO.getInstance();
    }

    public RacingVO inputValue() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.carNumber = this.validNumberCheck(this.scanner.nextInt());
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.count = this.validNumberCheck(this.scanner.nextInt());
        return this.settingRacingVO(this.carNumber, this.count);
    }

    public RacingVO settingRacingVO(int carNumber, int count) {
        this.racingVO.setCarNumber(carNumber);
        this.racingVO.setCount(count);
        this.racingVO.setCarPositions(new int[this.racingVO.getCarNumber()]);
        return this.racingVO;
    }

    public int validNumberCheck(int checkVal) {
        if (checkVal <= 0) {
            throw new IllegalArgumentException("자동차 대수 및 시도할 회수는 1 이상이어야 합니다.");
        } else {
            return checkVal;
        }
    }
}