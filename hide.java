package baekjun_hide;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class hide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int source = sc.nextInt();
		int dest = sc.nextInt();
		
		Queue<Integer> q = new <Integer>LinkedList();
		HashMap<Integer, Integer> hash = new <Integer, Integer> HashMap();

		int result = 0;
		
		if(source != dest){
			result=1;
			if(source*2<=100000&&!hash.containsKey(source*2)){
				q.offer(source*2);
				hash.put(source*2, result);
			}
			if(source+1<=100000&&!hash.containsKey(source+1)){
				q.offer(source+1);
				hash.put(source+1, result);
			}
			if(source-1>=0&&!hash.containsKey(source-11)){
				q.offer(source-1);
				hash.put(source-1, result);
			}
		}
		int n=0;
		while(!q.isEmpty()){
			n = q.poll();
			if(n==dest) break;
			result = hash.get(n)+1;
			
			int jump = n*2;
			if(jump<=100000&&!hash.containsKey(jump)){
				q.offer(jump);
				hash.put(jump, result);
			}
			
			int walk_ahead = n+1;
			if(walk_ahead<=100000&&!hash.containsKey(walk_ahead)){
				q.offer(walk_ahead);
				hash.put(walk_ahead, result);
			}
			
			int walk_back = n-1;
			if(walk_back>=0&&!hash.containsKey(walk_back)){
				q.offer(walk_back);
				hash.put(walk_back, result);
			}
			
		}
		System.out.println(hash.get(n));
	}
}


/*public class hide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int source = sc.nextInt();
		int dest = sc.nextInt();
		
		Queue<Integer> q = new <Integer>LinkedList();
		int [] arr =  new int[100001];

		int result = 0;
		
		if(source != dest){
			result=1;
			if(source*2<=100000&&arr[source*2]==0){
				q.offer(source*2);
				arr[source*2] = result;
			}
			if(source+1<=100000&&arr[source+1]==0){
				q.offer(source+1);
				arr[source+1] = result;
			}
			if(source-1>=0&&arr[source-1]==0){
				q.offer(source-1);
				arr[source-1] = result;
			}
		}
		int n=0;
		while(!q.isEmpty()){
			n = q.poll();
			if(n==dest) break;
			result = arr[n]+1;
			
			int jump = n*2;
			if(jump<=100000&&arr[jump]==0){
				q.offer(jump);
				arr[jump] = result;
			}
			
			int walk_ahead = n+1;
			if(walk_ahead<=100000&&arr[walk_ahead]==0){
				q.offer(walk_ahead);
				arr[walk_ahead] = result;
			}
			
			int walk_back = n-1;
			if(walk_back>=0&&arr[walk_back]==0){
				q.offer(walk_back);
				arr[walk_back] = result;
			}
			
		}
		System.out.println(arr[n]);
	}
}*/