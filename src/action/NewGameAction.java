package action;

import javax.swing.JOptionPane;

import gui.Puzzle9Master;
import gui.Puzzle9Panel;

public class NewGameAction{
	/** Panel)数字パネル   */
	public Puzzle9Panel	pnlNum;
	
	// ====================================================================================================
	
	/**
	 * コンストラクター
	 */
	public NewGameAction(Puzzle9Panel pnlNum){
		this.pnlNum = pnlNum;
	}
	
	/**
	 * NewGameボタン押下処理
	 */
	public void newGame(){
		int	cfmResult = JOptionPane.showConfirmDialog(pnlNum
													  , Puzzle9Master.NEW_GAME_MSG
													  , "NewGame前の確認"
													  , JOptionPane.YES_NO_OPTION
		);
		
		if(cfmResult == JOptionPane.YES_OPTION){
			// "はい"押下時
			pnlNum.reset();
			pnlNum.repaint();
		}
	}
}
