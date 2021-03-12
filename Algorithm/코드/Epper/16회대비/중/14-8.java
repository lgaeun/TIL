/*
기본아이디어: 토마토가 익는 최소 일수, 즉 level을 구해야 하므로 BFS. 큐에는 토마토의 좌표 클래스 XY를 삽입.
*/

// 실제 시험에서는 solution 함수를 사용한다는 점을 감안하고 풀이해주세요.
import java.io.*;
import java.util.*;
 
class XY{ // 실제 시험에서는 Solution을 제외한 클래스를 제공하지 않을 수 있습니다.
    int x, y;
 
    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// 실제 시험에서는 solution을 제외한 함수 형태를 제공하지 않을 수 있습니다.
public class Main {
	
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int cnt, day;	//익지 않은 토마토의 개수, 익는 데 걸리는 일 수  
	static Queue <XY> q = new LinkedList<>(); 
	
	public static int solution(int n, int m, int[][] box){
		map = new int[m][n];
		
		for(int i = 0; i < m; i++) { 	
			for(int j = 0; j < n; j++) {	
				map[i][j] = box[i][j];
				if(map[i][j] == 0) cnt++;	//익지 않은 토마토 개수 세기 
				else if(map[i][j] == 1) { q.add(new XY(i,j)); //아직 방문 안했고, 토마토가 있는 경우 큐에 삽입 
				}
			}
		}
		if(cnt == 0) return 0; // ****** 이미 토마토가 다 익어있는 경우!!!!!이 경우 조심하기!!!!!! ********
		
		bfs(n, m);
    	return cnt==0? day-1 : -1;	// 익은 토마토가 1에서 시작했으므로 day는 -1 한 것.
    }
	static void bfs(int n, int m) {
		
		while(!q.isEmpty()) {	//'1'이었던 토마토 큐에서 꺼내서 주변토마토 익히기 
			XY cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = dx[i] + cur.x;
				int ny = dy[i] + cur.y;
				
				if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue; //범위 내에 들어가는지 체크 
				if(map[nx][ny] == -1 || map[nx][ny] >= 1) continue; //토마토가 없거나(-1), 이미 익은거면(1이상) 건너뛰기   
				
				map[nx][ny] = map[cur.x][cur.y] + 1;
				day = Math.max(day, map[nx][ny]); // 토마토 익히는 일 수 갱신 
				cnt--; //남은 안 익은 토마토 개수 1 감소 
				q.add(new XY(nx,ny));
			}
		}
		
	}
///////////////////////시험에서 이미주어지는 부분///////////////////////////////
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int temp = 0;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  
        int m = Integer.parseInt(st.nextToken());  
        
        int[][] box = new int[1000][1000];
        
        for(int y=0; y<m; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                temp = Integer.parseInt(st.nextToken());
                box[y][x] = temp;
            }
        }
        System.out.print(solution(n, m, box));
    }
}

