package racingcar.view;

import org.junit.Test;

import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    public void 숫자_입력_테스트() {
        Scanner scanner = new Scanner("5");
        int tryCount = InputView.getTryCount("숫자를 입력하세요. ", scanner);

        assertThat(tryCount).isEqualTo(5);
    }

    @Test
    public void 문자열_입력_후_스트링배열_반환_테스트() {
        Scanner scanner = new Scanner("pobi,crong,honux");
        List<String> names = InputView.getCarNames("경주할 자동차 이름을 입력하세요.(쉼표로 구분) ", ",", scanner);

        assertThat(names.get(0)).isEqualTo("pobi");
        assertThat(names.get(1)).isEqualTo("crong");
        assertThat(names.get(2)).isEqualTo("honux");
    }
}
