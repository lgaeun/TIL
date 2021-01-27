- BFS, DFS 자체로는 의미없음. 활용해서 문제를 해결하는 것이 주안점.
- so, 작동원리 빠삭하게 알아놓기!

## DFS

- 깊이 우선 탐색, 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘
- 스택 자료구조(혹은 재귀함수)를 이용,
- 동작 과정
    1.  탐색 시작 노드를 스택에 삽입, 방문 처리 하기
    2. 스택의 최상단 노드에 방문하지 않은 인접한 노드가 하나라도 있으면, 그 노드를 스택에 넣고 방문처리.

        방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다

    3. 더 이상 2번 과정을 수행할 수 없을 때까지 반복

    ```java
    import java.util.*;

    public class Main{

    	public static boolean visitied[] = new boolean[9]; //노드 8개에 대한 방문여부
    	//이차원 리스트 대신 중첩된(2차원)arraylist사용 - 특정index원소의 접근에 상수시간 걸림
    	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<integer>>();

    	//DFS 함수 정의
    	public static void dfs(int x){
    		visited[x] = true;   //현재노드 방문처리
    		System.out.print(x + " ");
    		  for(int i = 0; i < graph.get(x).size(); i++)   //현재노드에 인접한 노드에 대해
    				int y = graph.get(x).get(i);  
    				if(!visitied[y])  dfs(y);     // 방문안했으면, 그 안한 노드에 대해 dfs 수행 
    		}

    public stativ void main(String args[]){

    /*
      그래프에 내용 간선 넣기, dfs 수행
    */
    	}
    }
    ```

    ## BFS

    - 너비우선 탐색, 그래프에서 가까운 노드부터 우선적으로 탐색하는 알고리즘
    - 큐 자료구조
    - 동작과정
        1. 탐색 시작 노드를 큐에 삽입하고 방문처리
        2. 큐에서 노드를 꺼낸 뒤, 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리
        3. 더 이상 2번 과정을 수행할 수 없을 때까지 반복
    - 특정 조건에서의 최단거리를 구하는 문제에 효과적으로 사용될 수 있음

    ```java
    import java.util.*;

    public class Main{
    	
    	public static boolean[] visited = new boolena[9]   //노드 8개에 대한 방문여부
    	public static ArrayList<ArrayList<integer>> graph = new ArrayList<ArrayList<Integer>>();
     
    	pubic static void bfs(int start){
    		Queue<Integer> q = new LinkedList<>();
    		q.offer(start);
    		visited[start] = true;  //현재노드 방문처리
    		while(!q.isEmpty(){
    			int x = q.poll();   //큐에서 하나의 원소를 뽑아 출력
    			System.out.print(x+ " ");
    			//해당원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
    			for(int i=0; i < graph.get(i).size(); i++){   
    				int y = graph.get(x).get(i);
    				if(!visitied[y]){   //이미 방문처리된 거는 건너뛰고, 안된 애들 처리해주기
    					q.offer(y);
    					visited[y] = true;
    					}
    			 }
    		}
    //main함수 생략
    	}
    }
    ```

    ** 가중치가 없는 최단경로는 무조건 BFS!! (dfs안되는 이유: 특정 칸에 처음 도달했을 때까지의 경로의 길이가 다른 경로를 통해 도달한 길이보다 짧다는 보장이 전혀 없기 때문!)