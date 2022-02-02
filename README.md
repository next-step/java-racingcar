# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

### 문자열 계산기 기능 목록
- 입력값 검사, 숫자와 연산자로 분리 #ElementGenerator
  - Null, Empty, 사칙연산 기호 검사
  - LinkedList로 된 숫자 리스트와 연산자 리스트 생성
- 전체 계산을 실행 #Calculator
  - 숫자 리스트와 연산자 리스트를 사용하기 쉽게 가공 (String 타입의 숫자 리스트를 Double 타입으로 변경)
  - 두 리스트에서 하나씩 값을 뽑아서 Operator에게 연산 위임 #execute()
- 각각의 연산 실행 -Operator
  - 사칙기호를 입력받아서 관련 연산 기계를 찾기 #operatorOf()
  - 연산 후 결과 반환 #apply()

### 자동차 경주 기능 목록
- 차 생성 CarGenerator
  - 자동차 수와 이름 입력 받아 자동차 리스트 생성
- 차 클래스 Car
  - 자동차 이름 길이 확인
  - 이동 가능 여부 확인
  - 이동
  - 현위치 출력
- 경주 클래스 Racing
  - 라운드 횟수 입력 받기
  - 라운드 수만큼 레이스 실행
  - 랜덤 값 생성
- 판단 클래스 Judgement
  - 최종 결과 출력
