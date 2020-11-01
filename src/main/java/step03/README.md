## 목표
초간단 자동차 경주 게임 구현

## 기능 목록 및 commit 로그 요구사항
기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.

1. 입력 하는 기능(InputView)
    - 자동차 대수 numberOfCars
    - 이동 횟수 numberOfMoves
    
1. `numberOfCars`  0 일 때 예외를 일으킵니다.
1. `numberOfMoves` 0 일 때 예외를 일으킵니다.
     
1. 이동 횟수동안 반복문을 수행하는 기능
1. 0에서 9 사이에서 random 값을 구하는 기능
1. 전진할 지 멈출지 판단하는 기능 (random 값이 4이상일 경우 전진)
1. 차를 전진하는 기능
1. 각각의 횟수마다 자동차의 상태를 화면에 출력하는 기능 (ResultView)


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