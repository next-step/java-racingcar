package lotto.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> lotto = new ArrayList<>();

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return List.copyOf(lotto);
    }

}
