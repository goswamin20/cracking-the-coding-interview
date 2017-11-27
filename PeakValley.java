package Sorting;

import java.util.*;

public class PeakValley {
public static void main(String[] args) {
	int[] input=new int[]{4,9,8,2,3,1,7};
	
	PeakValley pv=new PeakValley();
	System.out.println("Solution:");
	pv.print(pv.findAlternatePeakValley(input));
	System.out.println("Optimal Solution:");
	pv.print(pv.optimalFindAlternatePeakValley(input));
}

private void print(int[] output) {
	for(int i:output){
		System.out.println(i);
	}

	
}

private int[] optimalFindAlternatePeakValley(int[] input) {
	for(int i=0;i<input.length;i++){
		int maxIndex=findMax(input,i-1,i,i+1);
		
		if(i!=maxIndex){
			input[i]=input[maxIndex]^input[i];
			input[maxIndex]=input[maxIndex]^input[i];
			input[i]=input[maxIndex]^input[i];
		}
	}
	return input;
}

private int findMax(int[] input, int i1, int i2, int i3) {
	int val1=i1>=0 && i1<input.length?input[i1]:Integer.MIN_VALUE;
	int val2=i2>=0 && i2<input.length?input[i2]:Integer.MIN_VALUE;
	int val3=i3>=0 && i3<input.length?input[i3]:Integer.MIN_VALUE;
	int max=Math.max(val1,Math.max(val2, val3));
	if(max==val1)
		return i1;
	else if(max==val2)
		return i2;
	else
	return i3;
}

private int[] findAlternatePeakValley(int[] input) {
	Arrays.sort(input);
	for(int i=1;i<input.length;i+=2){
		input[i]=input[i-1]^input[i];
		input[i-1]=input[i-1]^input[i];
		input[i]=input[i-1]^input[i];
	}
	return input;
}
}
