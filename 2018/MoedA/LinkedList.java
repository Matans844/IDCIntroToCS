package Final2018MoedA;

/** A linked list of integers. */

public class LinkedList {

		Node first; // Points to the this list
		int size; // Number of elements in this list
		
		Node grandmasLast;
		
	/** Constructs an empty list. */
	public LinkedList() {
		first = new Node(0); // the list starts with a dummy node
		size = 0;
		grandmasLast = first;
	}
	
	/** Constructs a list from the given array. */
	public LinkedList(int[] arr) {
		// First we create the dummy Node
		first = new Node(0);
		// Then we create the first Node
		Node firstAfterDummy = new Node(arr[0]);
		// We link the dummy Node to the first node
		first.next = firstAfterDummy;
		size++;
		// And we create a previous node, to symbolize the node which is always one
		// step backwards from the nodes that we are creating
		Node previous = firstAfterDummy;
		for (int i = 1; i<arr.length;i++) {
			Node current = new Node(arr[i]);
			previous.next = current;
			previous = current;
			size++;
		}
		grandmasLast = previous;
	}
	
	/** Returns the number of elements in this list. */
	public int size() {
		return size;
	}
	
	/** Returns the value of the elements at the given index.
	 * If the index is out of bounds, throws an IndexOutofBound exception. */
	public int get(int index) {
		if (index>size-1) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
		} else {
			Node currentNode = first.next;
			int currentPosition = 0;
			while (currentPosition < index) {
				currentNode = currentNode.next;
				currentPosition += 1;
			}
			return currentNode.value;
		}
	}
	
	/** Adds the given element to the beginning of this list.*/
	 // This code is given in order to illustrate how to work with the dummy element.
	public void addFirst(int x) {
		Node newNode = new Node(x);
		// Inserts the new element just after the dummy element.
		newNode.next = first.next;
		first.next = newNode;
		size++;
	}
	
	/** Adds the given elements to the end of this list. */
	public void addLast(int x) {
		Node lastNode = new Node(x);
		Node current = this.first.next;
		while (current.next != null) {
			current = current.next;
		}
		current.next = lastNode;
		size++;
	}
	
	public void addLastGrandMaStyle(int x) {
		// First we create a new last node
		Node lastNode = new Node(x);
		// Then we take the last node pointer and point to it.
		grandmasLast.next = lastNode;
		// Then we move the last node to the new last Node.
		grandmasLast = lastNode;
	}
	
	/** Textual representation of this list. */
	// This code is given in order to illustrate one way of iterating over
	// a list using a while or a for
	public String toString() {
		if (size == 0) return "()";
		String str = "( ";
		Node current = first.next; //skips the dummy
		while (current != null) {
			str = str+current.value + " ";
			current=current.next;
		}
		return str + ")";
	}
	
	/** Returns the index of the last occurrence of the given element in this list,
	 * or -1 if the element is not in this list
	 */
	 public int lastIndexOf(int x) {
		 int idx = -1;
		 Node current = first.next;
		 for (int i = 0; i<size-1; i++) {
			 if (current.value == x) {
				 idx = i;
			 }
			 current = current.next;
		 }
		 return idx;
	 }
	 
	 /** Assumes that this list is sorted in decreasing order.
	  * Adds the given element to this list, while maintaining the list's order.
	  * Example: if this list is (12 9 3) and x=5, this list becomes (12 9 5 3).
	  * if this list is (12 9 3) and x=17, this list becomes (17 12 9 3)
	  */
	 public void addDecreasingOrder(int x) {
		 Node nodeAddit = new Node(x);
		 if (size == 0) {
			 addFirst(x);
		 } else {
			 Node current = first.next;
			 Node previous = first;
			 while (current.value > x) {
				 System.out.println(current.value);
				 previous = current;
				 current = current.next;
				 if (current == null) {
					 break;
				 }
			 }
			 previous.next = nodeAddit;
			 if (current != null) {
				 nodeAddit.next = current;
			 }
			 size++;
		 }
	 }
	 
	 public boolean exists(int x) {
		if (lastIndexOf(x) != -1) {
			return true;
		} else {
			return false;
		}
	 }
}
