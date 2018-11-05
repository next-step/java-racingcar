package racing;

import java.util.List;

public interface Game {

    /**
     * 게임을 시도할 카운트가 남아 있는지
     */
    boolean hasTryCount();

    /**
     * 시작
     */
    void start();

    /**
     * 목록 가져오기
     *
     * @return List<Car>
     */
    List<Car> getList();

}
