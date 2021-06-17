Calculator 피드백
================
피드백1 정리 
---------------------
#### 1. 좋은 git 커밋 메시지 작성법
- [심플 코드 작성법은 여기 참고][H]

[H]: https://gist.github.com/stephenparish/9941e89d80e2bc58a153

##### 커밋 메시지 형식
```text
<type>(<scope>): <subject>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```
##### 제목`<type>`
- 제목 줄에는 변경에 대한 간결한 설명이 포함
    - feat (특집)
    - 수정 (버그 수정)
    - 문서 (문서)
    - 스타일 (서식 지정, 세미콜론 누락,…)
    - 리팩터링
    - 테스트 (누락 된 테스트를 추가 할 때)
    - 잡일 (유지)

##### 본문`<subject>`
- 명령형, 현재 시제 사용
- 끝에 점 (.) 없음
##### 메시지 본문`<boby>`
- 명령형, 현재 시제 사용
- 변경에 대한 이유와 변경 이후 사항

<br>

#### 2. 심플한 객체지향코드 작성법
- [객체지향 개념은 여기 참고][O]

[O]: https://www.slideshare.net/plusjune/ss-46109239

- 행위단위로 객체로 정의 한다. 
    - (ex. 입력받는 객체, 연산담당 객체, 출력을하는 객체 등등)
- 요구사항을 만족하도록 객체들 사이에 대화할 규칙을 정의 한다. 
    - (ex "입력받는 객체"가 연산담당객체에게 입력값을 전달한다.)
- 언어 특성에 맞게 잘 구현한다.

##### 객체지향 프로그래밍은
- 객체, 대화규칙을 정하는 것에 따라 유지보수 및 가독성이 좋은 코드가 나오기도하고, 유지보수가 힘들고 읽기 힘든 코드가 만들어지기도 합니다.
- 쉽게 생각하면 객체지향코딩은 객체 블록을 만들어두고 레고처럼 적절하게 배치해 작품을 완성하는 것입니다.

<br>

#### 3. 코드 컨벤션
- [구글 코드 컨벤션 준수하기][A]

[A]: https://velog.io/@new_wisdom/JAVA-Google-Java-Style-Guide-%EB%B2%88%EC%97%AD
```java
// 수정 전
public int add(int a, int b) {return a + b;}
```
```java
// 수정 후
public int add(int a, int b) {
  return a + b;
}
```

<br>

#### 4. 매직넘버는 상수로 설정해서 코드 가독성 높이기
- 매직넘버(코드 안에 작성된 구체적인 숫자 혹은 문자열)로 의미를 명확하게 하기
- 코드에서 상수로 선언되어 있지 않은 숫자, 문자열은 무엇을 의미하는지 파악하기 어려움
- 매직넘버는 상수로 선언하게 됨으로써 이름을 분명히 밝혀주면서 어떠한 역할을 하는지 알 수 있음
```java
// 수정 전 
public String[] inputValue(String input) {
    return input.split(" ");
}
```
```java
// 수정 후
private static final String spiltValue = " ";

public String[] inputValue(String input) {
    return input.split(spiltValue);
}
```

<br>

#### 5. 한 단계의 들여쓰기
- `한 메서드에 오직 한 단계의 들여쓰기` 위배
- 입력값을 처리하는 객체를 만들어 보기
```java
// 수정 전
for (int i = 0; i < testValue.length - 1; i++) {
    if (i % 2 == 1) {
        int aValue = Integer.parseInt(testValue[i - 1]);
        int bValue = Integer.parseInt(testValue[i + 1]);
        String calValue = testValue[i];

        temp2 = calculator.mathSymbol(aValue, bValue, calValue);
        testValue[i + 1] = temp2;
    }
}
```
```java
// 수정 후
for (int i = 1; i < splitValue.length; i += 2) {
    int firstNum = evaluation.convertToNumber(splitValue[i-1]);
    String operatorValue = splitValue[i];
    int secondNum = evaluation.convertToNumber(splitValue[i+1]);

    int temp = evaluation.isOperator(firstNum, operatorValue,secondNum);
    splitValue[i+1] = evaluation.convertToString(temp);
}

return evaluation.convertToNumber(splitValue[splitValue.length - 1]);
}
```

