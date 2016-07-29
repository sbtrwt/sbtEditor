public class Encoder{
	private final int key = 0x43;
	public Encoder(){
	}
	public int Decode(int value){
		return value^key;
	}
	/*public int Decode(char value){
		return value^key;
	}*/
}