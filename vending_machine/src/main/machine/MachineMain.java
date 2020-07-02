package src.main.machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import src.main.goods.Goods;
import src.main.menue.CommandMenue;

/**
 * 自販機本体
 * @author nakamuratakasi
 *
 */
public class MachineMain {

	private VendMachine venmachine;
	private CoinControl coinctrl;

	public MachineMain() {

	}


	public void setVenmachine(VendMachine venmachine) {
		this.venmachine = venmachine;
	}


	public void setCoinctrl(CoinControl coinctrl) {
		this.coinctrl = coinctrl;
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

	/**
	 * 操作選択
	 * @return
	 */
	private CommandMenue command() {
		// 商品一覧表示
		System.out.println("################");
//		System.out.println("ここに商品を表示");
		for(Goods goods: venmachine.getGoodsList()) {
			System.out.println(goods.getGoodsInfo());
		}
		System.out.println("################");
		System.out.println("");

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

	/**
	 * 入金処理
	 */
	private void coinCommand() {
		System.out.println("");
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
		}catch(NumberFormatException ne) {
			System.out.println("### 数字を入力してください！ ###");
			reslt=0;
		}
		coinctrl.inputCoin(reslt);

		System.out.println("現在の入金額は" + coinctrl.getTotalCoin() + "円です");

	}

	/**
	 * 商品選択
	 */
	private void choiceItem() {
		Integer item;

		System.out.println("### 商品を選んでください ###");
		System.out.print(">");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = br.readLine();
			item = Integer.valueOf(str);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			item = 0;
		} catch (NumberFormatException e) {
			// TODO: handle exception
			item = 0;
		}

		Goods goods = venmachine.getGoods(item);
		if(coinctrl.isBuy(goods)) {
			System.out.println("選んだ商品はこれです:" + goods.getName());
			System.out.println("中身は？:" + goods.open());
		}else {
			System.out.println("金額が不足しています");
		}


	}

}
