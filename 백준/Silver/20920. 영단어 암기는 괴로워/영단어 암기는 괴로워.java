import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N  = Integer.parseInt(st.nextToken());
		int M  = Integer.parseInt(st.nextToken());
		HashMap<String,Integer> arr = new HashMap<String,Integer>();
		for(int i =0;i<N;i++) {
			// 임시로 tmp에 입력받은다음			
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			// 길이가 M보다 큰지 검사하여
			// 크지 않다면 다음 입력으로 이동 
			if(tmp.length()>=M) {
				// 길이가 크다면 현재 포함되어있는 key인지 확인하여
				// 있다면 값만 +1 해주고
				// 없다면 새롭게 value 1로 추가하여준다.
				if(arr.containsKey(tmp)) {
					arr.replace(tmp, arr.get(tmp)+1);
				}
				else {					
					arr.put(tmp,1);
				}				
			}			
		} // for문
		ArrayList<String> ans = new ArrayList<String>(arr.keySet());
		Collections.sort(ans,(o1,o2) -> { // 두개의 인자를 비교하여

			if(arr.get(o2)!=arr.get(o1)) {  // 값이 다를 때는 값 높은순으로
				return arr.get(o2)-arr.get(o1); 
			}		
			if(o2.length() != o1.length()) { // 길이가 다르면 길이 비교
				return o2.length()-o1.length();  
			}
			return o1.compareTo(o2); // 길이랑 값이 같으면 사전순

		});
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<ans.size();i++) {
			sb.append(ans.get(i)+"\n");

		}
		System.out.println(sb);


	}



}
