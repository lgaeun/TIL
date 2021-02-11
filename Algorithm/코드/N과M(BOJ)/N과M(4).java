import java.io.*;
import java.util.*;

public class Main {
	
	static int[] arr;
	static int n,m;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];

		dfs(0,0);
		System.out.print(sb);
	}
	static void dfs(int idx, int depth) {
		
		if(depth == m) {
			for(int val: arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = idx; i < n; i++) {
			arr[depth] = i+1;
			dfs(i, depth+1);
		}
	}

}
/*
예제 입력 2 
4 2
예제 출력 2 
1 1
1 2
1 3
1 4
2 2
2 3
2 4
3 3
3 4
4 4
*/
