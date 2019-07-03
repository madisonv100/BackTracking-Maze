package cs143;
/**
 * 
 */


/**
 * @author Robert Ward
 *
 */
public interface StackInterface <Item> {
	
	/**
	 * Insert a new item into the stack.
	 * @param item the item to insert.
	 */
	public void push(Item item);
	
	/**
	 * Remove the most recently inserted item from the stack.
	 */
	public void pop();
	
	/**
	 * Get the most recently inserted item in the stack. Does not alter the stack.
	 * 
	 */
	public Item top();
	
	/**
	 * Return and remove the most recently inserted item from the stack.
	 *  @return the most recently inserted item in the stack.
	 */
	Item topAndPop();
	/**
	 * Test if the stack is logically empty.
	 *  @return true if empty, false otherwise.
	 */
	public boolean isEmpty();
	/**
	 *Make the stack logically empty.
	 */
	public void makeEmpty();
	
	/**
	 *Return the size of the stack.
	 */
	public int size();
	
}


