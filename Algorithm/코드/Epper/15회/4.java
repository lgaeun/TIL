import java.util.*;

 public class Main { 
	 
 	public static void solution(int[] numbers) {
	 	
		int sum = 0;
		for(int i : numbers) sum+= i;
		
		for(int i = 0; i < 9; i++){
			for(int j = i+1; j < 9; j++){
				if(sum - numbers[i] - numbers[j] == 100){
					numbers[i] = 0;
					numbers[j] = 0;
					break;
				}
			}
		}
		
		for(int num : numbers){
			if(num != 0) System.out.print(num+" ");
		}
 	}
	
	public static void main(String [] args){
		int [] numbers=new int[9];
		Scanner input= new Scanner(System.in);
		
		for (int i = 0; i < 9; i++) {
			numbers[i]=input.nextInt();
		}
	
		solution(numbers);
		
	}
}
