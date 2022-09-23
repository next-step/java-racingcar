package model;

/**
 * Created by P-161 at : 2022-09-23
 *
 * 여기에 GameParam 클래스에 대한 설명을 기술해주세요
 *
 * @author P-161
 * @version 1.0
 * @since 1.0
 */
public class GameParam {

    private final int carNum;

    private final int tryNum;

    public GameParam(int carNum, int tryNum) {
        this.carNum = carNum;
        this.tryNum = tryNum;
    }

    public int getCarNum() {
        return carNum;
    }

    public int getTryNum() {
        return tryNum;
    }
}