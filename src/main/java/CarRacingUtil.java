import java.util.*;

public class CarRacingUtil {
    /*
      - 변수 설명
        - randomBound : 램덤 숫자 범위
      - 결과 값
        - Integer randomNumber : 서로다른 램덤 숫자
      - 기능 설명
        - randomBound 받아 해당 자리수
    */
    private Integer getRandomNumber(Integer randomBound) {
        Integer randNumber = null;
        Random randomNum = new Random();

        if (randomBound == 0) {
            return null;
        }

        randNumber = randomNum.nextInt(randomBound);

        return randNumber;
    }

    /*
      - 변수 설명
        - carNames : 자동차 이름들
        - splitDelimiter : 구분자
        - nameLengthLimit : 생성 이름 최대 길이
      - 결과 값
        - Integer carValidityToInt
          : 1 - carName이 carNameLengthLimit 이상
          : 2 - 동일한 carName이 존재
          : 3 - 자동차 이름들 유효성 정상
      - 기능 설명
        - carName을 splitDelimiter 값으로 자동차 이름들을 추출하여
          자동차 이름의 길이가 nameLengthLimit 이상이 되는 지, 동일한 자동차
          이름이 있는 지에 대한 유효성 체크
     */
    private Integer checkCarNameValidity(String carNames, String splitDelimiter, Integer nameLengthLimit) {
        Integer carValidityToInt = null;
        String[] carNameList = null;

        if (carNames == null || carNames.trim().isEmpty() == true || splitDelimiter == null
                || splitDelimiter.trim().isEmpty() == true || nameLengthLimit == null || nameLengthLimit == 0 ||
                carNames.equals(splitDelimiter) == false) {
            return null;
        }

        carNameList = carNames.split(splitDelimiter);

        for (int i = 0; i < carNameList.length; i++) {
            String carName = carNameList[i];

            if (carName.length() >= nameLengthLimit) {
                return 1;
            } else {
                for (int j = 0; j < carNameList.length; j++) {
                    String carDiffName = carNameList[j];
                    if (i != j && carName.equals(carDiffName) == true) {
                        return 2;
                    }
                }
            }
        }

        carValidityToInt = 3;

        return carValidityToInt;
    }

    /*
      - 변수 설명
        - carNames : 자동차 이름들
        - splitDelimiter : 구분자
        - nameLengthLimit : 생성 이름 최대 길이
      - 결과 값 및 기능 설명
        - List<String> carNameList
          : carNames을 checkCarNameValidity를 통해 유효성을 체크를 한후
          carNameSplitDelimiter로 구분된 carNameList를 출력
     */
    public List<String> getCarNameList(String carNames, String splitDelimiter, Integer nameLengthLimit) {
        List<String> carNameList = null;
        Integer nameValidityInt = null;

        nameValidityInt = checkCarNameValidity(carNames, splitDelimiter, nameLengthLimit);

        if (nameValidityInt != null && nameValidityInt != 3) {
            String[] tempCarNames = null;

            carNameList = new ArrayList<>();
            tempCarNames = carNames.split(splitDelimiter);

            for (String tempCarName : tempCarNames) {
                carNameList.add(tempCarName);
            }
        } else if (nameValidityInt == 1) {
            System.out.println("입력하신 자동차 이름의 길이가 " + nameLengthLimit + "가 넘습니다.");
        } else if (nameValidityInt == 2) {
            System.out.println("동일한 자동차 이름이 있습니다.");
        }

        return carNameList;
    }

    /*
      - 변수설명
        - Map<String, Integer> carRacedScope : 자동차 별 경기 전 레이싱 점수
        - Integer forwardLimit : 앞으로 가기 위한 조건
        - randomBound : 램덤 숫자 범위
      - 결과 값
        - Map<String, Integer> carRacingScope : 자동차 별 경기 후 레이싱 점수
      - 기능 설명
        - 자동차들이 한 바퀴를 경주했는지 안했는지 램덤으로 결과 값을 산출하는 함수
     */
    public Map<String, Integer> runCarRacing(Map<String, Integer> carRacedScope, Integer forwardLimit,
                                             Integer randomBound) {
        Map<String, Integer> carRacingScope = null;
        Iterator<String> carNameKeys = null;

        if (carRacedScope == null || carRacedScope.isEmpty() || forwardLimit == null || forwardLimit == 0) {
            return null;
        }

        carNameKeys = carRacedScope.keySet().iterator();

        while (carNameKeys.hasNext()) {
            String carNameKey = carNameKeys.next();
            Integer goStopValue = getRandomNumber(randomBound);

            if (goStopValue >= forwardLimit) {
                Integer carScope = carRacedScope.get(carNameKey);
                carScope++;
                carRacedScope.replace(carNameKey, carScope);
            }
        }

        return carRacedScope;
    }

    /*
      - 변수설명
        - Map<String, Integer> carRacedScope : 자동차 별 경기 전 레이싱 점수
      - 결과 값
        - List<String> winnerNameList : 경기 우승자 목록
      - 기능 설명
        - 자동차들이 racingLeap 만큼 경기를 한후 경기 결과를
          입력받아 우승한 사람들을 출력
     */
    public List<String> getRacingWinner(Map<String, Integer> carRacedScope) {
        List<String> winnerNameList = null;
        Iterator<String> carNameKeys = null;
        Integer diffScope = null;

        if (carRacedScope == null || carRacedScope.isEmpty()) {
            return null;
        }

        carNameKeys = carRacedScope.keySet().iterator();
        diffScope = 0;

        while (carNameKeys.hasNext()) {
            String carNameKey = carNameKeys.next();
            Integer tempRacedScope = null;

            tempRacedScope = carRacedScope.get(carNameKey);

            if (diffScope < tempRacedScope) {
                winnerNameList = new ArrayList<>();
                winnerNameList.add(carNameKey);
            } else if (diffScope == tempRacedScope) {
                winnerNameList.add(carNameKey);
            }
        }
        return winnerNameList;
    }
}
