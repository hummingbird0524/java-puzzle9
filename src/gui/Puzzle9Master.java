package gui;

import java.awt.Color;

/**
 * Puzzle9マスター関連Class
 * 
 * @author	y_nishikawa
 */
public class Puzzle9Master{
	/** 行数              */
	public static final int		ROWS         = 3;
	/** 列数              */
	public static final int		COLS         = 3;
	/** セルサイズ        */
	public static final int		CELL_SIZE    = 150;
	
	/** 背景色            */
	public static final Color	PNL_BG_COLOR = Color.darkGray;
	/** 数字パネル背景色  */
	public static final Color	NUM_BG_COLOR = Color.white;
	/** 数字パネル文字色  */
	public static final Color	NUM_COLOR    = Color.red;
	
	/** NewGameメッセージ */
	public static final String	NEW_GAME_MSG = "新しいパズルを開始します。\nよろしいですか？";
	/** クリアメッセージ  */
	public static final String	CLEAR_MSG    = "Congratulation！\nクリアおめでとう！";
	
	// ====================================================================================================
}
