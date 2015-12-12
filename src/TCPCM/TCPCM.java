package TCPCM;

public class TCPCM {
	private int MoveCode = -1;
	public enum Keys {
		TURNEAST, TURNSOUTH, TURNNORTH, TURNWEST, GET
	}
	
	public void inputMoves(int MoveCode) {
		this.MoveCode = MoveCode;
	}
	
	public int getMoveCode() {
		return MoveCode;
	}
}
