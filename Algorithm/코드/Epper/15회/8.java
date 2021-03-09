import java.io.*;
class Main {
	
	static int[] arr;
	static int cnt, K, N;
	static int[][] pos;
	
	static void solution(int n, int k, int[] X, int[] Y) {
		K = k; N=n;
		arr = new int[n];
		pos = new int[k][2];
		for(int i = 0; i < k; i++){
			pos[i][0] = X[i]-1;
			pos[i][1] = Y[i]-1;
		};
		equeen(0);
		System.out.println(cnt);
	}
	
	static void equeen(int depth){
		if(depth == N){
			cnt++;
			return;
		}
		for(int i = 0; i < N; i++){
			arr[depth] = i;
			if(isValid(depth))
				equeen(depth+1);
		}
	}
	
	static boolean isValid(int row){
		for(int i = 0; i < K; i++) {    //일반적인 n-queen에 이 조건만 포함시킴
			if(row == pos[i][0] && arr[row] == pos[i][1])
			return false;
		}
		
		for(int i = 0; i < row; i++){     //*주의! i는 row까지만 탐색할 것
			if(arr[i] == arr[row]) return false;
			else if(Math.abs(row-i) == Math.abs(arr[i]-arr[row])) return false;
		}
		
		return true;
		
	}
	
//main은 다시 수정하지 않아도 됩니다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt((br.readLine()));
		int k = Integer.parseInt(br.readLine());
		
		String xs = br.readLine();
		String[] splitxs =  xs.split(", ");
		int X[] = new int[k];
		for(int i=0; i<k; i++){
			X[i] = Integer.parseInt(splitxs[i]);
		}
		
		String ys = br.readLine();
		String[] splitys =  ys.split(", ");
		int Y[] = new int[k];
		for(int i=0; i<k; i++){
			Y[i] = Integer.parseInt(splitys[i]);
		}
		solution(n,k,X,Y);
	}

}
