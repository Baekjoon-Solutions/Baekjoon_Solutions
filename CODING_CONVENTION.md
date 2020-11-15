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
* classname은 대문자, variable은 소문자로 시작해주세요.

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
* Refer to [the official Oracle document](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html).
* Remove the package name.
* Declare only one declaration per line.
	``` Java
	// do
	int a;
	int b;
	// do not
	int a, b;
	```
