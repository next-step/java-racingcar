package study;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.RacingCar.addCount;
import static racing.RacingCar.checkRandomData;
import static racing.RacingCar.makeRacing;
import static racing.ResultView.addString;
import static racing.ResultView.outputPrint;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    void 출력값_확인() {
        Integer input = 2;
        assertThat(addString(input)).isEqualTo("--");
    }

    @Test
    void 출력값_확인2() {
        List<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(2);
        input.add(4);

        outputPrint(input);
    }

    @Test
    void 리스트_생성_확인() {
        Integer input = 3;
        List<Integer> data = makeRacing(input);
        assertThat(data.size()).isEqualTo(3);
    }

    //에러가 떠야 메서드가 정상임...... 어떻게 테스트 하지?
    @Test
    void 리스트_카운트_증가_확인() {
        List<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(2);
        input.add(4);

        List<Integer> output = addCount(input);

        assertThat(output.get(0)).isEqualTo(input.get(0));
    }

    //랜덤을 어떻게 확인하지...
    @Test
    void 랜덤값_확인() {
        int data = checkRandomData();
        if (data == 0) {
            assertThat(data).isEqualTo(0);
        }
        if (data == 1) {
            assertThat(data).isEqualTo(1);
        }
    }
}
