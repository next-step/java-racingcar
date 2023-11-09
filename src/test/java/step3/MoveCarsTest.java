package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MoveCarsTest {

    @ParameterizedTest
    @CsvSource(value = {"5:abc,def,hig,lmn", "6:aaa,bbb,ccc,ddd,eee,fff"}, delimiter = ':')
    void process(int turnCount, String carNames) {
        MoveCars moveCars = new MoveCars(turnCount, 4);
        MoveCarStatus moveCarStatus = new MoveCarStatus(CarName.splitCarNames(carNames), 0, 4);
        moveCars.process(moveCarStatus, new ResultView());
        moveCarStatus.getCars().forEach((car) -> {
            assertThat(car.getPosition()).isBetween(0, turnCount);
        });
    }
}