package racing;

import java.util.HashMap;

/*
    ########################################################
    운행별 이동횟수 정보가 필요할것 같아서 아래처럼 구현하다보니
    소스 가독성에 문제가 있을것같내요..

    좀더 깔끔하게 구현하고싶은데 다른 해결책이 있을까요?
    ########################################################
 */

public class Car {
    private int tryCount;
    private int moveCount;
    private HashMap<Integer,Integer> moveValues;

    public Car()
    {
        this.tryCount = 0;
        this.moveCount = 0;
        moveValues = new HashMap<Integer,Integer>();
    }

    public void move(final boolean carMoveTrueAndFalse)
    {
        if(carMoveTrueAndFalse)
        {
            moveCount+=1;
        }

        moveValues.put(tryCount,moveCount);
        tryCount++;
    }

    public HashMap<Integer,Integer> getMoveValues()
    {
        return moveValues;
    }
}
