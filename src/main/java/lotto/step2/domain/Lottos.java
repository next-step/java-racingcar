package lotto.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private List<List<Integer>> lottos;

    public Lottos(Lotto lotto, LottoCount lottCount) {
        this.lottos = createLottos(lotto, lottCount);
    }

    public Lottos(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    private List<List<Integer>> createLottos(Lotto lotto, LottoCount lottCount) {
        List<List<Integer>> lottoList = new ArrayList<>();
        IntStream.range(0, lottCount.getLottoCount())
                .forEach(i -> lottoList.add(lotto.createLotto()));
        return lottoList;
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }
}
