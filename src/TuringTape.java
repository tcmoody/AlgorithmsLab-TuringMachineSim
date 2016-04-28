import java.util.Iterator;

public class TuringTape {
	public LinkedListStack<Integer> leftSide;
	private LinkedListStack<Integer> rightSide;
	private int head;
	
	public TuringTape(){
		leftSide = new LinkedListStack<Integer>();
		rightSide = new LinkedListStack<Integer>();
		leftSide.push(0);
		rightSide.push(0);
		head = 0;
	}

	public void moveLeft(){
		if(leftSide.isEmpty()){
			leftSide.push(0);
		}
		rightSide.push(head);
		head = leftSide.pop();
	}
	
	public void moveRight(){
		if(rightSide.isEmpty()){
			rightSide.push(0);
		}
		leftSide.push(head);
		head = rightSide.pop();
	}
	
	public int read(){
		return head;
	}
	
	public void write(int a){
		head = a;
	}
	
	public class LinkedListStack<E> implements Iterable<E> {

		private Node first; // top of the stack
		private int N; // # of items

		private class Node {
			E item;
			Node next;
		}

		public boolean isEmpty() {
			return first == null;
		}

		public int size() {
			return N;
		}

		public void push(E item) {
			Node oldfirst = first;
			first = new Node();
			first.item = item;
			first.next = oldfirst;
			N++;
		}

		public E pop() {
			E item = first.item;
			first = first.next;
			N--;
			return item;
		}

		public Iterator<E> iterator() {
			return new ListIterator();
		}

		private class ListIterator implements Iterator<E> {
			private Node current = first;

			public boolean hasNext() {
				return current != null;
			}

			public E next() {
				E item = current.item;
				current = current.next;
				return item;
			}

			public void remove() { /* do nothing */
			}
		}
		
		/**
		 * Is equal to another LinkedListStack? (Has same content in same order.)
		 * @param that
		 * 		Other list to check
		 * @return Whether this is equal to that
		 */
		public Boolean equals(LinkedListStack<E> that) {
			// obvs basecase
			if (this == that) return true;
			// other obvs basecase
			if (this.size() != that.size()) return false;
			
			// setup
			Iterator<E> thisIterator = this.iterator();
			Iterator<E> thatIterator = that.iterator();
			E thisItem;
			E thatItem;
			
			// just check every item
			while (thisIterator.hasNext()) {
				thisItem = thisIterator.next();
				if (thatIterator.hasNext()) {
					thatItem = thatIterator.next();
					if (!thisItem.equals(thatItem)) {
						// items don't match
						return false;
					}
				} else {
					// we already checked length, so wat?
					return false;
				}
			}
			// if we didn't fail yet
			return true;
		}
		
	}

}
