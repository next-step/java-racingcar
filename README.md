# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 2차 피드백 및 반영사항

1. 사용하지 않는 import 제거
2. size()를 사용하는 경우 isEqualTo 대신 hasSize 사용하여 테스트
3. RacingApplication에서 불필요한 생성자 제거
4. ExceptionHandler를 try-catch구문으로
5. Random용어 수정
6. 일급컬렉션 적용
7. 예외 발생 테스트 추가

## 문자열 계산기 - 구현할 기능 목록

1. 각 숫자의 합을 반환
2. 쉼표 또는 콜론을 구분자로 가짐
3. "//?\n"을 통해 커스텀 구분자 사용
4. 문자열 계산기에 숫자이외의 값 혹은 음수가 전달된 경우 RuntimeException Throw

## 자동차 경주 - 구현할 기능 목록

1. 자동차 객체
    - [X] 전진
2. 모델
    - [X] 자동차들 한 틱씩 전진시키기
    - [X] 우승자 판별 및 배열 반환
    - [X] 전진할지 판별
    - [X] 시뮬레이션
3. 입력
    - [X] 자동차 이름 입력 받아 자동차 객체 배열로 반환
    - [X] 시행 횟수 입력 받아 정수형으로 반환
4. 뷰
    - [X] 자동차 이름 입력 설명
    - [X] 시행 횟수 입력 설명
    - [X] 실행 결과 텍스트
5. 출력
    - [X] 생성된 뷰 출력
6. 랜덤
    - [X] 랜덤한 0이상 9이하의 정수 반환
7. 메인
    - [X] 실행

## 커밋 컨벤션

```agsl
<commit_type>: <commit_msg>
```

커밋 타입은 아래 5개 중 1가지로 함

- `test`
- `feature`
- `refactor`
- `fix`
- `chore`

## 1차 피드백 및 반영사항

1. Calculator의 RuntimeException에서 어떤 예외가 발생했는지를 메세지에 담아서 던지도록 수정
2. Car의 goForward에서 전진 여부 결정 로직을 외부로 분리
3. 어플리케이션 동작 중 던져진 예외를 처리하도록 RacingExceptionHandler와 커스텀 예외를 위한 RacingBaseException 추가
4. 테스트를 위한 SpecficNumberGenerator를 테스트 소스셋으로 이동
5. RacingManager의 프로덕션용 생성자는 하나였기에 사용되지 않는 생성자 제거 및 테스트에 반영
6. RacingManager의 isMovable 등 외부클래스에서 사용하지 않는 메서드들 private으로 수정
7. assertThat등을 import하던 와일드카드 import 수정
8. 여러 인수를 테스트하는 경우 ParameterizedTest 사용하도록 수정 및 모든 케이스 대신 엣지 케이스만 테스트하도록 수정
