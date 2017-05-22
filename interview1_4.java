//Write a method to decide if two strings are anagrams or not.

public class interview1_4 {

	public static void main(String[] args) {
		if (areAnagrams(args[0], args[1])) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}


	public static boolean areAnagrams(String s1, String s2) {
		if (s1 == null || s2 == null) return false;
		if (s1.length() != s2.length()) return false;
		if (s1.length() == 0) return false;

		int mask1 = 0;
		int mask2 = 0;

		char[] array1 = s1.toCharArray();
		char[] array2 = s2.toCharArray();

		for (int i = 0; i < array1.length; i++ ) {
			mask1 |= 1 << array1[i];
		}

		for (int j = 0; j < array2.length; j++ ) {
			mask2 |= 1 << array2[j];
		}

		return (mask1 == mask2);
	}
}

