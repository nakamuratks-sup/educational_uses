package main.machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.display.Display;
import main.goods.Goods;
import main.menue.CommandMenue;

/**
 * 自販機本体
 * @author nakamuratakasi
 *
 */
public class MachineMain {

	private Display display;
	private VendMachine venmachine;

	public MachineMain() {
		// TODO 自動生成されたコンストラクター・スタブ
		display = new Display();
		venmachine = new VendMachineImpl();
	}


	public void menuMain() {
		// コマンド選択
		boolean flg = true;
		while(flg) {
			CommandMenue cmd = command();
			switch(cmd) {
			case Exit:
				//
				flg = false;
				break;

			case ChoiceItem:
				choiceItem();
				break;
			case InputCoin:
				coinCommand();
				break;

			}
		}

	}

	private CommandMenue command() {
		System.out.println();
		System.out.println("### 操作を選んでください ###");
		System.out.println("0:終了する");
		System.out.println("1:入金する");
		System.out.println("2:商品を選ぶ");
		System.out.print(">");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer reslt=null;
		try {
			String str = br.readLine();
			reslt = Integer.valueOf(str);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return CommandMenue.Exit;
		}

		switch(reslt) {
		case 0: return CommandMenue.Exit;
		case 1: return CommandMenue.InputCoin;
		case 2: return CommandMenue.ChoiceItem;
		default: return CommandMenue.Exit;
		}
	}

	private void coinCommand() {
		System.out.println();
		System.out.println("### 入金額を入れてください ###");
		System.out.print(">");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer reslt=0;
		try {
			String str = br.readLine();
			reslt = Integer.valueOf(str);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			reslt=0;
		}
		venmachine.inputCoin(reslt);
	}

	private void choiceItem() {
		display.outputGoods(venmachine.getGoodsList());
		Integer item = display.inputGoods();
		Goods goods = venmachine.getGoods(item);
		System.out.println();
		System.out.println("選んだ商品はこれです:" + goods.getName());
		System.out.println("おいしい");
		System.out.println();
	}

}
