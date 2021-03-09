import java.util.*;
public class Main {
	static int cnt;
	static int solution(int[] arr, int start, int end) {
    
		if(start >= end) return cnt;
		
		if(arr[start] == arr[end]){
			return solution(arr, start+1, end-1);
		}
		else{
			if(arr[start] < arr[end]){
				arr[start+1] = arr[start] + arr[start+1];
				cnt++;
				return solution(arr, start+1, end);
			}
			else{
				arr[end-1] = arr[end] + arr[end-1];
				cnt++;
				return solution(arr, start, end-1);
			}
		}
	}
	public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          
          int[] arr = new int[10];
          int n =  sc.nextInt();
          int start = 0;
          int end = 0;
          
          for (int i = 0; i < n; i++) {
              arr[i] = sc.nextInt();
          }
          end = n - 1;

          System.out.println(solution(arr, start, end));
	}
}

/*
기본 아이디어: 왼쪽(start)에서 +1씩 증가, 오른쪽(end)에서 -1씩 감소시켜가며 양끝이 palindrome인지 체크한다
- 양끝이 같을 경우: start+1, end-1 -> 재귀
- 다른 경우 - (start > end) : end쪽을 더하고, -1 -> 재귀
          - (start < end) : start쪽을 더하고, +1 -> 
*/
