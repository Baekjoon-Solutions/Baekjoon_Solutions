import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		int party = sc.nextInt();
		
		int fact = sc.nextInt();
		Queue<Integer> factNum = new LinkedList<>(); // 진실을 들은 사람을 담는 큐
		int visited[] = new int[people+1]; // 중복이 없도록 하기 위해 체크
		
		for(int i=0; i<fact; i++) {
			// 초기에 진실을 아는 사람
			int tmp = sc.nextInt();
			factNum.add(tmp);
			visited[tmp] = 1;
		}
		
		int partyNum[][] = new int[party][people+2];
		// 공간을 미리 잡아두고, 크기도 저장 + 과장된 이야기를 할 수 있는 파티인지 표시
		for(int i=0; i<party; i++) {
			int attend = sc.nextInt();
			partyNum[i][0] = attend; // 0번째엔 명 수 저장
			for(int j=1; j<=attend; j++) {
				partyNum[i][j] = sc.nextInt();
			}
		}
		
		while(!factNum.isEmpty()) {
			int factPerson = factNum.remove();
			for(int i=0; i<party; i++) {
				int count = 0;
				for(int j=1; j<=partyNum[i][0]; j++) {
					if(partyNum[i][j] == factPerson) {
						// 진실을 아는 사람이 포함된 파티라면, 여기있는 사람들이 모두 큐에 추가가 되어야 함.
						partyNum[i][partyNum[i][0]+1] = 1; // 진실을 얘기해야하는 파티
						count = 1;
						break;
					}
				}
				if(count == 1) {
					for(int j=1; j<=partyNum[i][0]; j++) {
						// 모두 큐에 추가하는데, 중복을 최소화하기 위해 큐에 없는 사람들만 추가
						if(visited[partyNum[i][j]] == 0) {
							factNum.add(partyNum[i][j]);
							visited[partyNum[i][j]] = 1;
						}
					}
				}
					
			}
		}
		
		int count = 0;
		for(int i=0; i<party; i++) {
			int attend = partyNum[i][0];
			if(partyNum[i][attend+1] == 0) {
				// 과장된 이야기를 할 수 있는 파티라는 뜻
				count++;
			}
		}
		System.out.println(count);
	}
}
