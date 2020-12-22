import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int num = Integer.parseInt(br.readLine());

		int input[] = new int[num];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < num; i++) {
			int a = Integer.parseInt(st.nextToken());
			input[i] = a;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int result[] = new int[num];
		
		for(int i = num-1; i >= 0; i--) {
			if(stack.isEmpty()) {
				result[i] = -1;
			}else {
				if(stack.peek() > input[i]) {
					result[i] = stack.peek();
				}else {
					while(stack.peek() <= input[i]) {
						stack.pop();
						if(stack.isEmpty()) {
							break;
						}
					}
					if(stack.isEmpty()) {
						result[i] = -1;
					}else {
						result[i] = stack.peek();
					}
				}
			}
			stack.push(input[i]);
		}
		
		for(int i = 0; i < num; i++) {
			sb.append(result[i] + " ");
		}
		System.out.println(sb.toString());
	}

}
