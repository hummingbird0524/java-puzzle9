/* **************************************************
 * オープンキャンパス
 * 　Javaで作ろう！9パズル
 * **************************************************/

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import action.MoveAction;
import action.NewGameAction;
import gui.Puzzle9Gui;

/**
 * Puzzle9メインClass
 * 
 * @author	y_nishikawa
 */
public class Puzzle9Main{
	
	/**
	 * main処理
	 * 
	 * @param	args	(String[])引数
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					Puzzle9Gui		win = new Puzzle9Gui();
					NewGameAction	nga = new NewGameAction(win.pnlNum);
					MoveAction		ma  = new MoveAction(win.pnlNum);
					
					/* **************************************************
					 * [New Game]ボタンクリック時の動作設定
					 * **************************************************/
					// ==================================================
					// FIXME ②新規ゲーム開始処理を書かないと！
					// ==================================================
					win.btnNewGame.addActionListener(
						new ActionListener(){
							public void actionPerformed(ActionEvent e){
								nga.newGame();
							}
						}
					);
					
					/* **************************************************
					 * パネルクリック時の動作設定
					 * **************************************************/
					win.pnlNum.addMouseListener(new MouseListener(){
						// マウスボタンが押された場合の動作
						public void mousePressed(MouseEvent  e){
							// ==================================================
							// FIXME ①タイルを動かす処理を書かないと！
							// ==================================================
							ma.movePanel(e.getX(), e.getY());
						}
						
						// マウスボタンが放された場合の動作
						public void mouseReleased(MouseEvent e){}
						
						// マウスカーソルが乗った場合の動作
						public void mouseEntered(MouseEvent  e){}
						
						// マウスカーソルが離れた場合の動作
						public void mouseExited(MouseEvent   e){}
						
						// マウスボタンがクリックされた場合の動作
						public void mouseClicked(MouseEvent  e){}
					});
					
					// ウィンドウを表示する
					win.setVisible(true);
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
}
