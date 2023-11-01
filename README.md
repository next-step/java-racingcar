# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


# 문자열 덧셈 계산기

### 요구사항

1. 사용자가 특정 문자열를 입력하면 더해져야 합니다.
2. 빈 문자열 또는 null 값을 입력할 경우 0 반환합니다.
3. 숫자 하나를 문자열로 입력할 경우 해당 숫자 반환합니다.
4. 사용자는 커스텀 구분자를 입력할 수 있고 기본 구분자는 ","입니다.
5. 커스텀 구분자는 “//”와 “\n” 문자 사이에 지정할 수 있습니다.
6. 음수를 전달할 경우 RuntimeException이 발생합니다.

### 기능순서도
1. `UserNumbers`에 문자열 인풋
2. `UserNumber`가 문자를 확인
   - empty, null은 0(UserNumber)
   - 한자리면 해당 숫자 (UserNumber)
3. `Delimiter`가 문자열에서 구분자를 거릅니다.
4. `StringDelimiter`가 문자열에서 구분자를 제외하고 파싱합니다.
   - 구분자가 없으면 기본 구분자로 파싱
   - 구분자가 있으면 구분자를 이용해 파싱
5. 문자 유효성 검사는 어디서 해야할까 고민중입니다. 🤔
6. UserNumbers가 덧셈
   - UserNumber를 List로 들고 있고 이걸 순회하면서 덧셈
7. 결과 아웃풋 (StringAddCalculator)

### 개발을 하면서
🤔도대체 어떻게 해야 각각의 객체들이 능동적으로 계산을 할 수 있을까 많은 고민을 하는 중입니다.
클래스는 객체의 능동적인 관리자라는 문구에 사로잡혀 있습니다.
사용자의 문자열들이 스스로 계산을 한다는게 아직 어렵네요.. 🥲


### 이상적인 형태
```java
public class StringAddCalculator {
    public static int splitAndSum(String origin) {
        return UserNumbers(origin).sum().result();
    }
}
```
해당 문서에서 영감을 얻었습니다.
[TDD - 이름짓기](https://edu.nextstep.camp/s/twbNYuxs/ls/yGGywvSB)

