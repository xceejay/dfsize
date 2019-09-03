import java.util.*;
import java.io.*;

public class dirsize {
	public static void main(String[] args) {
		try {
			File file = new File("/home/joel/dirsize");
			System.out.print(findSize(file));
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static String findSize(File file) throws Exception {
		String size = "0.0K";
		String Line = "";
		double K = 0.0;
		double M = 0.0;
		double G = 0.0;
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) {
			Line = input.nextLine();
			if (Line.endsWith("K")) {
				Line = Line.replaceAll("K", "");
				Line = Line.replaceAll(" ", "");
				K += Double.parseDouble(Line);
			} else if ((Line.endsWith("M"))) {
				Line = Line.replaceAll("M", "");
				Line = Line.replaceAll(" ", "");
				M += Double.parseDouble(Line);
			} else {
				Line = Line.replaceAll("G", "");
				Line = Line.replaceAll(" ", "");
				G += Double.parseDouble(Line);
			}
		}
		M *= 1024.0;
		G *= 1000000.0;
		K += (G + M);
		if (K > 1024.0 && K < 1000000.0) {

			size = String.format("%.2fM", K / 1024.0);
		} else if (K > 1000000.0) {
			size = String.format("%.2fG", K / 1000000.0);
		} else {
			size = String.format("%.2fK", K);
		}
		return size;
	}
}
