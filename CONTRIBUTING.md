# Contributing
방문해주신 모든 분들을 환영합니다!   
Baekjoon_Solutions에 다음과 같은 방법으로 기여할 수 있습니다.   
* 복잡도를 계산하고, issue를 보고   
* Pull Request 제공(문제 해결 코드, 수정)   
   
이 문서는 issue와 PR에서 기여자가 문제를 처리하기 위해 이 리포지토리에 적용되는 규칙을 설명합니다.   
   
## 새로운 Issue 열기
* issue를 연다는 것은 작성된 복잡도에 문제가 존재하며, 프로젝트 기여자가 수정해야 한다는 것을 의미합니다. 
* issue를 열 때는 제시된 템플릿을 작성해야 합니다. 저희가 요청하는 정보들은 중요합니다! 템플릿이 무시되거나 issue에 대한 불충분한 정보가 제공되면, issue는 종결될 수 있습니다.
* 이미 처리된 주제에 대한 issue는 유사한 방식으로 닫힐 것입니다.   
   
## Pull Requests
Pull Request는 GitHub에서 코드 수정을 관리하는 프로세스입니다.   
과정은 매우 간단합니다.   
1. Baekjoon_Solutions git 리포지토리를 fork 하세요.   
2. fork에서 새로운 문제 해결 코드 등을 작성/변경하세요.   
3. Baekjoon_Solutions의 main branch에 대해 Pull Request를 생성하세요.   
   
Pull Request는 다음 조건을 충족해야 합니다.   
1. commit 내용에 문제의 이름과 번호, 사용된 알고리즘, 메모리, 시간을 명시하세요.
2. 파일 이름은 '언어/문제 번호_문제 이름/문제 번호_알고리즘.확장자' 형식을 맞춰주세요.   
        ex) Java/5243_경우의_수_세기/5243_분류.java
3. Java 파일의 경우에는 패키지 이름을 제거하세요.
4. 이미 solution이 존재하는 문제에 대해서는 commit 내용으로 기존 문제에 대한 기여라고 명시해주세요.   
   
4번의 경우, 시간과 메모리가 우수하거나 다른 solution인 경우에 채택합니다.   
   
위 조건들을 충족하지 못하는 Pull Request는 거부되고 닫히게 됩니다.   
   
   

# Contributing
Everybody is welcome and invited to contribute to Baekjoon_Solutions by:
* Computing complexity and reporting issues.
* Providing Pull Requests (Problem Solving Code, Fixes)   
   
This document describes rules that are in effect for this repository, meant for handling issues by contributors in the issue tracker and PRs.

## Opening New Issues
* Opening an issue means that a problem exists in the complexity and should be modified by the project contributors.
* When opening an issue, it is required to fill out the presented template. The requested information is important! If the template is ignored or insufficient info about the issue is provided, the issue may be closed.
* Issues about topics already handled in the documentation will be closed in a similar manner.

## Pull Requests
A Pull Request is the process where code modifications are managed in GitHub.   
The process is simple.
1. Fork the Baekjoon_Solutions git repository.
2. Write/Change the code in your Fork for new problem solving code, etc.
3. Create a Pull Request against the main branch of Baekjoon_Solutions.
   
Pull Request must meet the following conditions:
1. Specify the name and number of the problem, the algorithm used, memory and time in the contents of the commit.
2. The filename is in the form 'Language/problem number_problem name/problem number_Algorithm.extension'.   
	ex) Java/5243_counting_the_number_of_cases/5243_Classification.java
3. For Java files, remove package name
4. For problems where solutions are already published, state that it is a contribution to the existing problem as a commit content.

In case of number 4, it is adopted when time and memory are excellent or other solutions.   

Pull requests that don't meet the above will be denied and closed.
