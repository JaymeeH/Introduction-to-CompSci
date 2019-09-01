// Lab 4 // Jaymee Hyppolite
class Scores{// program runs in O(n) time complexity, O(1) space complexity
	static String AddScores(LList<E> list, E item) {
		while (list.curr().next() != null) {
			if(list.getValue() == item) {
				return "Cannot add duplicates";
			}
			if(list.curr.next.next = null) {
				list.append(item);
				return "scores updated";
			}
		}
	}
			
		
		
	
	static String RemoveScores(Llist<E>, E item) {
		while (list.curr().next() != null) {
			if(list.getValue() == item) {
				list.remove();
				return "Score successfully removed";
			}
			
		
	}
		return "name is not within score list";
	
 }
}


class manipulateList extends LList{// program runs in O(n) time complexity, O(n) space complexity
	void ReverseList(LList<E> list) {
		LList<E> temp = new LList<E>;
		temp.head = new DLink<E>;
		temp.curr = temp.head;
		list.curr = list.tail;
		while (list.curr().prev() != null) {
			temp.curr = head.curr;
			list.curr = temp.prev;
			temp.curr = temp.next;
			
			
		}
		
		while (list.curr().next() != null) {
			System.out.println(list.getValue());
			list.curr = list.next;
		}
		temp.curr = temp.head;
		while (list.curr().next() != null) {
			System.out.println(list.getValue());
			list.curr = list.next;
		}
		
	}
}


