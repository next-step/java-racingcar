# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 3단계 기능목록 구현
1. 프로그램의 주요 골격 및 pseudo code 작성
    - RacingGame 클래스 : 게임 실행 부
    - InputView 클래스 : 사용자 입력을 받는 클래스
    - ResultView 클래스 : 게임의 결과를 출력하는 클래스
    - InputResult 클래스 : 입력 결과를 담는 클래스
    - GameResult 클래스 : 게임 결과를 담는 클래스
    - RacingSimulator 클래스 : InputResult를 받아 게임을 실행하고 GameResult를 담는 클래스 
    - Car 클래스 : 자동차 정보를 담는 클래스
    - GameRandom 클래스 : Random 숫자를 구해서 4이상의 숫자인지 여부를 판단하는 메소드가 있는 유틸클래스
    
2. 사용자 입력부 구현(InputView를 통해 InputResult객체를 반환)
3. 입력값을 토대로 실제 게임 시뮬레이션 구현 및 결과 반환
4. 게임 결과를 출력
5. 코드 점검 후 리펙토링
6. 테스트 코드 작성