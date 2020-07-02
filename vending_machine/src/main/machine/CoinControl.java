package src.main.machine;

import src.main.goods.Goods;

public interface CoinControl {

	// 入金関連
	/**
	 * 入金処理
	 * @param coin
	 */
	void inputCoin(Integer coin);

	/**
	 * @return 現在の投入金額を返す
	 */
	Integer getTotalCoin();

	/**
	 * 金額リセット
	 */
	public void RejectCoin();

	/**
	 * 入金額が購入可能額を満たしているか判定
	 * @param goods
	 * @return
	 */
	Boolean isBuy(Goods goods);

}