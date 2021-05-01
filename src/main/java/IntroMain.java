import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IntroMain {

    public static void main(String[] args){
        String inputCarNames = null;
        char[] forwardStr = null;
        List<String> carNameList = null, winnerList = null;
        Map<String, Integer> carScopeMap = null;
        CarRacingGameVO gameVO = new CarRacingGameVO();
        CarRacingUtil racingUtil = new CarRacingUtil();
        Scanner sc = new Scanner(System.in);

        System.out.println("[프리코스 자동차 경주게임]");
        System.out.println("사용자가 입력한 자동차들끼리 경주를 하여");
        System.out.println("그 자동차들 중 승리자를 가리는 게임입니다.\n");

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        inputCarNames = sc.next();

        System.out.println("시도할 횟수는 몇회인가요?");
        gameVO.setRacingLeap(sc.nextInt());

        carNameList = racingUtil.getCarNameList(inputCarNames, gameVO.getCarNameSplitDelimiter(),
                gameVO.getCarNameLengthLimit());
        carScopeMap = new HashMap<>();
        forwardStr = new char[gameVO.getRacingLeap()];

        for(String carName : carNameList){
            carScopeMap.put(carName, 0);
        }

        System.out.println("실행 결과");
        
        for(int i = 0; i < gameVO.getRacingLeap(); i++){
            forwardStr[i]='-';
            carScopeMap= racingUtil.runCarRacing(carScopeMap, gameVO.getCarForwardLimit(),
                    gameVO.getCarForwardStopRandomBound());

            for(int j = 0; j < carNameList.size(); j ++){
                if(carScopeMap.get(carNameList.get(j)) > 0){
                    System.out.println(carNameList.get(j) + " : " +
                            new String(forwardStr, 0, carScopeMap.get(carNameList.get(j))));
                } else{
                    System.out.println(carNameList.get(j) + " : ");
                }
            }
            System.out.println("");
        }


        winnerList = racingUtil.getRacingWinner(carScopeMap);
        for(int i = 0; i < winnerList.size(); i++){
            System.out.print(winnerList.get(i));

            if(i!=winnerList.size() && winnerList.size() !=1){
                System.out.print(",");
            }
        }

        System.out.println("가 최종 우승했습니다.");
    }
}
