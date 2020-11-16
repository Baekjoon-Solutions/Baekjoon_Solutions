import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase;
		Map<String, Integer> management;
		Map<String, Integer> list[];

		try {
			testCase = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력
			for (int i = 0; i < testCase; i++) {
				// 케이스 반복용
				int number = Integer.parseInt(br.readLine()); // 관계 수
				management = new HashMap<String, Integer>(); // 이름과 인덱스를 짝 지을 map
				list = new HashMap[number]; // 관계들에 대한 map을 관리할 배열
				int count = 0; // 다음 생성할 map의 인덱스

				for (int j = 0; j < number; j++) {
					String tmp = br.readLine();
					String token[] = tmp.split(" ");
					int index = 0; // 출력할 때 접근할 인덱스

					if (!management.containsKey(token[0]) && !management.containsKey(token[1])) {
						// 둘 다 map에 없는 이름
						management.put(token[0], count);
						management.put(token[1], count);
						// 둘 다 count를 list의 인덱스로 할 수 있도록 짝을 지어줌
						list[count] = new HashMap<String, Integer>();
						list[count].put(token[0], count);
						list[count].put(token[1], count);
						// list의 count 인덱스에 추가
						index = count; // 출력할 인덱스 수정
						count++; // count변수는 다음에 생성할 위치를 가리키는 것이기 때문에 1증가
					} else if (!management.containsKey(token[0])) {
						// token[0]만 map에 없는 이름
						management.put(token[0], management.get(token[1])); // token[1]과 같은 인덱스를 갖도록 함
						list[management.get(token[1])].put(token[0], management.get(token[1])); // list에도 추가
						index = management.get(token[1]); // 출력할 인덱스 token[1]의 인덱스로 수정

					} else if (!management.containsKey(token[1])) {
						// token[1]만 map에 없는 이름
						management.put(token[1], management.get(token[0])); // token[0]과 같은 인덱스를 갖도록 함
						list[management.get(token[0])].put(token[1], management.get(token[0])); // list에도 추가
						index = management.get(token[0]); // 출력할 인덱스 token[0]의 인덱스로 수정
					} else {
						int x = management.get(token[1]); // 만약 token[0]과 [1]의 인덱스가 다른 경우 접근할 때 사용할 수 있도록 미리 변수에 저장해놓음.
						if (management.get(token[0]) == management.get(token[1])) {
							// 같은 경우 아무 처리 x
						} else {
							// 다른 경우
							Iterator<Map.Entry<String, Integer>> iter = list[x].entrySet().iterator();
							while (iter.hasNext()) {
								Map.Entry<String, Integer> s = iter.next();
								if (s.getValue() == x) {
									management.put(s.getKey(), management.get(token[0]));
									list[management.get(token[0])].put(s.getKey(), management.get(token[0]));
								}
								// list[x] = null; // 접근을 안하는 부분이라고 생각했는데, 이부분 때문에 런타임 에러가 발생함.
							}
							// token[1]에 대한 인덱스를 돌면서 value를 수정해줄 것임. list에도 추가
						}
						index = management.get(token[0]); // 출력할 인덱스 수정
					}
					bw.write(list[index].size() + "\n"); // list의 index에는 서로 연결된 이름만 저장되어 있으므로, size를 출력해주면 됨.
				}
			}
			br.close();
			bw.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

