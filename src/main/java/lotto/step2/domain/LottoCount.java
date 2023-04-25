package lotto.step2.domain;

public class LottoCount {
    // 원시값을 포장
    private final int lottoCount;
    private final int DIVISOR = 1000;

    public LottoCount(int price) {
        int lottoCount = (price / DIVISOR);
        if (lottoCount <= 0) {
            throw new IllegalArgumentException(DIVISOR + "미만 금액은 구매할 수 없습니다.");
        }
        this.lottoCount = lottoCount;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getPrice(){
        return lottoCount * DIVISOR;
    }
}
