package racing.view;

import java.util.List;

public class InputView {

    public List<String> getNames() {
        return InteractiveInputUtils.getListOfString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", ",");
    }

    public int getRound() {
        return InteractiveInputUtils.getInt("시도할 회수는 몇 회 인가요?");
    }

}
