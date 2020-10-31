package step3.view;

import step3.Constant;
import step3.game.RacingInfomation;

import java.util.Scanner;

public class InputView implements View<RacingInfomation> {
    private static final InputView inputView = new InputView();

    private InputView() {
        System.out.println(Constant.CREATED_INSTANCE);
    }

    public static InputView getInstance() {
        return inputView;
    }

    private Integer questionCarNumber(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    private Integer questionPlayCount(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    @Override
    public RacingInfomation execute() {
        Scanner scanner = new Scanner(System.in);
        Integer carNumber = questionCarNumber(scanner);
        Integer playCount = questionPlayCount(scanner);
        return new RacingInfomation(carNumber, playCount);
    }
}
