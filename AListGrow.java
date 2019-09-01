//Lab 3 array Lists // Jaymee Hyppolite
import java.io.*;
import java.util.*;


class AListG extends AList<E>{
	public static void Grow(AList) {
		if (AList.listSize == AList.maxSize) {
			int arr2[] = new int[2*Alist.maxSize];
			for (int i = 0; i < Alist.listSize; i++) {
				arr2[i] = Alist[i];
				
				
			}
			AList = arr2;
			
		}
		
	}
	
	
}

