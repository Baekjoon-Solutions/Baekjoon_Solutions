import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P11652 {
	public static void main (String args[]) throws NumberFormatException, IOException {
		Map<Long, Long> map = new HashMap<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<num; i++) {
			Long val = Long.parseLong(br.readLine());
			if(map.containsKey(val)) {
				//map에 이미 있다면
				Long add = map.get(val);
				map.put(val, ++add);
			} else {
				//없으면 생성
				map.put(val, (long) 1);
			}
		}
		//map value 기준 내림차순 정의
		List<Long> keyList = new ArrayList<>(map.keySet());
		Collections.sort(keyList, new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				Long num1 = map.get(o1);
				Long num2 = map.get(o2);
				if(num1 == num2) {
					//key 값이 같으면 작은거 리턴
					return o1.compareTo(o2);
				}
				return num2.compareTo(num1);
			}
		});
		/*
		for(Long key : keyList) {
			System.out.println(String.format("key : %s, Value : %s" ,  key, map.get(key)));
		}
		*/
		System.out.println(keyList.get(0));
	}
}
