# Python
Python code convention lead follow things.   
<https://www.python.org/dev/peps/pep-0008/>

exception
1. indent : 4 space --> 1 tab
2. string : "", '' --> unify ""   
	ex) stringFormat = 'It is style guide' (x)   
	    stringFormat = "It is style guide" (o)
3. not import one line with more 2 things --> 2 more things ok if same modules   
	ex) import os   
	    import sys (x)   
	    import os, import sys (o)
4. classname, all variable name using camelcase ---> classname must be start uppercase, variable must be start lowercase   
	ex) def ClassName: (o)   
	    def className: (x)   
	    VariableName (x)   
	    variableName (o)   

