import java.io.*;
import java.util.*;

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
		dfs(0,0);
		System.out.print(sb);
	}
	static void dfs(int prev,int depth) {
		
		if(depth == m ) {
			for(int val: ans) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(Integer num : map.keySet()) {
			if(num < prev) continue;
			if(map.get(num) > 0) {
				ans[depth] = num;
				map.put(num, map.get(num)-1);
				dfs(num, depth+1);
				map.put(num, map.get(num)+1);
			}
		}
	}

}

/*
예제 입력 2 
4 2
9 7 9 1
예제 출력 2 
1 7
1 9
7 9
9 9
/*
