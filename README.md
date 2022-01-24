# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 계산기 기능 목록
- 연산 요소(숫자와 연산자들) 생성 객체 -ElementGenerator
  - [x] 입력값이 NULL 이거나 빈 공백 문자일 경우 예외처리 -validateEmpty
  - [x] String을 공백 기준으로 Split해서 String[]인 elements 생성 -createElements
  - [x] 사칙연산이 아닌 기호가 있을 때 예외처리 -validateCorrectOperator
- 계산기 겍체 -Calculator
  - [x] 반복문을 통한 전체 계산 실행 -execute
  - [x] 사칙연산 기호에 따른 개별 연산 실행 -calculate
- 연산자 객체 - Operator
  - [x] +, -, *, /의 사칙연산 메소드 구현 

## 자동차 경주 기능 목록
- 차 생성 CarGenerator
  - [x] 자동차 수와 이름 입력 받아 자동차 리스트 생성
- 차 클래스 Car
  - [x] 자동차 이름 길이 확인
  - [x] 이동 가능 여부 확인
  - [x] 이동
  - [x] 현위치 출력
- 경주 클래스 Racing
  - [x] 라운드 횟수 입력 받기
  - [x] 라운드 수만큼 레이스 실행
- 판단 클래스 Judgement
  - [x] 최종 결과 출력