package sri.misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
 * Note that we have only one quantity of each item, In other words, given two integer arrays val[0..N-1] and wt[0..N-1] 
 * which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, 
 * find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. 
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 
Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of four lines. 
The first line consists of N the number of items. 
The second line consists of W, the maximum capacity of the knapsack. 
In the next  line are N space separated positive integers denoting the values of the N items and in the fourth line are N space separated positive integers
 denoting the weights of the corresponding items.
 

Output:

Print the maximum possible value you can get with the given conditions that you can obtain for each test case in a new line.
 

Constraints:

1≤T≤100

1≤N≤100

1≤W≤100

1≤wt[i]≤100

1≤v[i]≤100


Example:

Input:
1
3
4
1 2 3
4 5 1
Output:
3
 */
public class Knapsack {
	private class Item implements Comparable<Item>{
		Integer val;
		Integer weight;
		public Item(Integer v,Integer wt) {
			this.val = v;
			this.weight = wt;
		}
		@Override
		public int compareTo(Item o) {
			return this.weight
					.compareTo(o.weight);
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter values:");
		int inputSize = s.nextInt();
		//System.out.println("Enter sack capacity:");
		int capacity = s.nextInt();
		//System.out.println("Enter input values:");
		int values [] = new int[inputSize];
		for(int i=0;i<inputSize;i++){
			values[i]=s.nextInt();
		}
		int weights[] = new int[inputSize];
		for(int i=0;i<inputSize;i++){
			weights[i]=s.nextInt();
		}
		
		Knapsack k = new Knapsack();
		
		List<Item> items = new ArrayList<>();
		for(int i=0;i<inputSize;i++){
			items.add(k.new Item(values[i], weights[i]));
		}
		
		items.sort(new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return o1.compareTo(o2);
			}
		});
		List<Integer> baggedItems = new ArrayList<>();
		int leftCapacity = capacity;
		for(Item i : items){
			if(leftCapacity>0 && i.weight<=leftCapacity){
				leftCapacity-=i.weight;
				baggedItems.add(i.val);
			}
		}
		System.out.println("bagged items:\n "+baggedItems);

	}

}
