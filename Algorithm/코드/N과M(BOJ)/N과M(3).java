import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] visit;
	static int[] arr;
	static int n,m;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		visit = new boolean[n];
		
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
		
		for(int i = 0; i < n; i++) {
			visit[i] = true;
			arr[depth] = i+1;
			dfs(i+1, depth+1);
			visit[i] = false;
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
2 1
2 2
2 3
2 4
3 1
3 2
3 3
3 4
4 1
4 2
4 3
4 4
*/
