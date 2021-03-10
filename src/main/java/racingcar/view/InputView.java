package racingcar.view;

import racingcar.domain.request.Amount;
import racingcar.domain.dto.RacingCarRequestDto;
import racingcar.domain.request.Round;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;
    private static InputView instance;

    private InputView() {
        scanner = new Scanner(System.in);
    }

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
        return Amount.getInstance(getAmountValue());
    }

    private Round getRound() {
        return Round.getInstance(getRoundValue());
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
