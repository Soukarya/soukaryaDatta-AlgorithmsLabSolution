package com.greatlearning.dsa.lab2.q2.driver;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int size = -1;
		Integer[] currencyDenominations = null;
		int amount = -1;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of currency denominations");
		size = sc.nextInt();
		if (size > 0) {
			currencyDenominations = new Integer[size];

			System.out.println("\nEnter the currency denominations value");
			for (int i = 0; i < size; i++) {
				currencyDenominations[i] = sc.nextInt();
			}

			// sorting in descending order
			Arrays.sort(currencyDenominations,Collections.reverseOrder());

			System.out.println("\nEnter the amount you want to pay");
			amount = sc.nextInt();

			System.out.println(getDenomination(currencyDenominations, amount));
		} else {
			System.err.println("Array size cannot be zero or negative");
		}
		currencyDenominations = null;
		sc.close();
	}

	private static StringBuilder getDenomination(Integer[] notes, int amount) {

		StringBuilder s = new StringBuilder();
		for (int note : notes) {
			int countOfNotes = 0;
			if (note <= amount) {
				//isPresent = true;
				countOfNotes = amount/note;
				amount -= countOfNotes * note;
				s.append(note + ":" + countOfNotes + "\n");
			}
				
		}
		if(amount<=0) {
			System.out.println("\nYour payment approach in order to give min no of notes will be");
			return s;
		}else {
			return s.delete(0, s.length()).append("\nCannot pay using given denominations");
		}
	}
}