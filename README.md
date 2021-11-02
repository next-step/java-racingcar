# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 목록
- Input view 구현
    - Input 받은 값 validation(null check, 숫자 값 체크)
    - Input 받은 값 전달 객체(RuleDto) 생성 후 return
- RuleDto 구현
  - from(Long count, Long time) 정적 팩토리 메서드 구현
  - getCount() 구현
  - getTime() 구현
- Input Validator Util 구현
  - null check 구현
  - string null or empty 구현
  - isNumber() 구현
- Game 구현
  - RuleDto를 통해 Game 생성
  - Game 생성 시 RuleDto validation  
  - Game 전체 실행 메서드 구현
  - 1초 메서드 step() 구현
- Car 구현
  - 랜덤 값을 통해 갈 수 있는지 없는지 판별하는 메서드 isGo 구현
  - moveOrStop() 함수 구현
  - move() 함수 구현
- Result view 구현
  - ResultDto를 받으면 순서대로 프린트 한다.