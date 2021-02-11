import java.io.*;
import java.util.*;

// 방법(1) TreeMap이용 - <숫자, 그 숫자가 들어온 개수> 로 중복입력 check
public class Main {
	static int[] ans;
	static TreeMap<Integer,Integer> map = new TreeMap<>();
	static int n,m;
	static StringBuilder sb = new StringBuilder("");
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int key = Integer.parseInt(st.nextToken());
			if(!map.containsKey(key)) map.put(key,1);
			else map.put(key, map.get(key)+1);
		}
		dfs(0);
		System.out.print(sb);
	}
    
	static void dfs(int depth) {
		if(depth == m ) {
			for(int val: ans) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(Integer num : map.keySet()) {
			if(map.get(num) > 0) {  // 남아있는 숫자의 개수가 1개 이상일 경우에만, visit 따로 체크필요 X(개수로 어차피 세고 있어서 0개가되면 그 숫자는 스킵되니까)
				ans[depth] = num;
				map.put(num, map.get(num)-1);
				dfs(depth+1);
				map.put(num, map.get(num)+1);
			}
		}
	}

}

// 방법(2): <35~40line 부분> list로 입력받고 정렬 & 바로 앞의 수와 비교해서 같으면 skip
int prev = -1
		for(int i=0; i<N; i++) {
			int now = numbers[i];
			if(visit[i] || past == now) continue;
			past = now; 
			choices[count] = now;
			isSelected[i] = true;
			permutation(count+1);
			isSelected[i] = false;
		}


/*

예제 입력 2 
4 2
9 7 9 1
예제 출력 2 
1 7
1 9
7 1
7 9
9 1
9 7
9 9

*/
