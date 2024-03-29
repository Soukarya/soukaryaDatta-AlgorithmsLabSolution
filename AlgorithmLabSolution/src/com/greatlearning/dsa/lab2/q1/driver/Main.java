package com.greatlearning.dsa.lab2.q1.driver;

import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		int size = 0, targetSize = -1, targetValue = 0;
		List<Integer> transactions = null;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Enter the size of transaction array");
			size = sc.nextInt();
			if (size <= 0) {
				System.err.println("Invalid input! Array size should be greater than zero\n");
			} else {
				transactions = new LinkedList<>();
			}
		} while (size <= 0);

		System.out.println("Enter the values of array");
		for (int i = 0; i < size; i++) {
			transactions.add(Math.abs(sc.nextInt()));
		}

		for (int i = 1; i < size; i++) {
			transactions.set(i, transactions.get(i - 1) + transactions.get(i));
		}

		System.out.println("Enter the total no of targets that needs to be achieved");
		targetSize = sc.nextInt();

		if (targetSize <= 0) {
			System.err.println("\nTotal no of targets that needs to be achieved should be greater than zero");
		}

		if (targetSize == 1) {
			System.out.println();
		}

		while (targetSize > 0) {

			System.out.println("Enter the value of target");
			targetValue = sc.nextInt();

			if (targetValue >= 0) {

				targetSize--;
				final int countOfTransaction = search(transactions, size, targetValue);
				if (countOfTransaction == -1) {
					System.out.println(" Given target is not achieved\n");
				} else {
					System.out.println("Target achieved after " + countOfTransaction + " transactions\n");
				}
			} else {
				System.err.println("\nTarget value should be greater than or equal to zero");
			}
		}

		transactions = null;
		sc.close();
	}

	/*
	 * If all the test cases does not pass, then use search2 in line no 53
	 * 
	 */
	private static final int search2(final List<Integer> transactions, final int size, final int targetValue) {

		int count = 0;
		for (Integer eachTransaction : transactions) {
			count++;
			if (targetValue <= eachTransaction) {
				return count;
			}
		}
		return -1;
	}

	private static final int search(final List<Integer> transactions, final int size, final int targetValue) {

		int low = 0, high = size - 1, mid = -1;

		if (targetValue <= transactions.get(low)) {
			return low + 1;
		}

		if (targetValue > transactions.get(high)) {
			return -1;
		}

		if (size <= 2) {
			if (targetValue > transactions.get(low) && targetValue <= transactions.get(high)) {
				return high + 1;
			}
		} else {

			while (low <= high) {
				mid = low + (high - low) / 2;
				if (mid > 0) {

					if (targetValue <= transactions.get(mid)) {
						high = mid;
					} else {
						low = mid + 1;
					}
					if (targetValue > transactions.get(mid - 1) && targetValue <= transactions.get(mid)) {
						return mid + 1;
					}
				} else {
					break;
				}
			}
		}
		return -1;
	}
}