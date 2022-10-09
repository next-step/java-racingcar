package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @Test
    void convertNameList_null_or_빈문자() {
        assertThatThrownBy(() -> InputView.convertNameList(null))
                .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> InputView.convertNameList(""))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void convertNameList_이름하나() {
        String inputName = "shineyuno";
        List<String> nameList = InputView.convertNameList(inputName);

        assertThat(nameList).hasSize(1);
        assertThat(nameList.get(0)).isEqualTo(inputName);
    }

    @Test
    public void convertNameList_이름여러개() {
        String inputName = "shineyuno,bingbingpa";
        List<String> nameList = InputView.convertNameList(inputName);

        assertThat(nameList).hasSize(2);
        assertThat(nameList.get(0)).isEqualTo("shineyuno");
        assertThat(nameList.get(1)).isEqualTo("bingbingpa");
    }
}
