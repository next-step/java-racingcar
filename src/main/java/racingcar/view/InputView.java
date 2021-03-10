package racingcar.view;

import racingcar.domain.request.Amount;
import racingcar.domain.dto.RacingCarRequestDto;
import racingcar.domain.request.Round;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static InputView instance;

    private InputView() { }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public RacingCarRequestDto createRacingCarRequestDto() {
        return RacingCarRequestDto.of(getAmount(), getRound());
    }

    private Amount getAmount() {
        return Amount.from(getAmountValue());
    }

    private Round getRound() {
        return Round.from(getRoundValue());
    }

    private int getAmountValue() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    private int getRoundValue() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
