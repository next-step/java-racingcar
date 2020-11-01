## 목표
초간단 자동차 경주 게임 구현

## 기능 목록 및 commit 로그 요구사항
기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.

### 기능 목록
1. 입력 하는 기능(InputView)
    - 자동차 대수 numberOfCars
    - 이동 횟수 numberOfMoves
    
1. 입력값이 0 이하 이면 예외를 일으키는 기능과 테스트

1. from 값 to 값 사이에서 int random 값 반환 -> 랜덤 값이 0에서 9이하의 int 인지 테스트
     
1. 전진할 지 멈출지 판단하는 기능 (random 값이 4이상일 경우 전진)
1. 차를 전진하는 기능
1. 각각의 횟수마다 자동차의 상태를 화면에 출력하는 기능 (ResultView)

### 조합
1. 자동차 대수, 이동 횟수 입력 하는 기능(InputView)
1. 자동차 대수, 이동 횟수 입력값이 각각 0 일 때 예외를 일으킵니다.
1. 이동 횟수만큼 반복문을 수행
    - 각 자동차별 0 ~ 9 사이의 랜덤 값을 발생 
    하면서 각 자동차의 동작을 결정한 후 화면에 반영합니다.



### [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
git 의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
```
feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain)
```

## [자바 코드 컨벤션 리팩토링](https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596)