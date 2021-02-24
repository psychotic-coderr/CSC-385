import java.util.ArrayList;
import java.util.Arrays;

public class TestHarness {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonElements<String> myMatrix = new CommonElements<>(); 
		
		Comparable[] col_1 = {"X", "B", "A", "G", "N"};
		
		
		Comparable[][] collections = {col_1};
		
		Comparable[] yo = myMatrix.findCommonElements(collections);
		
		System.out.println("Length: " + yo.length);
		
		myMatrix.toString(yo);
		
		System.out.println("No. of element comparisions: " + myMatrix.getComparisions());

	}
}