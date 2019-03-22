package	gui;

/**
 * Puzzle9タイル関連Class
 * 
 * @author	y_nishikawa
 */
public class Puzzle9Tile{
	/** 最終位置(行) */
	private int		finalRow;
	/** 最終位置(列) */
	private int		finalCol;
	/** 数字         */
	private String	dispNum; 
	
	// ====================================================================================================
	
	/**
	 * コンストラクター
	 * 
	 * @param	row	(int)行
	 * @param	col	(int)列
	 * @param	num	(String)数字
	 */
	public Puzzle9Tile(int row, int col, String num){
		finalRow = row;
		finalCol = col;
		dispNum  = num;
	}
	
	/**
	 * 数字設定
	 * 
	 * @param	num	(String)数字
	 */
	public void setNum(String num){
	    dispNum = num;
	}
	
	/**
	 * 数字取得
	 * 
	 * @return		(String)数字
	 */
	public String getNum(){
		return	dispNum;
	}
	
	/**
	 * 最終位置判定
	 * 
	 * @param	row	(int)タイル行
	 * @param	col	(int)タイル列
	 * @return		(boolean)判定結果(true: 最終位置 / false: 以外)
	 */
	public boolean isInFinalPosition(int row, int col){
		return	(row == finalRow && col == finalCol);
	}
}