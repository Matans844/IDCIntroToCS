package Final2018MoedA;

public class LinkedListDemo {

	public static void main(String[] args) {
		// Illustrates creating a list and adding some values
		int[] a = {3,7,2};
		LinkedList aList = new LinkedList(a);
		System.out.println(aList); // (3 7 2)
		
		aList.addFirst(5);
		aList.addLast(4);
		System.out.println(aList); // (5 3 7 2 4)
		
		// Illustrates creating a list and adding some values in order
		int[] b= {12,9,5};
		LinkedList bList = new LinkedList(b);
		System.out.println(bList);

		bList.addDecreasingOrder(28);
		bList.addDecreasingOrder(6);
		System.out.println(bList); // (28 12 9 6 5)
		
		// Illustrates using the exists method (Relevant to question 7 only)
		System.out.println(exists(7,aList)); // true
		System.out.println(exists(8,aList)); // false
		
		// Illustrates using the biggestNumber method (relevant to question 8 only)
		System.out.println(biggestNumber(507041)); // 754100
		
	}
	
	// The following two methods are relevant only to questions 7 and 8 in the exam.
	
	/** Returns true if the given integer exists in the given list
	 * 
	 */
	public static boolean exists(int x, LinkedList list) {
		if (list.lastIndexOf(x) != -1) {
			return true;
		} else {
			return false;
		}
	}
	
	/** Returns the biggest integer that can be constructed from the digits
	 * of the given integer. For example, if x=231, returns 321.
	 * 
	 */
	public static int biggestNumber(int x) {
		int result = 0;
		int copyX = x;
		if (copyX==0) {
			return result;
		} else {
			LinkedList aList = new LinkedList();
			while (copyX > 1) {
				aList.addDecreasingOrder(copyX%10);
				copyX = copyX/10;
			}
			for (int i=0; i<aList.size;i++) {
				result += aList.get(i)*((int)(Math.pow(10, aList.size-i)));
			}
			return result;
		}
	}

}
