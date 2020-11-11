# Coding Convention
We decided on a coding convention for the three languages.   
Coding conventions help make code easier for multiple people to read.
* [Python](#python)
* [C++](#c)
* [Java](#java)

## Python
Python coding convention lead follow things.   
<https://www.python.org/dev/peps/pep-0008/>

exception
1. indent : 4 space --> 1 tab
2. string : "", '' --> unify ""   
	ex) stringFormat = 'It is style guide' (x)   
	&nbsp;&nbsp;&nbsp;&nbsp;stringFormat = "It is style guide" (o)
3. not import one line with more 2 things --> 2 more things ok if same modules   
	ex) import os   
	&nbsp;&nbsp;&nbsp;&nbsp;import sys (x)   
	&nbsp;&nbsp;&nbsp;&nbsp;import os, import sys (o)
4. classname, all variable name using camelcase ---> classname must be start uppercase, variable must be start lowercase   
	ex) def ClassName: (o)   
	&nbsp;&nbsp;&nbsp;&nbsp;def className: (x)   
	&nbsp;&nbsp;&nbsp;&nbsp;VariableName (x)   
	&nbsp;&nbsp;&nbsp;&nbsp;variableName (o)   

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
