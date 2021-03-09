import java.util.*;

public class Main {
	
	static void solution(String str){
		StringBuilder sb = new StringBuilder("");
		char base = str.charAt(0);
		if(base == '1') sb.append("1");
		
		char cnt = 'A';
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i) == base) cnt++;
			else{
				sb.append(cnt);
				base = base=='1' ? '0' : '1';
				cnt = 'A';
			}
		}
		sb.append(cnt);
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		solution(str);

	}
}
