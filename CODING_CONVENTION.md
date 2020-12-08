# Coding Convention
우리는 3가지 언어에 대해 coding convention을 정해 두었습니다.
이를 통해 우리는 코드를 **일관성 있게** 할 수 있고, 이는 다른 사람들이 코드를 이해하기 쉽게 만들어 이후의 기여나 버그 픽스에 도움을 줄 것입니다.😊
* [Python](#python)
* [C++](#c)
* [Java](#java)

## Python
Python code convention은 [여기](https://www.python.org/dev/peps/pep-0008/)를 참고해주세요.

Exception
* indent는 tab을 사용해주세요.
* string은 "", ''이 아닌 ""으로 통일해주세요.
* 같은 module, library는 한줄에 import해주세요.

## C++

* 우리는 자동 포맷팅을 위해 Visual Studio의 포맷팅 스타일을 따릅니다. C++로 작성된 코드를 기여하기 전, 해당 포맷팅을 자동 정렬을 통해 적용해 일관성 있는 코드를 만들어 주세요!
* 이름 규칙은 [Google C++ Style Guide](https://google.github.io/styleguide/cppguide.html#Naming)을 따릅니다.
	```c++
	// 간단한 예시
	int current_number;	//variable name
	AddPriorValue();	//function and class name
	const int DEFAULT_SIZE = 10;	//constant name
	```

## Java
* 자세한 내용은 [오라클 공식 문서](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)를 참고해 주세요.
* 패키지 이름은 제거해서 올려 주세요.
	``` Java
	// Do
	import java.io.*;	
	public class Main {
	}
	
	// Do not
	package package_name;
	import java.io.*;	
	public class Main {
	}
	```
* 선언문은 한 줄에 하나만 작성해 주세요.
	``` Java
	// do
	int a;
	int b;
	// do not
	int a, b;
	```
