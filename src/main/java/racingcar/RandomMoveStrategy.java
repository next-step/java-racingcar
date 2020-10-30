/**
 * 클래스 이름: RandomMoveStrategy
 * 버전 정보: 0.1
 * 날짜: 2020.10.30
 * 저작권 주의: 없음
 */

package racingcar;

public class RandomMoveStrategy implements MoveStrategy {
    RandomGenerator random;

    public RandomMoveStrategy() {
        this.random = RandomGenerator.getInstance();
    }

    @Override
    public boolean proceed() {
        int randomNum = this.random.getRandomNum();
        return randomNum >= 4;
    }
}
