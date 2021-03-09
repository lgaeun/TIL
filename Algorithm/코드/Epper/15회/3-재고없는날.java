import java.util.Scanner;

public class Main{
	public static int solution(int n, int m){
		int day = 1;
		
		while(--n > 0){
			day++;
			if(day % m == 0) n++;
			
		}
		return day;
	}


   public static void main(String[] args) {
      Scanner scanner=new Scanner(System.in);
      int n=scanner.nextInt();
      int m= scanner.nextInt();
      int answer=solution(n,m);
		 
      System.out.println(answer);
   }

}
