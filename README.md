# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 구현 목록
* 자동차 경주 게임을 진행할 어플리케이션 구현
* 입력값을 받을 수 있는 InputView 구현
*   - 가독성을 고려한 우발적 중복 활용
* 자동차 인터페이스 구현
*   - 차 이동하는 메서드
*   - 차가 이동한 결과값을 반환하는 메서드
* 경주에 참가하는 자동차 Class 구현
*   - 차가 이동하는 메서드 구현
*     - tryToMove()에 전략적패턴 구현
*   차가 이동한 결과값을 반환하는 메서드 구현
* moveStrategy 인터페이스 구현
*   - default 이동 기준점 저장 x -> constant Class 만듬
*   - default 이동 거리 저장 x -> constant Class 만듬
*   - 이동 판단 메서드 선언
*   - 이동 메서드 선언
* normalMoveStragegy Class 구현
*   - 이동 판단 메서드 구현
*     - random한 정수 값이 이동 기준점 이상일 경우 이동
*   - 이동하는 메서드 구현
* 자동차 객체들을 관리하는 Class 구현
*   - 여러개의 자동차 객체를 생성
* Random 확률 계산하는 객체 구현
* 경주를 진행하는 Racing Class 구현
* 경주 결과를 출력하는 ResultView 구현

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
