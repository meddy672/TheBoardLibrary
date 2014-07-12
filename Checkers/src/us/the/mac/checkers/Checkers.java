package us.the.mac.checkers;

import us.the.mac.board.BoardDisplay;
import us.the.mac.knighted.R;
import android.os.Bundle;
import android.view.Menu;

public class Checkers extends BoardDisplay {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkers);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.knighted, menu);
		return true;
	}

	@Override public void startGame() { }
	@Override public int getServerPlayerTime() { return -1; }
	@Override public us.the.mac.board.Board.Color getServerPlayerColor() { return null; }
	@Override public void startClientGameAs(us.the.mac.board.Board.Color c, int t) { }
}
