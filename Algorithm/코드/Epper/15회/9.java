import java.util.*;

public class Main {
	
	static int N, R;
	
	static int solution(int[] n,int[][] r,int goal) {
		int[] time = new int[N+1];      // i번째 공정까지 소요되는 시간
		int[] indegree  = new int[N+1]; // 선행되어야하는 공정 수
		Arrays.fill(indegree, 0);
		Arrays.fill(time, 0);
		
		ArrayList<Integer>[] list = new ArrayList[N+1];  //Arraylist타입의 배열 선언 - 공정들끼리의 관계
		for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
		for(int i = 0; i < r.length; i++){  
			list[r[i][0]].add(r[i][1]);       //r[i][0]번째 공정 뒤에 r[i][1]번째 공정이 일어날 수 있음
			indegree[r[i][1]]++;              // 선행되어야하는 공정 수 1 증가
		}
		
    		Queue<Integer> q = new LinkedList<>();
    
		for(int i = 1; i <= N; i++){  //선행되어야하는 공정 개수가 0인 것들 큐에 먼저 넣기 (즉, 바로 시작할 수 있는 공정)
			if(indegree[i] == 0) {      
				q.offer(i);
				time[i] = n[i-1];       //첫 번째로 진행되는 공정이 걸리는 시간 초기화
			}
		}
		
		while(!q.isEmpty()){
			int cur = q.poll();
			for(int next: list[cur]){   
				time[next] = Math.max(time[next], n[next-1] + time[cur]); // 뒤따르는 공정들 중 최대값 = 그 단계의 공정에 필요한 시간
				if(--indegree[next] == 0) q.offer(next);  // 선행되어야하는 공정에서 1 감소 시킨것이 0이면 큐에 추가
			}
		}
		return time[goal];
	}
		
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		R=sc.nextInt();
		int[] n = new int[N];
		int [][] r=  new int[R][2];
		
		for(int i=0;i<N;i++) {
			n[i]=sc.nextInt();
		}
		for(int k=0;k<R;k++) {
			r[k][0] = sc.nextInt();
			r[k][1] = sc.nextInt();
		}
		
		int goal=sc.nextInt();
		int k=solution(n,r,goal);
		System.out.println(k);
		
	}
}
