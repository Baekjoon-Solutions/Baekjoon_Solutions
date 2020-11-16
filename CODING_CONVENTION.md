# Coding Convention
We decided on a coding convention for the three languages.   
With these coding conventions, we can make code **consistent way**. It helps others to understand code more easily!
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

* We use [clang-format](http://clang.llvm.org/docs/ClangFormat.html) to auto formatting. Before contributing solution written in C++, apply clang formatting to make code constant.
* Naming convention guide follows [Google C++ Style Guide](https://google.github.io/styleguide/cppguide.html#Naming).
	```c++
	// here is simple and common examples of naming
	int current_number;	//variable name
	addPriorValue();	//function and class name
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
