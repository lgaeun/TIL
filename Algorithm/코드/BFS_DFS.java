import java.util.*;
import java.io.*;

public class _iceCream {
	
	static boolean visited[];
	static ArrayList<Integer>[] graph;
	
	// 재귀 이용 
	static void dfs(int x) {	
		visited[x] = true;		//visit current node
		System.out.print(x+" ");	
		for(int i = 0; i < graph[x].size(); i++) {		// for all adjacent nodes, leaf이면	size=0이기때문에 자동종료되어, 따로 종료조건 해줄 필요X		
			int y = graph[x].get(i);
			if(!visited[y]) dfs(y);		//if not visited, visit
		}
	}
	
	//priority queue이용 - 작은숫자 먼저 방문 
	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();	 //일단 큐(=방문 할 리스트)에 다 집어넣고 방문표시 
		q.offer(x);
		visited[x] = true;
		//큐가 빌 때까지 반복 
		while(!q.isEmpty()) {
			int next = q.poll();
			System.out.print(next+" ");
			
			for(int i = 0; i < graph[next].size(); i++) {
				int y = graph[next].get(i);
				if(!visited[y]) {		//아직 방문전이면, 큐에 넣고 방문표시 
					q.offer(y);
					visited[y]=true;
				}
			}
		}	
		
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];			//1차원: n개의 고정 list
		visited = new boolean[N+1];
		
		for(int i = 0; i < N+1; i++) {		//2차원: 가변 ArrayList
			graph[i] = new ArrayList<>();
		}
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
			graph[y].add(x);
		}
		//작은순서대로 정렬 
		for(int i = 0; i < N+1; i++) {
			Collections.sort(graph[i]);
		}
		
		dfs(start);
		Arrays.fill(visited, false);
		System.out.println();
		bfs(start);
		
	}
}
