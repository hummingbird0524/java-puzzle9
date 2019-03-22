package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Puzzle9数字パネル関連Class
 * 
 * @author	y_nishikawa
 */
public class Puzzle9Panel extends JPanel{
	/** 行数       */
	private static final int ROWS      = Puzzle9Master.ROWS;
	/** 列数       */
	private static final int COLS      = Puzzle9Master.COLS;
	/** セルサイズ */
	private static final int CELL_SIZE = Puzzle9Master.CELL_SIZE;
	
	/** 数字タイル */
	private Puzzle9Tile[][]	numTiles;
	/** 空地       */
	private Puzzle9Tile		empTile;
	/** フォント   */
	private Font 				font;
	
	// ====================================================================================================
	
	/**
	 * コンストラクター
	 */
	public Puzzle9Panel(){
		// フォント設定
		font = new Font("SansSerif", Font.BOLD, CELL_SIZE / 2);
		
		// サイズ設定
		this.setPreferredSize(new Dimension(CELL_SIZE * COLS, CELL_SIZE * ROWS));
		
		// 背景色設定
		this.setBackground(Puzzle9Master.PNL_BG_COLOR);
		
		// 数字パネル設定
		numTiles = new Puzzle9Tile[ROWS][COLS];
		reset();
	}
	
	/*
	 * (非 Javadoc)
	 * @see	javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int		x;
		int		y;
		String	num;
		
		for(int row=0; row<ROWS; row++){
			for(int col=0; col<COLS; col++){
				// 横位置(列×セルサイズ)
				x   = col * CELL_SIZE;
				// 縦位置(行×セルサイズ)
				y   = row * CELL_SIZE;
				
				// 数字取得
				num = numTiles[row][col].getNum();
				
				if(num != null){
					g.setColor(Puzzle9Master.NUM_BG_COLOR);					// 数字パネル背景色
					g.fill3DRect(x+2, y+2, CELL_SIZE-4, CELL_SIZE-4, true);		// 数字パネル描画
					
					g.setColor(Puzzle9Master.NUM_COLOR);						// 数字文字色
					g.setFont(font);											// フォント
					g.drawString(num, x+(2*CELL_SIZE)/6, y+(3*CELL_SIZE)/4);	// 数字
				}
			}
		}
	}
	
	/**
	 * リセット処理
	 */
	public void reset(){
		/* **************************************************
		 * 数字タイル生成
		 * ※数字はタイルの位置番号を初期設定
		 * **************************************************/
		for(int row=0; row<ROWS; row++){
			for(int col=0; col<COLS; col++){
				numTiles[row][col] = new Puzzle9Tile(row, col, String.valueOf(row * COLS + col + 1));
			}
		}
		
		/* **************************************************
		 * 空白タイル生成
		 * **************************************************/
		empTile = numTiles[ROWS - 1][COLS - 1];
		empTile.setNum(null);
		
		/* **************************************************
		 * タイルシャッフル
		 * **************************************************/
		for(int i=0; i<10000; i++){
			moveTile((int)(Math.random() * ROWS), (int)(Math.random() * COLS));
		}
	}
	
	/**
	 * ゲームオーバー判定
	 * 
	 * @return		(boolean)判定結果(true: 終了 / false: 継続)
	 */
	public boolean isGameOver(){
		boolean	result = true;
		
		for(int row=0; row<ROWS; row++){
			for(int col=0; col<COLS; col++){
				Puzzle9Tile	tile = numTiles[row][col];
				
				if(!tile.isInFinalPosition(row, col)){
					// タイルが1つでも最終位置に存在しない場合、継続
					result = false;
				}
			}
		}
		
		return	result;
	}
	
	/**
	 * タイル移動
	 * 
	 * @param	row	(int)行
	 * @param	col	(int)列
	 */
	public void moveTile(int row, int col){
		if(checkEmpty(row, col, -1, 0)){
			// 左移動
			exchangeTiles(row, col, row-1, col);
			
		}else if(checkEmpty(row, col,  1,  0)){
			// 右移動
			exchangeTiles(row, col, row+1, col);
			
		}else if(checkEmpty(row, col,  0,  -1)){
			// 上移動
			exchangeTiles(row, col, row, col-1);
			
		}else if(checkEmpty(row, col,  0,  1)){
			// 下移動
			exchangeTiles(row, col, row, col+1);
		}
	}
	
	/**
	 * タイルの移動(入れ替え)
	 * 
	 * @param	befRow	(int)移動元タイル行
	 * @param	befCol	(int)移動元タイル列
	 * @param	aftRow	(int)移動先タイル行
	 * @param	aftCol	(int)移動先タイル列
	 */
	private void exchangeTiles(int befRow, int befCol, int aftRow, int aftCol){
		Puzzle9Tile	tile = numTiles[befRow][befCol];
		
		// 移動元と移動先のタイルを入れ替える
		numTiles[befRow][befCol] = numTiles[aftRow][aftCol];
		numTiles[aftRow][aftCol] = tile;
	}
	
	/**
	 * 空地判定
	 * 
	 * @param	row		(int)行
	 * @param	col		(int)列
	 * @param	rowMove	(int)行移動値
	 * @param	colMove	(int)列移動値
	 * @return			(boolean)判定結果(true: 空地 / false: 非空地)
	 */
	private boolean checkEmpty(int row, int col, int rowMove, int colMove){
		int	newRow = row + rowMove;	// 移動先行
		int	newCol = col + colMove;	// 移動先列
		
		return	(isLegalRowCol(newRow, newCol) && numTiles[newRow][newCol] == empTile);
	}
	
	/**
	 * 有効位置判定
	 * 
	 * @param	row	(int)行
	 * @param	col	(int)列
	 * @return		判定結果
	 */
	private boolean isLegalRowCol(int row, int col){
		return	(row >= 0 && row < ROWS && col >= 0 && col < COLS);
	}
}