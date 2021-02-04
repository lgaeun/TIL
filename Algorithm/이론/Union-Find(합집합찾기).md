- 합집합 찾기 알고리즘, 또는 서로소 집합(Disjoint-Set)알고리즘
- 여러 개의 노드가 존재할 때 두 개의 노드를 선택해서, 현재 이 노드가 <em>서로 같은 그래프에 속하는지 판별</em>하는 알고리즘
- 부모를 합칠 때는 더 작은 값 쪽으로 합친다
- 크루스칼 알고리즘에 응용될 수 있다 

 ``` 
  //부모 노드를 찾는 함수 
	static int getParent(int parent[], int x) {
		if(parent[x] == x) return x;
		return parent[x] = getParent(parent,parent[x]);
	}
	//두 부모노드를 합치는 함수 
	static void unionParent(int parent[], int x, int y) {
		int a = getParent(parent, x);
		int b = getParent(parent, y);
		if (a < b) parent[b] = a;
		else parent[a] = b;	//더 작은 수가 parent가 된다 
	}
	//같은 부모를 가지는지 확인(같은 그래프에 속해 있는지)
	static boolean findParent(int parent[], int x, int y) {
		int a = getParent(parent, x);
		int b = getParent(parent, y);
		return a == b;
	}
	
	public static void main(String[] args) {
		int[] parent = new int[11];
		for(int i = 0; i < 11; i++) {
			parent[i] = i;
		}
		//Union-Find test: 총 2가지 그래프 집합 존재 
		unionParent(parent, 1, 2);
		unionParent(parent, 2, 3);
		unionParent(parent, 3, 4);
		unionParent(parent, 5, 6);
		unionParent(parent, 6, 7);
		unionParent(parent, 7, 8);
		
		System.out.println("1과 5는 연결되어 있나요?"+ findParent(parent,1,5));
		System.out.println("1과 5 연결...");
		unionParent(parent, 1, 5);
		System.out.println("1과 5는 연결되어 있나요?"+ findParent(parent,1,5));
	}
  ```
