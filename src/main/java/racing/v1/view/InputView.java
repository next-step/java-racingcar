package racing.v1.view;

import racing.v1.util.IntegerInputHandler;

public class InputView{
    public int getCarCount(){
        return getCarCount("");
    }
    public int getCarCount(String extraComment){
        System.out.println("자동차 대수는 몇 대 인가요? " + extraComment);
        String carCount = IntegerInputHandler.scan();
        if(IntegerInputHandler.validate(carCount)){
            return Integer.parseInt(carCount);
        }
        return getCarCount("0 이상의 숫자를 입력해주세요.");
    }

    public int getMoveCount(){
        return getMoveCount("");
    }
    public int getMoveCount(String extraComment){
        System.out.println("시도할 회수는 몇 회 인가요? " + extraComment);
        String moveCount = IntegerInputHandler.scan();
        if(IntegerInputHandler.validate(moveCount)){
            return Integer.parseInt(moveCount);
        }
        return getCarCount("0 이상의 숫자를 입력해주세요.");
    }
}
