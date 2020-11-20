import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int index=0; index<testCase; index++) {
			int room = sc.nextInt();
			int secretPath = sc.nextInt();
			
			int matrix[][] = new int[room+1][room+1];
			
			for(int i=0; i<secretPath; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				int cost = sc.nextInt();
				matrix[start][end] = cost;
				matrix[end][start] = cost;
			}
			
			for(int i=1; i<=room; i++) {
				for(int j=1; j<=room; j++) {
					for(int k=1; k<=room; k++) {
						if(i==j) {
							continue;
						}
						if(matrix[i][k] != 0 && matrix[k][j] !=0) {
							if(matrix[i][j] == 0) {
								matrix[i][j] = matrix[i][k] + matrix[k][j];
								matrix[j][i] = matrix[i][k] + matrix[k][j];
							}
							else {
								matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
								matrix[j][i] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
							}
						}
						if(matrix[room+1-i][k] != 0 && matrix[k][room+1-j] !=0) {
							if(matrix[room+1-i][room+1-j] == 0) {
								matrix[room+1-i][room+1-j] = matrix[room+1-i][k] + matrix[k][room+1-j];
								matrix[room+1-j][room+1-i] = matrix[room+1-i][k] + matrix[k][room+1-j];
							}
							else {
								matrix[room+1-i][room+1-j] = Math.min(matrix[room+1-i][room+1-j], matrix[room+1-i][k] + matrix[k][room+1-j]);
								matrix[room+1-j][room+1-i] = Math.min(matrix[room+1-i][room+1-j], matrix[room+1-i][k] + matrix[k][room+1-j]);
							}
						}
					}
				}
			}
			
			int friend = sc.nextInt(); // 비밀 모임에 참여하는 친구의 수
			int friendRoom[] = new int[friend];
			for(int i=0; i<friend; i++) {
				friendRoom[i] = sc.nextInt();
			}
			
			int min = Integer.MAX_VALUE;
			int minRoom = 0;
			
			for(int i=1; i<=room; i++) {
				int sum = 0;
				for(int j=0; j<friend; j++) {
					sum += matrix[i][friendRoom[j]]; // i방을 비밀모임에 사용하는 방
				}
				if(sum < min) {
					min = sum;
					minRoom = i;
				}
			}
			
			System.out.println(minRoom);
		}	
	}
}
