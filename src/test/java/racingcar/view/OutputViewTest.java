package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.RandomMoveStrategy;
import racingcar.dto.RacingGameDto;
import racingcar.util.FixedRandomGenerator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private static final int ALWAYS_MOVE = 4;

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream captured = new ByteArrayOutputStream();

    @BeforeEach
    void redirectOut() {
        System.setOut(new PrintStream(captured));
    }

    @AfterEach
    void restoreOut() {
        System.setOut(originalOut);
    }

    @Test
    void 자동차_이름과_위치를_함께_출력한다() {
        Cars cars = Cars.fromNames(List.of("pobi"));
        RandomMoveStrategy alwaysMove = new RandomMoveStrategy(new FixedRandomGenerator(ALWAYS_MOVE));
        cars.moveCars(alwaysMove);
        cars.moveCars(alwaysMove);

        OutputView.printRoundResult(RacingGameDto.from(cars));

        assertThat(captured.toString()).contains("pobi : --");
    }

    @Test
    void 우승자가_한_명이면_이름을_출력한다() {
        OutputView.printWinners(List.of("pobi"));

        assertThat(captured.toString()).contains("pobi 가 최종 우승했습니다.");
    }

    @Test
    void 우승자가_여러_명이면_쉼표로_구분해_출력한다() {
        OutputView.printWinners(List.of("pobi", "honux"));

        assertThat(captured.toString()).contains("pobi, honux 가 최종 우승했습니다.");
    }
}