package racing;

public class Roulette {

    public final int spin() {

        // 1 ~ 9 사이의 값을 리턴
        return (int) (Math.random() * 9 + 1);
    }
}
