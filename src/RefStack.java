/**
 * Seshasai Vishal Vaddadhi
 * Professor Finklestein
 * CMPS12B
 * HW3
 *
 * @param <T>
 */

//We are using the generic type T because it lets us use any type as well as for type safety
public class RefStack<T> {
	private Node<T> top;
	
	public RefStack(){
		top = null;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public void push(T newItem){
		top = new Node<T>(newItem, top);
	}

	@SuppressWarnings("unchecked")
	public T pop(){
		if(!isEmpty()){
			Node<T> temp = top;
			top = top.getNext();
			return (T) temp.getItem();
		}
		return null;
	}
	
	public void popAll(){
		top = null;
	}
	
	@SuppressWarnings("unchecked")
	public T peek(){
		if(!isEmpty()){
			return (T)top.getItem();
		}
		return null;
	}
}

