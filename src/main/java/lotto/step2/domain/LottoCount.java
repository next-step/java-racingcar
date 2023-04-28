package lotto.step2.domain;

public class LottoCount {
    // 원시값을 포장
    private final int lottoCount;
    private static final int DIVISOR = 1000;

    public LottoCount(int price) {
        int lottoCount = (price / DIVISOR);
        if (lottoCount <= 0) {
            throw new IllegalArgumentException(price+"원으로는 로또를 구매할 수 없습니다.("+DIVISOR + "원 미만 구매 불가)");
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
