# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구 사항

* 주어진 횟수동안 n대의 자동차는 전진 또는 멈출수있다.
* 각 자동차에 이름을 부여할수 있다.전진하는 자동차를 출력할 때 자동차이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자이하만 가능하다.
* 사용자는 몇번의 이동을 할것인지를 입력할 수 있어야한다.
* 전진하는 조건은 0에서 9사이에서 random값을 구한 후 random값이 4이상 일경우 전진하고, 3이하의값이면멈춘다.
* 자동차 경주게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

## 클래스정의

* IntroMain
    * 설명 : 본 클래스는 실행 시 처음으로 진입하는 클래스이며 사용자의 입력을 받거나 사용자의 입력값을 받거나 입력값에 따른 결과를 출력하는 클래스이다.

    * 함수 정의
        * public static void main(String[] args)
            - 설명 : 본 클래스의 처음으로 진입하는 메인함수


* CarRacingGameVO
    * 설명 : 본 클래스는 상수 값이나 해당 자동차 게임에 필요한 config 값을 저장하는 클래스이다.

    * 상수
        - 상수 값은 "상수 값 정의"에 해당 내용이 들어 있다.

    * 변수 설명
        * racingLeap
            * 변수 타입 : Integer
            * 값 : 변경 가능
            * 설명 : 자동차 랩 수, 자동차가 몆 번을 이동하는 지 횟수

        * carNameLengthLimit
            * 변수 타입 : Integer
            * 값 : 5
            * 설명 : 자동차 생성 제한 길이

        * carNameSplitDelimiter
            * 변수 타입 : String
            * 값 : ,
            * 설명 : 여러 대의 자동차의 이름의 구분자

        * carForwardStopRandomBound
            * 변수 타입 : Integer
            * 값 : 10
            * 설명 : 자동차 전진 및 정지를 하기위해 램덤 값 범위

        * carForwardLimit
            * 변수 타입 : Integer
            * 값 : 4
            * 설명 : 자동차 전진을 하기 위한 조건, carForwardStopRandomBound 가 4 이상이면 전진


* CarRacingUtil
    * 설명 : 본 클래스는 자동차 경주게임에서 사용하는 주요 함수들을 정의된 클래스
  
    * 함수 정의
        * getRandomNumber(Integer randomBound)
            - 변수 설명
                - randomBound : 램덤 숫자 범위
            - 결과 값
                - Integer randomNumber : 서로다른 램덤 숫자
            - 기능 설명
                - randomBound 받아 해당 자리수

        * checkCarNameValidity(String carNames, String splitDelimiter, Integer nameLengthLimit)
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
                - carName을 splitDelimiter 값으로 자동차 이름들을 추출하여 자동차 이름의 길이가 nameLengthLimit 이상이 되는 지, 동일한 자동차 이름이 있는 지에 대한
                  유효성 체크

        * getCarNameList(String carNames, String splitDelimiter, Integer nameLengthLimit)
            - 변수 설명
                - carNames : 자동차 이름들
                - splitDelimiter : 구분자
                - nameLengthLimit : 생성 이름 최대 길이
            - 결과 값 및 기능 설명
                - List<String> carNameList
                  : carNames을 checkCarNameValidity를 통해 유효성을 체크를 한후 carNameSplitDelimiter로 구분된 carNameList를 출력

        * runCarRacing(Map<String, Integer> carRacedScope, Integer forwardLimit)
            - 변수설명
                - Map<String, Integer> carRacedScope : 자동차 별 경기 전 레이싱 점수
                - Integer forwardLimit : 앞으로 가기 위한 조건
                - randomBound : 램덤 숫자 범위
            - 결과 값
                - Map<String, Integer> carRacingScope : 자동차 별 경기 후 레이싱 점수
            - 기능 설명
                - 자동차들이 한 바퀴를 경주했는지 안했는지 램덤으로 결과 값을 산출하는 함수

        * getRacingWinner(Map<String, Integer> carRacedScope)
            - 변수설명
                - Map<String, Integer> carRacedScope : 자동차 별 경기 전 레이싱 점수
            - 결과 값
                - List<String> winnerNameList : 경기 우승자 목록
            - 기능 설명
                - 자동차들이 racingLeap 만큼 경기를 한후 경기 결과를 입력받아 우승한 사람들을 출력
  