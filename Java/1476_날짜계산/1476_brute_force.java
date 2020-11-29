import java.util.Scanner;

public class P1476 {
	public static void main (String args[]) {
		Scanner scan = new Scanner(System.in);
		//완전탐색 이용
		int e=1, m=1, s=1; //user input
		int E = scan.nextInt();
		int S = scan.nextInt();
		int M = scan.nextInt();
		
		int year = 1;
		
		while(!(e==E && s==S && m==M)) {
			++e;
			++s;
			++m;
			if(e==16) {
				e=1;
			}
			if(s==29) {
				s=1;
			}
			if(m==20) {
				m=1;
			}
			year++;
		}
		System.out.println(year);
	}
}
