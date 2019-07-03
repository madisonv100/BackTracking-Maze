
package cs143;

public enum Direction {

	Down('2',0,1),
	Right('6',1,0),
	RightDown('3',1,1),
	LeftDown('1',-1,1),
	Left('4',-1,0),
	LeftUp('7',-1,-1),
	Up('8',0,-1),
	RightUp('9',1,-1);
	
		
	private char mapChar = ' ';
	private int deltaX=0;
	private int deltaY = 0;
	
	
	public int getDeltaX() {
		return deltaX;
	}

	public int getDeltaY() {
		return deltaY;
	}

	private Direction(char mapChar,int deltaX, int deltaY )
	{
		
		this.mapChar = mapChar;
		this.deltaX = deltaX;
		this.deltaY = deltaY;
		
	}

	
	public static Direction getEnumfromChar(char map)
	{
		switch(map)
		{
		case '6':
			return  Direction.Right;
		case '3':
			return  Direction.RightDown;
		case '2':
			return  Direction.Down;
		case '1':
			return  Direction.LeftDown;			
		case '4':
			return  Direction.Left;
		case '7':
			return  Direction.LeftUp;
		case '8':
			return  Direction.Up;
		case '9':
			return  Direction.RightUp;
		default:
				return null;
		   
		}
		
	}	
	public char getMapChar() {
		return mapChar;
	}

	

	
}
