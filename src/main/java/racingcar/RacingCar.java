package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private List<Integer> moves;
    private List<Integer> positions;

    /**
     * 확인할 숫자에 따라 전진 할 수 있는지 아닌지를 반환한다.<br />
     * 숫자가 0~9 사이일 경우 전진할 수 있다.
     *
     * @param num 전진 가능 여부를 결정할 숫자
     * @return boolean
     */
    public static boolean checkCanMove(int num) {
        return num >= 4 && num <= 9;
    }

    RacingCar() {
        moves = new ArrayList<>();
        positions = new ArrayList<>();
    }

    public List<Integer> getMoves() {
        return this.moves;
    }

    public List<Integer> getPositions() {
        return positions;
    }

    /**
     * 이번 회수에서 전진 여부를 랜덤하게 결정한다.
     *
     * @return RacingCar
     */
    public RacingCar makeRandomMove() {
        int randomNum = Util.generateRandomNum(10);
        int move = checkCanMove(randomNum) ? 0 : 1;

        moves.add(move);

        return this;
    }

    /**
     * 현재 상태 까지의 각 회수별 전진 여부 목록을 기준으로, 각 회수별 위치를 계산한다.
     *
     * 최초 시작 위치를 0 으로 시작하는 것과 더불어, 각 회수별 전진 상태와 직전 위치를 더하기 위해
     * 회수별 위치 목록은 회수별 전진 여부 목록보다 한 사이즈 더 크게 처리한다.
     *
     * @return RacingCar
     */
    public RacingCar translateMovesToPositions() {
        this.positions = new ArrayList<>();
        positions.add(0); // position 은 0 부터 시작

        for (int i = 1; i <= moves.size(); i++) {
            positions.add(positions.get(i-1) + moves.get(i-1));
        }

        return this;
    }
}
