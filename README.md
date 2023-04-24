# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 3단계 과제 - 구현 전 기능 요구 사항 작성 하기 
- [x] 사용자로부터 양수인 정수 값을 입력받는다
- [x] 사용자로부터 양수인 정수가 아닌 값을 입력 받는 경우 3번의 기회 내에서 재시도 요청을 한다 
- [x] "실행 결과" 라는 문자열을 출력한다.
- [x] "자동차 대수는 몇 대 인가요?" 라는 문자열을 출력한다.
- [x] "시도할 회수는 몇 회 인가요?" 라는 문자열을 출력한다.
- [x] 전달 받은 정수 값을 해당 수 만큼 연속한 "-" 의 형태로 출력한다.
- [x] 입력받은 수 만큼의 자동차를 생성한다.
- [x] 입력받은 수 만큼 실행한다. 
- [x] 최소 값 이상 최대 값 이하의 랜덤값을 생성한다
- [x] 생성된 랜덤값은 자신이 특정 값 이상의 값인지 여부를 알려준다
- [x] 자동차 전진 기능
    1. 전달 받는 값에 따라 내부적으로 상태값을 변경한다.
       1. 전진 할 경우 "위치" 에 해당 하는 값을 1 증가시킨다.
- [x] 자동차는 자신의 현재 위치 값을 알려준다.


## 4단계 과제 - 기능 목록
- [x] 입력을 통해 일련의 자동차 이름 리스트를 받는다.
  - [x] 문자열을 콤마를 기준으로 문자열 배열로 파싱한다
- [x] 자동차 생성 시 이름을 갖는다. 
  - [x] 제약조건에 어긋나는 이름 부여시 자동차 생성에 실패한다
- [x] 자동차별 이름과 위치를 출력한다 
- [x] 하나의 RacingGame 객체는 우승 자동차 정보를 갖는다. 
- [x] RacingGame 실행 결과 우승자 정보를 알려준다.
- [x] 일련의 우승자 정보를 출력한다
- [x] 거리에 따라 우승자를 판단한다
