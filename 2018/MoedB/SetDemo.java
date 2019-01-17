package Final2018MoedB;

public class SetDemo {

	public static void main(String[] args) {

		int[] arr1 = {4, 1, 2};
		Set s1 = new Set(arr1);
		s1.add(1);;
		s1.add(3);
		System.out.println(s1); // Prints {4,1,2,3}
		
		int[] arr2 = {3,6,2};
		Set s2 = new Set(arr2);
		System.out.println(s2); // Prints {3,6,2}
		
		int[] arr3 = {2,3,6};
		Set s3 = new Set(arr3);
		System.out.println(s3.equals(s2)); // Prints true;
		
		System.out.println(s1.intersection(s2)); // Prints {2,3}
		System.out.println(s1.union(s2)); // Prints {4,1,2,3,6}
		System.out.println(s1); // Prints {4,1,2,3}
		System.out.println(s1.diff(s2)); // Prints {4,1}
		
		System.out.println(s1); // Prints {4,1,2,3}
		System.out.println(s2); // Prints {3,6,2}
		System.out.println(s2.diff(s1)); // Prints {6}
		
		int[] arr4 = {2,3};
		Set s4 = new Set(arr4);
		System.out.println(s4.diff(s3)); // Prints {}
		
		System.out.println(symmetricDiff(s1,s2)); // Prints {4, 1, 6}
	}
	
	/**
	 * Returns the symmetric difference between two given sets.
	 * The symmetric difference between sets s1 and s2 in a set
	 * containing all the elements that are in s1 but not in s2,
	 * and all the elements that are in s2 but not in s1.
	 * 
	 */
	public static Set symmetricDiff(Set s1, Set s2) {
		Set temp1 = s1.diff(s2);
		Set temp2 = s2.diff(s1);
		return temp1.union(temp2);
	}
}
