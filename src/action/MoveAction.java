package action;

import javax.swing.JOptionPane;

import gui.Puzzle9Master;
import gui.Puzzle9Panel;

public class MoveAction{
	/** Panel)数字パネル   */
	public Puzzle9Panel	pnlNum;
	
	// ====================================================================================================
	
	/**
	 * コンストラクター
	 */
	public MoveAction(Puzzle9Panel pnlNum){
		this.pnlNum = pnlNum;
	}
	
	/**
	 * パネル移動
	 * 
	 * @param	x	(int)クリック地点X座標
	 * @param	y	(int)クリック地点Y座標
	 */
	public void movePanel(int x, int y){
		int	row = y / Puzzle9Master.CELL_SIZE;	// 行判定：Y座標÷セルサイズ
		int	col = x / Puzzle9Master.CELL_SIZE;	// 列判定：X座標÷セルサイズ
		
		// タイル移動
		pnlNum.moveTile(row, col);
		// 再描画
		pnlNum.repaint();
		
		if(pnlNum.isGameOver()){
			// ゲーム終了
			JOptionPane.showMessageDialog(pnlNum
										  , Puzzle9Master.CLEAR_MSG
										  , "Conguratulation"
										  , JOptionPane.PLAIN_MESSAGE
			);
		}
	}
}
