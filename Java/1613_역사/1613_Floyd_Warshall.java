import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); // 사건의 개수
		int relation = sc.nextInt(); // 사건의 전후 관계 수
		
		int history[][] = new int[num+1][num+1];
		
		for(int i=0; i<relation; i++) {
			int front = sc.nextInt(); // 먼저 일어난 사건
			int rear = sc.nextInt(); // 후에 일어난 사건
			history[front][rear] = 1;
		}
		
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=num; j++) {
				for(int k=1; k<=num; k++) {
					if(history[i][k] == 1 && history[k][j] == 1) {
						history[i][j] = 1;
					}
					if(history[num-i+1][k] == 1 && history[k][num-j+1] == 1) {
						history[num-i+1][num-j+1] = 1;
					}
				}
			}
		}
		
		int question = sc.nextInt(); // 전후 관계를 알고 싶은 사건 쌍의 수
		for(int i=0; i<question; i++) {
			int front = sc.nextInt();
			int rear = sc.nextInt();
			
			if(history[front][rear] == 1) {
				// 앞에 있는 사건이 먼저 일어남
				System.out.println(-1);
			}
			else if(history[rear][front] == 1) {
				// 뒤에 있는 사건이 먼저 일어남
				System.out.println(1);
			}
			else {
				// 유추할 수 없음
				System.out.println(0);
			}
		}
	}
}
