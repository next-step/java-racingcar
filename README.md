# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## Step3 - 자동차 경주
### 구현할 기능 목록
+ 자동차 수와 시도할 회수를 입력받는다
+ 0~9까지 Random 값을 생성한다
+ 전진이 가능한지 체크한다
    + random 값이 4이상이면 전진
    + random 값이 4미만이면 정지
+ 자동차의 상태를 출력한다

### 구현한 클래스 설명
+ domain
    + MovingStrategy : 전진 전략 인터페이스 
        + RandomMovingStrategy : 전진 전략 구현 클래스 (랜덤)
           + 랜덤 숫자를 만들고 4이상이면 isMove() -> True
           + 랜덤 숫자를 만들고 4미만이면 isMove() -> False
    + RandomGenerator : 0~9까지 Random 숫자를 뽑아준다
    + Car : 자동차 클래스 
        + 이동한다
        + 현재 위치를 가진다
    + Cars : 자동차 클래스의 묶음 (일급컬렉션)
        + 자동차 개수만큼 가진다
        + 모든 자동차를 전진 전략에 따라 이동시킨다

+ view
    + InputView : 뷰 메시지 입력/출력 담당자
        + 자동차의 대수를 물어본다
        + 시도할 회수를 물어본다
    + OutputView
        + 실행 결과를 보여준다 
        + 자동차의 움직임을 보여준다
    + CarController : 입력을 받아서 출력을 해준다

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
