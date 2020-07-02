package src.main.machine;

import src.main.goods.Goods;

public class CoinControlImpl implements CoinControl {

	private Integer totalCoin;

	public CoinControlImpl() {
		// TODO 自動生成されたコンストラクター・スタブ
		totalCoin = 0;
	}

	@Override
	public void inputCoin(Integer coin) {
		// TODO 自動生成されたメソッド・スタブ
		totalCoin += coin;
	}

	@Override
	public Integer getTotalCoin() {
		// TODO 自動生成されたメソッド・スタブ
		return this.totalCoin;
	}

	@Override
	public Boolean isBuy(Goods goods) {
		// TODO 自動生成されたメソッド・スタブ
		if(totalCoin >= goods.getPrice()) {
			return true;
		}
		return false;
	}

	@Override
	public void RejectCoin() {
		// TODO 自動生成されたメソッド・スタブ
		totalCoin = 0;

	}

}
