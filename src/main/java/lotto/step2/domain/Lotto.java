package lotto.step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int LOTTO_NUMBER = 6;
    private static final int LOTTO_HEAD_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

    private List<Integer> lotto;

    public Lotto() {
        this.lotto = createLotto();
    }

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public List<Integer> createLotto() {
        List<Integer> lottoList = IntStream.rangeClosed(LOTTO_HEAD_NUMBER, LOTTO_LAST_NUMBER).boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoList);
        return lottoList.subList(0, LOTTO_NUMBER)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
