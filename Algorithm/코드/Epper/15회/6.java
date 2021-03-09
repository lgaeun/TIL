import java.io.*;
import java.util.*;

public class Main {
	public static int solution(int m, String input) {
		Queue<Integer> q = new LinkedList<>();
		String[] arr = input.split(" ");
		
		for(int i = 0; i < arr.length; i++){
			char cur = arr[i].charAt(0);
			if(cur == '*'|| cur == '+'||cur == '-'||cur == '/'){
				int a = q.poll();
				int b = q.poll();
				switch (cur){
					case '+' : q.add(a+b);break;
					case '-' :q.add(a-b);break;
					case '*' :q.add(a*b);	break;
					case '/' :	q.add(a/b);	break;
				}
			}
			else q.add(cur - 48);
		}
		return q.poll();
	}

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		input.nextLine();
		String str = input.nextLine();
		int result;
		
		result=solution(m, str);
		System.out.println(result);
		
		
	}
}
