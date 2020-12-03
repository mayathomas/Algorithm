package stack;

public class Stack<T> {
	
	Object[] array;
	
	int count;
	
	int capacity = 8;
	
	public Stack(){
		count = 0;
		array = new Object[capacity];
	}
	
	public void push(T value) {
		if(count > capacity) {
			capacity = 2 * capacity;
		}
		Object[] newArr = new Object[capacity];
		System.arraycopy(array, 0, newArr, 0, array.length);
		array = newArr;
		array[count++] = value;
	}
	
	@SuppressWarnings("unchecked")
	public T pop() {
		if(count == 0) {
			return null;
		}
		T val = (T)array[count-1];
		count--;
		return val;
	}
	
	@SuppressWarnings("unchecked")
	public T peek() {
		if(count == 0) {
			return null;
		}
		T val = (T)array[count-1];
		return val;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public int getSize() {
		return count;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int i = 0; i < count; i++) {
			str += array[i] + ",";
		}
		if(str.length() > 1) {
			str = str.substring(0, str.length()-1);
		}
		return str;
	}
	
	public void clear() {
		count = 0;
		array = new Object[capacity];
	}
	
	public String getSequence() {
		String str = "";
		for(int i = 0; i < count; i++) {
			str += array[i];
		}
		return str;
	}

}
