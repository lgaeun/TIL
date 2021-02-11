import java.io.*;
import java.util.*;

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
		
		dfs(0);
		System.out.print(sb.toString());
	}
	static void dfs(int depth) {
		
		if(depth == m) {
			for(int val: arr)
				sb.append(Integer.toString(val)+" ");
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				dfs(depth+1);
				visit[i] = false;
			}
		}
	}

}
