import java.util.*;
import java.util.Scanner;
import java.io.*;
public class Sort {
public static void main(String[] args) {
	try{
		FileWriter w = new FileWriter("Integer.txt");
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the total number of integers to be written in the file");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.print("Enter number- " + (i + 1) + " :" );
			int input = sc.nextInt();
			w.write(input + "\t");
			}w.close();
	int i=0;
	int arr[] = new int[n];
	File file = new File("Integer.txt");
	Scanner read = new Scanner(file);
	while(read.hasNext()){
	arr[i++] = Integer.valueOf(read.next());
	}
	Thread t1= new Thread(){
		public void run(){
		Arrays.sort(arr, 0, (arr.length/3));
		System.out.println("\n\nThread 1:");
		for (int j = 0; j < (arr.length/3); j++) {
			System.out.println(arr[j]);
			}
		}
	};
	Thread t2= new Thread(){
	public void run(){
	Arrays.sort(arr, (arr.length/3), (2*(arr.length/3)));
	System.out.println("Thread 2:");
	for (int j = (arr.length/3); j < (2*(arr.length/3)); j++) {
		System.out.println(arr[j]);
			}
		}
	};
	Thread t3= new Thread(){
	public void run(){
	Arrays.sort(arr, (2*(arr.length/3)),(n-1));
	System.out.println("Thread 1:");
	for (int j = (2*(arr.length/3)); j < n; j++) {
		System.out.println(arr[j]);
		}
	}
};
	Thread t4= new Thread(){
	public void run(){
	Arrays.sort(arr);
	StringBuilder s = new StringBuilder();
	try{
		FileWriter write =new FileWriter("SortedInteger.txt");
		System.out.println("\nDone!!");
		for (int j = 0; j < n; j++) {
			s.append(String.valueOf(arr[j]) + "\t");
		}
	write.write(s.toString());
	write.close();
	}catch (Exception e){
	System.out.print(e);
		}
	}
};
	t1.start();
	t1.join();
	t2.start();
	t2.join();
	t3.start();
	t3.join();
	t4.start();
	}catch(Exception e){
		System.out.print(e);
		}
	}
}
