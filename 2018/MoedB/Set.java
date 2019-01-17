package Final2018MoedB;

public class Set {

	private static final int DEFAULT_CAPACITY = 100;
	private int[] elements;
	private int size;
	
	/**
	 * Constructs an empty set
	 */
	public Set() {
		elements = new int[DEFAULT_CAPACITY];
		size = 0;
	}
	
	
	/**
	 * Resizes the array that represents this set, by doubling its capacity
	 */
	private void resize() {
		int[] temp = new int[2*elements.length];
		System.arraycopy(elements, 0, temp, 0, elements.length);
		elements = temp;
	}
	
	
	/**
	 * Question 3:
	 * Constructs a set of integers from the given array
	 */
	public Set(int[] arr) {
		elements = new int[DEFAULT_CAPACITY];
		size = 0;
		// First we use the resize as much as needed until it
		// outweights the array length
		while (elements.length < arr.length) {
			resize();
		}
		// Now we start filling in the elements section
		// We start with a running index
		int runningInd = 0;
		// For every array element
		for (int i=0; i<arr.length; i++) {
			// We begin with the assumption that the specific element doesn't
			// exist inside the elements array
			boolean flagExists = false;
			// Then we check if this is indeed the case
			for (int j=0; j<runningInd;j++) {
				if (elements[j] == arr[i]) {
					flagExists = true;
				}
			}
			// If it is not the case, meaning that the specific elements doesn't
			// exist inside the elements array, we add it to the elements array
			if (flagExists == false) {
				elements[runningInd]=arr[i];
				runningInd++;
				size++;
			}
		}
		
	}
	
	
	/**
	 * Returns the size of this set
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Question 1:
	 * Returns true if this set contains the given value (e), false otherwise
	 */
	public boolean contains(int e) {
		for (int i=0; i < size; i++) {
			if (elements[i] == e) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Question 2:
	 * Adds the given value(e) to this set.
	 * If this set already contains the given value, does nothing
	 */
	public void add(int e) {
		// First we check if this set contains the element e
		if (!this.contains(e)) {
			// Then we check if the size equals the capacity
			if (size == DEFAULT_CAPACITY) {
				// If so, we resize
				resize();
			}
			// After resizing, or if we didn't need to resize, we
			// continue
			elements[size] = e;
			size++;
		}
	}
	
	/**
	 * Removes the gives value from this list
	 * If this set already contains the given value, does nothing
	 */
	public void remove(int e) {
		// First we check if this set contains the element e
		if (this.contains(e)) {
			int removeIdx = 0;
			for (int i=0; i<size;i++) {
				if (elements[i] == e) {
					removeIdx = i;
					break;
				}
			}
			System.arraycopy(elements, removeIdx+1, elements, removeIdx, elements.length-1-removeIdx);
			size--;
		}
	}
	
	
	/**
	 * Question 4:
	 * Returns a string representing this set, in the form of
	 * "{e1,e2,e3, ...}", where the e's are the set elements
	 */
	public String toString() {
		// If the set is empty, we return just the curly braces
	    if (size == 0) {
	    	return "{}";
	    }
	    // Otherwise, we use StringBuilder
	    else {
		    StringBuilder str = new StringBuilder();
		    // The size is bigger than 1, we want to use tempSize as
		    // an index
			int tempSize = size-1;
			// Then we start by closing the string from the left
			str.append("{");
			// Then we start adding the elements from last to first.
			// We leave the last case as a special case to be handled
			// separately
			while (tempSize>0) {
				str.append(elements[size-tempSize-1]);
				str.append(",");
				tempSize--;
			}
			// We take care of the last case, which is the element located
			// first in the elements list.
			str.append(elements[size-1]);
			// We close the curly braces from the right
			str.append("}");
			// We return the string
			return str.toString();
	    }
	}
	    
	    /**
	     * Question 5:
	     * Returns the intersection of this set and the other set.
	     * The intersection of sets s1 and s2 is a set containing all the
	     * elements that are both in s1 and in s2.
	     */
	    
    public Set intersection(Set other) {
    	// First we declare some sets as placeholder
    	Set shortSet;
    	Set longSet;
    	// Then we find the appropriate sets
    	if (size < other.size()) {
    		shortSet = new Set(this.elements);
    		longSet = other;
    	} else {
    		shortSet = other;
    		longSet = new Set(this.elements);
    	}
    	// And we also declare an empty outcome variable
    	Set outcome = new Set();
    	// Then we start a loop, that:
    	// - takes each element in the shortSet and
    	// - looks for it in the longSet
    	// If it is found, we add it from the outcome
    	for (int i=0; i<shortSet.size; i++) {
    		for (int j=0; j<longSet.size;j++) {
    			if (shortSet.contains(longSet.elements[j])) {
    				outcome.add(longSet.elements[j]);
    			}
    		}
    	}
    	// We return the outcome set at the end
    	return outcome;
    }
    
    /**
     * Returns the union of this set and the other set.
     * The union of sets s1 and s2 is a set containing all the elements
     * that are either in s1, or in s2, or in both sets
     */
    public Set union(Set other) {
    	// First we declare everything
    	int sizeOther = other.size;
    	int sizeThis = size;
    	int arrSize = sizeOther + sizeThis;
    	int[] arrBig = new int[arrSize];
    	int[] elementsThis = this.elements;
    	int[] elementsOther = other.elements;
    	// Then the loop goes over the elements array from this
    	// and the elements array from other, and picks up every element,
    	// then it adds it to the arr array.
    	for (int i=0; i<sizeThis; i++) {
    		arrBig[i] = elementsThis[i];
    	}
    	for (int j=0; j<sizeOther;j++) {
    		arrBig[sizeThis+j] = elementsOther[j];
    	}
    	// Then we move transform arr into Set using the constructor
    	Set result = new Set(arrBig);
    	return result;
    }
    
    
    /**
     * Returns true if this set is a subset of the other set.
     * Set s1 is a subset of set s2 if every element of s1 is also an element in s2.
     * Note: the empty set is a subset of any set.
     */
    public boolean subsetOf(Set other) {
    	// Here we first find the intersecting set
    	Set intersectSet = this.intersection(other);
    	// Then we check for sizes: if the size of the intersection set
    	// is the same as the size of the original set, this means that all the
    	// elements from this set got in, and that happens if and only if every
    	// element in the intersecting set is in this set
    	if (intersectSet.size == this.size) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * Returns true if this set equals the other set.
     * Set s1 equals set s2 if both sets contain exactly the same elements.
     */
    public boolean equals(Set other) {
    	// Creating first the interersection set, and the union set
    	Set intersectSet = this.intersection(other);
    	Set unionSet = this.union(other);
    	// Now equality follows if and only if the other set is a subset of
    	// this set and vice versa
    	if ((intersectSet.subsetOf(unionSet) & 
    			unionSet.subsetOf(intersectSet)) == true) {
    		return true;
    	} else {
    		return false;
    	} 	
    }
    
    /**
     * Returns the difference between this set and the other set.
     * The difference between sets s1 and s2 is a set containing all the elements
     * that are in s1 but not in s2
     */
    public Set diff(Set other) {
    	Set resultSet = new Set();
    	// First, we check if this set is a subset of the other set.
    	// If so, we return an empty set.
    	if (this.subsetOf(other)) {
    		return resultSet;
    	} 
    	// If this is not the case, we just remove the elements of other
    	// from the elements of this Set
    	resultSet = new Set(this.elements);
    	for (int i=0; i<other.elements.length; i++) {
			resultSet.remove(other.elements[i]);
    	}
    	return resultSet;
    }
}
