package	gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Puzzle9GUI関連Class
 * 
 * @author	y_nishikawa
 */
public class Puzzle9Gui extends JFrame{
	/** Button)New Game    */
	public JButton		btnNewGame;
	/** Panel)ボタンパネル */
	public JPanel			pnlControl;
	/** Panel)数字パネル   */
	public Puzzle9Panel	pnlNum;
	
	// ====================================================================================================
	
	/**
	 * コンストラクター
	 */
	public Puzzle9Gui(){
		/* **************************************************
		 * フレーム関連設定
		 * **************************************************/
		setTitle("Java 9 Puzzle");										// タイトル指定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				// 閉じるボタン処理
		getContentPane().setLayout(new BorderLayout());					// レイアウト指定
		setResizable(false);											// サイズ変更不可
		
		/* **************************************************
		 * [New Game]ボタン設定
		 * **************************************************/
		btnNewGame = new JButton("New Game");
		pnlControl = new JPanel(new FlowLayout());
		pnlControl.add(btnNewGame);
		add(pnlControl, BorderLayout.NORTH);
		
		/* **************************************************
		 * 数字パネル設定
		 * **************************************************/
		pnlNum = new Puzzle9Panel();
		add(pnlNum, BorderLayout.CENTER);
		
		pack();
	}
}