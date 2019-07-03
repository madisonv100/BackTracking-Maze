package cs143;
/**
 * 
 */


import java.util.EmptyStackException;

/**
 * @author Robert Ward
 * @param <Item>
 *
 */
public class Stack<Item> implements StackInterface<Item> {

	
	
	private class Link {

	    private Item data;
	    public Link next;

	    public Link(Item data, Link next) {
	        this.data = data;
	        this.next = next;
	    }

	    @SuppressWarnings("unused")
		public Item getData() { return data; }
	  
	}

	/**
	 * Stores the items in the stack
	 */
	private Link topStackLink = null;
	/**
	 * Keeps the number of items in the stack
	 */
	private int count = 0;
	@Override
	public void push(Item item) {
	
		topStackLink = new Link(item,topStackLink );
      	count++;
		
	}

	@Override
	public void pop() {
		
		if(isEmpty())
		{
			throw new EmptyStackException();
		}		
		topStackLink = topStackLink.next;
		count--;
	}

	@Override
	public Item top() {
		
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			return topStackLink.data;
		}
			
	}
	@Override
	public Item topAndPop() {
		

		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{	
			Item temp = topStackLink.data;
			pop();
			return temp;
		}
	}

	@Override
	public boolean isEmpty() {
		
		return count == 0;
	}

	@Override
	public void makeEmpty() {
		while(!isEmpty())
		{
			pop();
		}
		
	}
	public int size()
	{
		return count;
	}
}
