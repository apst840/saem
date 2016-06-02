package baekjun_ageSort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static String [] age;
	static String [] name;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String s = new String();	
		String [] s2 = new String[2];
		age = new String[n];
		name = new String[n];
		
		int [] age_int = new int[n];
		int [] age_int2 = new int[n];
		s = sc.nextLine();	
		
		
		for(int i=0;i<n;i++){
			s = sc.nextLine();	
			s2 = s.split(" ");
			
			age[i] = s2[0];
			name[i] = s2[1];
		}
		int num=0;
		
		for(int j=0;j<n;j++){
			num=0;
			int ten = 1;
			for(int i=0;i<age[j].length();i++){
				num = num*ten+(age[j].charAt(i)-48);
				ten*=10;
			}
			age_int[j] = num;
			age_int2[j] = num;
		}
		
		int low = 0;
		int high = age_int.length - 1;
 
		quickSort(age_int, low, high);
		
/*		Arrays.sort(age_int);
		
		int count=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(age_int[i] == age_int2[j]) {
					System.out.println(age[j]+" "+name[j]);
					age_int2[j] = -1;
					count++;
					
				}
				if(count==n){
					break;
				}
			}
			if(count==n){
				break;
			}
			
		}*/
		
/*		for(int i=0;i<age_int.length-1;i++){
			largest = i;
			for(j=i+1;j<age_int.length;j++){
				if(age_int[largest]>age_int[j]){
					largest = j;
				}
			}
			int temp = age_int[largest];
			age_int[largest] = age_int[i];
			age_int[i] = temp;
			
			String temp2 = age[largest];
			age[largest] = age[i];
			age[i] = temp2;
			
			String temp3 = name[largest];
			name[largest] = name[i];
			name[i] = temp3;		
		}*/
		
		for(int i=0;i<n;i++){
			System.out.println(age[i]+" "+name[i]);
		}
	}
	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] <= pivot) {
				i++;
			}
 
			while (arr[j] >= pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
				String temp2 = age[i];
				age[i] = age[j];
				age[j] = temp2;
				
				String temp3 = name[i];
				name[i] = name[j];
				name[j] = temp3;
				
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}
}
