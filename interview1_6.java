//Given an image represented by an NxN matrix, where each pixel in the image is 4
//bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

public class interview1_6 {

	public static void main (String[] args) {
		int size = Integer.parseInt(args[0]);
		int[][] image = new int[size][size];

		int data = 1;
		for (int i=0; i<size; i++) {
			for (int j=0; j < size; j++) {
				System.out.format("%3d", data);
				image[i][j] = data++;
			}
			System.out.println("");
		}

		//rotateRight(image);
		rotateRightInPlace(image);
		
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

	public static void rotateRightInPlace(int[][] image) {
		int size = image[0].length;
		System.out.println("size : " + size);

		int k = 1;
		int rowCnt = (size % 2 == 0) ? size /2 : size /2 - 1;
		for (int i=0; i<size/2; i++) {
			for (int j=i; j < size - k; j++) {
				image = rotRight(image, i, j);
			}
			k++;
		}

		for (int i=0; i<size; i++) {
			for (int j=0; j < size; j++) {
				System.out.format("%3d", image[i][j]);
			}
			System.out.println("");
		}

	}

	private static int[][] rotRight(int[][] image, int i, int j) {
		int size = image[0].length;
		int pixel = image[j][size-i-1];
		image[j][size-i-1] = image[i][j];
		int pixel2 = image[size-i-1][size-j-1];
		image[size-i-1][size-j-1] = pixel;
		int pixel3 = image[size-j-1][size-(size-i-1)-1];
		image[size-j-1][size-(size-i-1)-1] = pixel2;
		image[size-(size-i-1)-1][size-(size-j-1)-1] = pixel3;
		return image;
	}

}
