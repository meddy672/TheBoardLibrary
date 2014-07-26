package us.the.mac.checkers.pieces;

import us.the.mac.board.Board;
import us.the.mac.board.Board.Color;
import us.the.mac.board.Board.EndGamePiece;
import us.the.mac.board.Board.Piece;
import us.the.mac.board.Board.Square;
import us.the.mac.knighted.R;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

public class Checker extends Piece {

	public Checker(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void setUpMoves() {
		int diagRight = cur_pos + MOVE_UP_RIGHT;
		int diagLeft = cur_pos + MOVE_UP_LEFT;
		int diagDownRight = cur_pos + MOVE_DOWN_RIGHT;
		int diagDownLeft = cur_pos + MOVE_DOWN_LEFT;


		if (isOpponent(Color.BLACK)) 
		{

			// Check to see if targeted square is Empty
			if (Board.getSquareAt(diagRight).hasPiece() == false
					&& Board.getSquareAt(diagLeft).hasPiece() == false)
			{
				Log.i("Node1", " Empty Squares");
				move_1 = fromCurPos(MOVE_UP_LEFT);
				move_2 = fromCurPos(MOVE_UP_RIGHT);
			} 
			
			
			if (Board.getSquareAt(diagRight).hasPiece() == true
					&& Board.getSquareAt(diagLeft).hasPiece() == true)
			{
				
				Log.i("Node2", "Pieces on Both squares");
				
				if (Board.Piece.getPieceAt(diagRight).isOpponent(Color.BLACK) 
						&& Board.Piece.getPieceAt(diagLeft).isOpponent(Color.BLACK)) 
				{
					Log.i("Node2.1", "Team Piece on Right & Left squares");
					move_1 = INVALID_MOVE;
					move_2 = INVALID_MOVE;
				}
				else if(Board.Piece.getPieceAt(diagRight).isOpponent(Color.WHITE) 
						&& Board.Piece.getPieceAt(diagLeft).isOpponent(Color.WHITE))
				{
					Log.i("Node2.1.1", "Opponent Pieces on Right & Left squares");
					
					
					if(Board.getSquareAt(diagRight+MOVE_UP_RIGHT).hasPiece()==true)
					{
						Log.i("Node2.1.1.JUMPRIGHT", "JUMP NOT POSSIBLE");
						move_2 = INVALID_MOVE;
					}
					else
					{
						move_2 = fromCurPos(MOVE_UP_RIGHT+MOVE_UP_RIGHT);
//						if(Board.getSquareAt(diagRight+MOVE_UP_RIGHT+MOVE_UP_RIGHT).hasPiece()==true)
//						{
//							if(Board.Piece.getPieceAt(diagRight+MOVE_UP_RIGHT+MOVE_UP_RIGHT).isOpponent(Color.WHITE))
//							{
//								if(Board.getSquareAt(diagRight+MOVE_UP_RIGHT+MOVE_UP_RIGHT+MOVE_UP_RIGHT).hasPiece()==true)
//								{
//									move_3 = INVALID_MOVE;
//								}
//								else
//								{
//									move_3 = fromCurPos(diagRight+MOVE_UP_RIGHT+MOVE_UP_RIGHT+MOVE_UP_RIGHT);
//								}
//							}
//						}
//						else
//						{
//							move_3 = INVALID_MOVE;
//						}
					}
					if(Board.getSquareAt(diagLeft+MOVE_UP_LEFT).hasPiece()==true)
					{
						Log.i("Node2.1.1.JUMPLEFT", "JUMP NOT POSSIBLE");
						move_1 = INVALID_MOVE;
					}
					else
					{
						move_1 = fromCurPos(MOVE_UP_LEFT+MOVE_UP_LEFT);
					}	
				}
				else if (Board.Piece.getPieceAt(diagRight).isOpponent(Color.WHITE) 
						&& Board.Piece.getPieceAt(diagLeft).isOpponent(Color.BLACK))
				{
					Log.i("Node2.2", "White on right square");
					if (Board.getSquareAt(diagRight + MOVE_UP_RIGHT).hasPiece() == false) 
					{
						Log.i("Node2.3", "Jump Possible");
						move_2 = fromCurPos(MOVE_UP_RIGHT + MOVE_UP_RIGHT);
						
						//													//
						//GET SQAURES LEFT AND RIGHT AGAIN TO CHECK FOR JUMPS//
						//												  	 //
					}

				}
				else if(Board.Piece.getPieceAt(diagRight).isOpponent(Color.BLACK) && 
						Board.Piece.getPieceAt(diagLeft).isOpponent(Color.WHITE))
				{
					Log.i("Node2.4", "White on Left check for jump");
					if(Board.getSquareAt(diagLeft+MOVE_UP_LEFT).hasPiece()==false)
					{
						Log.i("Node2.5", "Jump Possible");
						move_1 = fromCurPos(MOVE_UP_LEFT+MOVE_UP_LEFT);
					}
				}

			}
			else if (Board.getSquareAt(diagRight).hasPiece() == false
					&& Board.getSquareAt(diagLeft).hasPiece() == true) 
			{
				move_2 = fromCurPos(MOVE_UP_RIGHT);
				
				if (Board.Piece.getPieceAt(diagLeft).isOpponent(Color.BLACK)) 
				{
					move_1 = INVALID_MOVE;
			
				} 
				else if (Board.Piece.getPieceAt(diagLeft).isOpponent(Color.WHITE)) 
				{
					if (Board.getSquareAt(diagLeft + MOVE_UP_LEFT).hasPiece() == true) 
					{
						//move_1 = fromCurPos(MOVE_UP_LEFT + MOVE_UP_LEFT);
						move_1 = INVALID_MOVE;

					}
					else 
					{
						move_1 = fromCurPos(MOVE_UP_LEFT + MOVE_UP_LEFT);
						//													//
						//GET SQAURES LEFT AND RIGHT AGAIN TO CHECK FOR JUMPS//
						//												  	 //
					}
				}

			} 
			if(Board.getSquareAt(diagRight).hasPiece() == true
					&& Board.getSquareAt(diagLeft).hasPiece() == false) 
			{
				move_1 = fromCurPos(MOVE_UP_LEFT);
				if(Board.Piece.getPieceAt(diagRight).isOpponent(Color.BLACK))
				{
					move_2 = INVALID_MOVE;
				}
				else if(Board.Piece.getPieceAt(diagRight).isOpponent(Color.WHITE))
				{
					if(Board.getSquareAt(diagRight + MOVE_UP_RIGHT).hasPiece() == true)
					{
						move_2 = INVALID_MOVE;
						
					}
					else{
						move_2 = fromCurPos(MOVE_UP_RIGHT+MOVE_UP_RIGHT);
						//													 //
						//GET SQAURES LEFT AND RIGHT AGAIN TO CHECK FOR JUMPS//
						//												  	 //
					}
				}
			}

		}
		
		
		
		
		if (isOpponent(Color.WHITE)) {
			if (Board.getSquareAt(diagDownRight).hasPiece() == false
					&& Board.getSquareAt(diagDownLeft).hasPiece() == false) {
				move_1 = fromCurPos(MOVE_DOWN_LEFT);
				move_2 = fromCurPos(MOVE_DOWN_RIGHT);

			} else if (Board.getSquareAt(diagDownRight).hasPiece() == true
					&& Board.getSquareAt(diagDownLeft).hasPiece() == false) {
				move_1 = fromCurPos(MOVE_DOWN_LEFT);
				if (Board.Piece.getPieceAt(diagDownRight).isOpponent(
						Color.WHITE)) {
					move_3 = fromCurPos(INVALID_MOVE);
				} else if (Board.Piece.getPieceAt(diagDownRight).isOpponent(
						Color.BLACK)) {
					if (Board.getSquareAt(diagDownRight + MOVE_DOWN_RIGHT)
							.hasPiece() == false) {
						move_2 = fromCurPos(MOVE_DOWN_RIGHT + MOVE_DOWN_RIGHT);

					}
				} else {
					move_3 = fromCurPos(INVALID_MOVE);
				}

			} else if (Board.getSquareAt(diagDownRight).hasPiece() == false
					&& Board.getSquareAt(diagDownLeft).hasPiece() == true) {
				move_2 = fromCurPos(MOVE_DOWN_RIGHT);
				if (Board.Piece.getPieceAt(diagDownLeft)
						.isOpponent(Color.WHITE)) {
					move_3 = fromCurPos(INVALID_MOVE);
				} else if (Board.Piece.getPieceAt(diagDownLeft).isOpponent(
						Color.BLACK)) {
					if (Board.getSquareAt(diagDownLeft + MOVE_UP_LEFT)
							.hasPiece() == false) {
						move_2 = fromCurPos(MOVE_DOWN_LEFT + MOVE_DOWN_LEFT);
					}
				}

			} 
			else 
			{
				
			}

		}

		// Check to see what type of piece is on right targeted square

		// move_3 = fromCurPos(MOVE_UP_LEFT+MOVE_UP_LEFT);
		// move_2 = fromCurPos(MOVE_UP_RIGHT);// 17
		// move_1 = fromCurPos(MOVE_UP_LEFT+MOVE_UP_LEFT );
		// move_3 = fromCurPos(MOVE_UP_LEFT +MOVE_UP+ MOVE_LEFT);// 15;;
		// move_4 = fromCurPos(MOVE_UP_RIGHT + MOVE_UP+MOVE_RIGHT);// 10;
		// move_5 = fromCurPos(MOVE_DOWN_RIGHT + MOVE_RIGHT);// -6;
		// move_6 = fromCurPos(MOVE_DOWN_RIGHT + MOVE_DOWN);// -15;
		// move_7 = fromCurPos(MOVE_DOWN_LEFT + MOVE_DOWN);// -17;
		// move_8 = fromCurPos(MOVE_DOWN_LEFT + MOVE_LEFT);// -10;
	}
//	public void setUpMoves() {
////
////	    move_1 = validateMove(MOVE_UP_LEFT + MOVE_LEFT);// 6
////	    move_2 = validateMove(MOVE_UP_LEFT + MOVE_UP);// 15;
////	    move_3 = validateMove(MOVE_UP_RIGHT + MOVE_UP);// 17;
////	    move_4 = validateMove(MOVE_UP_RIGHT + MOVE_RIGHT);// 10;
////	    move_5 = validateMove(MOVE_DOWN_RIGHT + MOVE_RIGHT);// -6;
////	    move_6 = validateMove(MOVE_DOWN_RIGHT + MOVE_DOWN);// -15;
////	    move_7 = validateMove(MOVE_DOWN_LEFT + MOVE_DOWN);// -17;
////	    move_8 = validateMove(MOVE_DOWN_LEFT + MOVE_LEFT);// -10;
//	    
//	    
//	    move_1 = validateMove(MOVE_UP_LEFT );// 6
//	    move_2 = validateMove(MOVE_UP_RIGHT );// 6
//
//		int diagRight = cur_pos + MOVE_UP_RIGHT;
//		int diagLeft = cur_pos + MOVE_UP_LEFT;
//		int diagDownRight = cur_pos + MOVE_DOWN_RIGHT;
//		int diagDownLeft = cur_pos + MOVE_DOWN_LEFT;
//		
//		if (isOpponent(Color.WHITE)) {
//			if (Board.getSquareAt(diagDownRight).hasPiece() == false
//					&& Board.getSquareAt(diagDownLeft).hasPiece() == false) {
//				move_1 = fromCurPos(MOVE_DOWN_LEFT);
//				move_2 = fromCurPos(MOVE_DOWN_RIGHT);
//
//			} else if (Board.getSquareAt(diagDownRight).hasPiece() == true
//					&& Board.getSquareAt(diagDownLeft).hasPiece() == false) {
//				move_1 = fromCurPos(MOVE_DOWN_LEFT);
//				if (Board.Piece.getPieceAt(diagDownRight).isOpponent(
//						Color.WHITE)) {
//					move_3 = fromCurPos(INVALID_MOVE);
//				} else if (Board.Piece.getPieceAt(diagDownRight).isOpponent(
//						Color.BLACK)) {
//					if (Board.getSquareAt(diagDownRight + MOVE_DOWN_RIGHT)
//							.hasPiece() == false) {
//						move_2 = fromCurPos(MOVE_DOWN_RIGHT + MOVE_DOWN_RIGHT);
//
//					}
//				} else {
//					move_3 = fromCurPos(INVALID_MOVE);
//				}
//
//			} else if (Board.getSquareAt(diagDownRight).hasPiece() == false
//					&& Board.getSquareAt(diagDownLeft).hasPiece() == true) {
//				move_2 = fromCurPos(MOVE_DOWN_RIGHT);
//				if (Board.Piece.getPieceAt(diagDownLeft)
//						.isOpponent(Color.WHITE)) {
//					move_3 = fromCurPos(INVALID_MOVE);
//				} else if (Board.Piece.getPieceAt(diagDownLeft).isOpponent(
//						Color.BLACK)) {
//					if (Board.getSquareAt(diagDownLeft + MOVE_UP_LEFT)
//							.hasPiece() == false) {
//						move_2 = fromCurPos(MOVE_DOWN_LEFT + MOVE_DOWN_LEFT);
//					}
//				}
//
//			} else {
//				move_3 = fromCurPos(INVALID_MOVE);
//			}
//
//		}
//	}

//	private int validateMove(int move) {
//
//	    int possibleMove = fromCurPos(move);
//	    Piece p = getPieceAt(possibleMove);
//
//	    boolean hasPiece = p != null;
//	    boolean isOpponent = hasPiece && p.isOpponent(color);
//
//	    if(isOpponent)
//	    	//if(Board.getSquareAt(p))
//	        return possibleMove+move;
//	    else if(!hasPiece)
//	    	return possibleMove;
//	    	
//	    return INVALID_MOVE;
//	}


	@Override
	protected int firstColor() {
		return R.drawable.red_checker;
	}

	@Override
	protected int secondColor() {
		return R.drawable.black_checker;
	}

	protected String pieceLetter() {
		return "N";
	}
}
