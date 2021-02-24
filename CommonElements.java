import java.util.Arrays;
import java.util.Collections;

public class CommonElements<T> implements Comparable<T> {
	private int comparisions = 0;   
	Comparable[] common = new Comparable[0];
	Comparable[] commonx = new Comparable[0];

	
	public CommonElements(){
		
	}
	
	public Comparable[] findCommonElements(Comparable[][] collections) {
		Comparable[] CommonCollection;
		
		if (collections.length == 0) {
			System.out.println("Empty array");
			return (new Comparable[0]); 
		}
		
		if (collections.length > 1) {
			Sort(collections);
			
			CommonCollection = new Comparable[0]; 
			
			Comparable[] compareArray = compareThis(collections); 
			Comparable[][] comparedMatrix = collections;  
			
			
			for (int i = 1; i < comparedMatrix.length; i++) {
					
				Comparable[] arrayForComparision = comparedMatrix[i]; 
				
				common = commonx; 
				
				CommonCollection = findCommonElementsTwoArrays (compareArray, arrayForComparision); 
				
				Arrays.sort(CommonCollection);
				
				compareArray = CommonCollection;
			}
		}
		
		else {
			CommonCollection = compareThis(collections); 
		}
		return CommonCollection;
	}
	
	public Comparable[][] Sort(Comparable[][] objArray)
	{
		for (int i = 0; i < objArray.length; i++) {
			Arrays.sort(objArray[i]);
		}
		return objArray; 
	}
	
	public Comparable[] compareThis(Comparable[][] givenMatrix) {
		Comparable[] compareArray = new Comparable[givenMatrix[0].length]; 
		
		compareArray = givenMatrix[0];
		
		return compareArray; 
		
	}
	
	public Comparable[][] toThis(Comparable[][] givenMatrix) { 	
		
		return givenMatrix;
	}
	
	public Comparable[] removeFirstElement(Comparable[] given) {
		
		if (given.length == 0) {
			Comparable[] man = new Comparable[0];
			return man;
		}
		Comparable[] shiftedArray = new Comparable[given.length -1];
		
		System.arraycopy(given, 1, shiftedArray, 0, given.length - 1);
		
		return shiftedArray; 
	}
	
	public Comparable[] addElement(Comparable[] given, Comparable item) {
		Comparable[] addedArray = new Comparable[given.length + 1]; 
		
		System.arraycopy(given, 0, addedArray, 0, given.length);
		addedArray[given.length] = item; 
		
		return addedArray; 
	}
	

	public Comparable[] findCommonElementsTwoArrays(Comparable[] one, Comparable[] two) {
		Comparable[] ccommon = new Comparable[0];
		
		if (one.length == 0 || two.length == 0) {
			return common; 
		}
		
		comparisions++;
		int f = one[0].compareTo(two[0]);
		
		if (f == 0) {
			common = addElement(common, one[0]);
			one = removeFirstElement(one); 
			two = removeFirstElement(two); 
			
			findCommonElementsTwoArrays(one, two);
		}
		else if (f > 0) {
			two = removeFirstElement(two);
			findCommonElementsTwoArrays(one,two);
		}
		else if (f < 0){
			one = removeFirstElement(one);
			findCommonElementsTwoArrays(one,two);
		}
		return common; 
	}
	
	public void toString(Comparable[] collections) {
		int y = 1; 
		for (int i = 0; i < collections.length; i++) {
			if (collections[i] != null) {
				System.out.println(y + " :  " + collections[i] );
				++y;
			}
		}
	}
	
	
	public int getComparisions() {
		return comparisions; 
	}

	@Override
	public int compareTo(T o) {
		if (this.compareTo(o) < 0 || this.compareTo(o) > 0)
			return Integer.signum(this.compareTo(o)); 
		else
			return 0;
	}

}
