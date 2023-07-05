# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

----
# 문자열 덧셈 계산기
## 기본 기능
- [x] 쉼표 또는 클론을 구분자로 가지는 문자열을 합으로 반환 (“” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
## 추가 기능
- [x] “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용 ("//\;n1;2;3")

## 예외
- [x] 숫자 이외의 값, 음수 전달 시 RuntimeException throw

----
## 기능 요구 사항

### 입력

- 경주할 자동차 이름. (쉼표로 구분 : pobi,woni,jun)
    - [x] 5자 이하만 가능
- 시도할 횟수 (예 : 5)
    - [x] 양수만 가능

### 로직

- 자동차는 전진한다
    - [] 전진 조건 : 0-9 random 값.
    - []4이상 전진, 3이하 멈춤
- 우승자 선발
    - []우승자는 가장 많이 이동한 사람
    - []우승자 한명 이상 가능

### 출력

- 게임이 끝난 후, 우승자들 출력
- 매 실행 결과, 자동자 이동 출력 
