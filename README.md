# 자동차 경주 게임

## 기능 명세서
- 자동차 경주 게임을 위한 입출력 UI, 비즈니스 로직을 구현한다.
    - 경주를 위한 자동차, 경기 횟수를 입력받는다.
    - 각 경주마다 자동차의 총 이동 거리를 출력한다.

## Commit Message Convention
```
<type>: <subject>
<body>
<footer>

e.g) feat: add login api (#12)
```

### Type
```
feat : 새로운 기능 추가, 기존의 기능을 요구 사항에 맞추어 수정
fix : 기능에 대한 버그 수정
build : 빌드 관련 수정
chore : 패키지 매니저 수정, 그 외 기타 수정 ex) .gitignore
ci : CI 관련 설정 수정
docs : 문서(주석) 수정
style : 코드 스타일, 포맷팅에 대한 수정
refactor : 기능의 변화가 아닌 코드 리팩터링 ex) 변수 이름 변경
test : 테스트 코드 추가/수정
release : 버전 릴리즈
```

### Subject
- 간략하게 어떠한 작업을 하였는지 작성한다.
    - e.g) feat: 3단계 자동차 경주 기능 구현

### Body
- `Subject`에서 작성하지 못한 상세 설명을 작성한다.

### Footer
- 어떤 이슈에 대한 작업인지 이슈 번호를 작성한다.(#issue번호)