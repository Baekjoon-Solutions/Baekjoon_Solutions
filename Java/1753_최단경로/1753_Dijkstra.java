import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
	
	static class Pair implements Comparable{
		int v;
		int cost;
		public Pair(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Object arg0) {
			Pair o1 = (Pair)arg0;
			if(this.cost < o1.cost) {
				return -1;
			}
			else if(this.cost > o1.cost) {
				return 1;
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String st = br.readLine();
			String[] token = st.split(" ");
			int vertices = Integer.parseInt(token[0]);
			int edges = Integer.parseInt(token[1]);
			// 정점과 간선의 개수 입력
			
			int start = Integer.parseInt(br.readLine()); // 시작 정점 입력
			
			LinkedList[] matrix = new LinkedList[vertices+1];
			for(int i=1; i<=vertices; i++) {
				matrix[i] = new LinkedList<Pair>();
			}
			
			for(int i=0; i<edges; i++) {
				// cost 입력
				st = br.readLine();
				token = st.split(" ");
				int s = Integer.parseInt(token[0]); // 시작점
				int f = Integer.parseInt(token[1]); // 끝점
				int cost = Integer.parseInt(token[2]); // 가중치
				
				matrix[s].add(new Pair(f, cost));
			}
			
			PriorityQueue<Pair> queue = new PriorityQueue<>();
			
			int cost[] = new int[vertices+1]; // cost를 저장할 배열
			boolean visited[] = new boolean[vertices+1]; // 방문 여부를 저장할 배열
			
			for(int i=1; i<=vertices; i++) {
				// cost 배열 초기화
				cost[i] = Integer.MAX_VALUE;
			}
			
			Iterator<Pair> iter = matrix[start].iterator();
			while(iter.hasNext()) {
				Pair pair = iter.next();
				if(cost[pair.v] > pair.cost) {
					cost[pair.v] = pair.cost;
					queue.add(pair);
				}
			}
			cost[start] = 0;
			visited[start] = true;
			// 자신은 계산할 필요가 없음
			
			while(!queue.isEmpty()) {
				Pair temp = queue.remove();
				int minCost = temp.cost;
				int minIndex = temp.v;
				visited[minIndex] = true;
				iter = matrix[minIndex].iterator();
				while(iter.hasNext()) {
					Pair pair = iter.next();
					if(visited[pair.v] != true) {
						if(pair.cost + cost[minIndex] < cost[pair.v]) {
							cost[pair.v] = pair.cost + cost[minIndex];
							queue.add(new Pair(pair.v, cost[pair.v]));		
						}
					}	
				}
				// cost 재설정
			}
			
			for(int i=1; i<=vertices; i++) {
				if(cost[i] == Integer.MAX_VALUE) {
					System.out.println("INF");
				}
				else {
					System.out.println(cost[i]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
