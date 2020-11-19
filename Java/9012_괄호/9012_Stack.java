import java.util.Scanner;
import java.util.Stack;

public class P9012 {
	public static void main (String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			int right = 0;
			stack.clear();
			String str = scan.next(); //��ȣ �Է�
			for(int k=0; k<str.length(); k++) {
				char now = str.charAt(k);
				switch(now) {
				case '(':
						stack.push('(');
						break;
				case ')':
					if(!stack.empty()) {
						stack.pop();
					} else {
						//������ ��������� �߸��� ��
						right = -1;
					}
					break;
				}
			}
			if(stack.empty() && right == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
