package study.step3;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

public class RacingTest {

    @Test
    void 자동차_경주_테스트() {
        MockedStatic<InputView> randoms = mockStatic(InputView.class);
        int cars = 3;
        int moves = 5;
        Rule rule = new Rule(cars, moves);
        given(InputView.loadRule()).willReturn(rule);

        System.out.println("자동차 대수는 몇 대 인가요?");
        System.out.println(cars);
        System.out.println("시도할 회수는 몇 회 인가요?");
        System.out.println(moves);
        
        Racing.start();
    }
}
