package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Racing implements Game {

    /**
     * 시도 마지막 카운트
     */
    private final int TRY_END_COUNT;

    /**
     * 시도 횟수
     */
    private int tryCount;

    /**
     * 목록
     */
    private final List<Car> list = new ArrayList<>();

    /**
     * 생성자
     *
     * @param carCount int
     * @param tryCount int
     */
    public Racing(final int carCount, final int tryCount) {

        // 시도 종료값 초기화
        this.TRY_END_COUNT = 0;

        this.tryCount = tryCount;

        // 숫자 만큼 리스트 생성
        IntStream.range(0, carCount).forEachOrdered(i -> list.add(new Car()));
    }

    @Override
    public boolean hasTryCount() {
        return tryCount > this.TRY_END_COUNT;
    }

    @Override
    public void start() {
        decreaseTryCount();
        list.forEach(Car::run);
    }

    @Override
    public List<Car> getList() {
        return list;
    }

    /**
     * 시도할 카운트 감소처리
     */
    private void decreaseTryCount() {
        tryCount--;
    }

}
