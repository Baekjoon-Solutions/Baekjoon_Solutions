import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int object = sc.nextInt();
		int compare = sc.nextInt();
		
		int weight[][] = new int[object+1][object+1];
		
		for(int i=0; i<compare; i++) {
			int heavy = sc.nextInt(); // 더 무거운 애
			int light = sc.nextInt(); // 더 가벼운 애
			weight[heavy][light] = 1;
		}
		
		// 자신이 시작으로 있거나, 자신으로 오거나 하는 게 모든 vertex에 대해서 있으면
		// 자신의 상대적인 무게를 알 수 있음.
		
		for(int i=1; i<=object; i++) {
			for(int j=1; j<=object; j++) {
				for(int k=1; k<=object; k++) {
					if(i==j) {
						// 최대 100*100 번의 연산 횟수 감소
						break;
					}
					if(weight[i][k] == 1 && weight[k][j] == 1) {
						weight[i][j] = 1; // i는 j보다 무거움
					}
					if(weight[object-i+1][k] == 1 && weight[k][object-j+1] == 1) {
						weight[object-i+1][object-j+1] = 1;
					}
				}
			}
		}
		
		for(int i=1; i<=object; i++) {
			int connect = object-1;
			// 우선 모두 알 수 없다고 가정하고, 알 수 있을 때 1씩 감소 
			for(int j=1; j<=object; j++) {
				if(weight[i][j] == 1 || weight[j][i] == 1) {
					// j에 대해서 i가 무겁거나 가볍다는  것을 알 수 있음
					connect--;
				}
			}
			System.out.println(connect);
		}
	}
}
