package lotto.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(LottoStrategy lottoStrategy, LottoCount lottCount) {
        this.lottos = createLottos(lottoStrategy, lottCount);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> createLottos(LottoStrategy lottoStrategy, LottoCount lottCount) {
        List<Lotto> lottoList = new ArrayList<>();
        IntStream.range(0, lottCount.getLottoCount())
                .forEach(i -> lottoList.add(new Lotto(lottoStrategy.createLotto().getLotto())));
        return lottoList;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
