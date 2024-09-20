# COMP 2120 F2024

## TASK 1

We are to make a hello world to get adjusted to our enviroment. The bare requirement is to build using javac and run using java.

However, in industry a build tools are the common place. Learning one will make you much more marketable and will significantly EASE your development experience.

In this repo I have provided a a good template on how to structure a maven project, and also demo how to build and run a java program the bare-bones way.


## Task 2

**IMPORTANT**
"diamond.cmd" (.sh respectively) will only run the compiled class the was generated using "compile-maven.cmd"

**So use "compile-maven.cmd" to compile and use "diamond.cmd" to run your code**

We are to make an application that prints a diamond given an odd number as input.

I will provided a sample application for you to get started in. I will upload a solution at the start of next weeks lab

What we discussed in the lab that this assignment is very similar to printing a square with an extra layer of complexity.

All printing a Diamond is in practice is printing a squre made up of `spaces` and `*` characters.

To print a square we would do is the following

```java
for (int i = 0; i < length; i++){	// row loop (this loop is responsible for printing a row each iteration)
	for (int j = 0; j < length; j++){	// print loop (this loop is responsible for printing a character each iteration)
		System.out.print("*");
	}
	System.out.print("\n");	//print new line
}
```

so then it is resonable that to print a diamond all we need to do is the following

```java
for (int i = 0; i < length; i++){	// row loop (this loop is responsible for printing a row each iteration)
	for (int j = 0; j < length; j++){	// print loop (this loop is responsible for printing a character each iteration)
		if ( SOME_CONDITION ) {	// SOME_CONDITION is a boolean expression that you need to figure out
			System.out.print(" ");
		} else {
			System.out.print("*");
		}
	}
	System.out.print("\n");	//print new line
}
```

Here is the full solution

```java
// this function assumes length is odd and row and col are positive and less than length
public static boolean shouldPrintSpace(int row, int col, int length) {
	int middle = length / 2;  // assumes length is odd (this is integer division)

	// these if statements reduce this problem to solving just the top left quadrant
	// the -1 is because the length parameter is not 0 indexed think of it like a unit conversion
	if(row < middle) {   // upper half
		if(col < middle){   // left side
			//  do nothing for top left quadrant
		}else{
			col = (length -1) - col; // flip about the middle row for bottom left quadrant
		}   
	} else {
		if(col < middle){   // left side
			row = (length -1) - row; // flip about the middle column for top right quadrant
		}else{
			row = (length -1) - row; // flip about the middle column for bottom right quadrant
			col = (length -1) - col; // flip about the middle row for bottom right quadrant
		}   
	}

	return col + row < middle;  // return true if the row + col is less than middle
}
```