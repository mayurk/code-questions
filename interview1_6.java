//Given an image represented by an NxN matrix, where each pixel in the image is 4
//bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

public class interview1_6 {

	public static void main (String[] args) {
		int size = Integer.parseInt(args[0]);
		int[][] image = new int[size][size];

		int data = 1;
		for (int i=0; i<size; i++) {
			for (int j=0; j < size; j++) {
				System.out.print(data);
				image[i][j] = data++;
			}
			System.out.println("");
		}

		rotateRight(image);
		
	}
	public static void rotateRight(int[][] image) {
		int size = image[0].length;
		int[][] newImage = new int[size][size];

		for (int i=0; i<size; i++) {
			for (int j=0; j < size; j++) {
				newImage[j][size-i-1] = image[i][j];
			}
		}

		for (int i=0; i<size; i++) {
			for (int j=0; j < size; j++) {
				System.out.print(newImage[i][j]);
			}
			System.out.println("");
		}

	}

}
