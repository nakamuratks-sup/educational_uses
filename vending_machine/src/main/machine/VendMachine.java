package main.machine;

import java.util.List;

import main.goods.Goods;

public interface VendMachine {

	// 入金関連
	/**
	 * 入金処理
	 * @param coin
	 */
	public void inputCoin(Integer coin);

	/**
	 * 現在の入金額を返す
	 * @return
	 */
	public Integer getTotalCoin();

	/**
	 * 金額リセット
	 */
	public void RejectCoin();


	// 商品関連
	/**
	 * 商品の一覧を返す
	 * @return
	 */
	public List<Goods> getGoodsList();

	/**
	 * 選択した番号の商品を返す
	 * @param itemNum
	 * @return
	 */
	public Goods getGoods(Integer itemNum);


}
