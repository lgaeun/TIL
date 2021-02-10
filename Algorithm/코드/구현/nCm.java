/* nCm (n개 중 m개를 고르는 코드 - 백트래킹) */

//1. check[] 배열로: 골랐는지 여부를 각 숫자마다 체크, m개 골랐으면 stop
ArrayList<> num = new ArrayList(); // 고를 숫자
boolean visit[] = new boolean[n];

static void choose(int idx, int cnt){
	
	if(cnt == m){
		return;
	}

	for(int i = idx; i < num.size; i++){
		visit[idx] = true; 
		choose(idx+1, cnt+1);
		visit[idx] = false;
	}
}

//2. Stack 등에 고른 숫자 추가하고, 스택의 크기가 m일 때 stop
ArrayList<> num = new ArrayList(); // 고를 숫자 n개 
Stack<> selected = new Stack();  //고른 숫자

static void choose(int idx, int cnt) {	
		
	if(cnt == m){
		return;
	}
		
	for(int i = idx; i < num.size(); i++){
		selected.push(num.get(i));
		choose(i+1, cnt+1);
		selected.pop();
	}
}
