package src.main.machine;

import java.util.List;

import src.main.goods.Goods;

public interface VendMachine {

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
