import java.io.*;
import java.util.*;

public class Main {
	
	static int[] arr, num;
	static int n,m;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		num = new int [n];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
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
			arr[depth] = num[i];
			dfs(i,depth+1);
		}
	}

}


/*
예제 입력 2 
4 2
9 8 7 1
예제 출력 2 
1 1
1 7
1 8
1 9
7 7
7 8
7 9
8 8
8 9
9 9
*/
