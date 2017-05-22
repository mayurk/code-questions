//Write a method to replace all spaces in a string with ‘%20’.

public class interview1_5 {

	public static void main(String[] args) {
		replaceSpaces(args[0]);
	}

	public static void replaceSpaces(String str) {
		StringBuilder b = new StringBuilder();
		char[] array = str.toCharArray();
		boolean flag = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == ' ') {
				if (!flag) b.append("%20");
				flag = true;
			}
			else {
				b.append(array[i]);
				flag = false;
			}
		} 

		System.out.println("str : " + b.toString());
	}

}
