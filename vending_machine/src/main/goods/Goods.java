package main.goods;

/**
 * 商品インタフェース
 * @author nakamuratakasi
 *
 */
public interface Goods {

	/**
	 * 商品名を返す
	 * @return
	 */
	public String getName();


	/**
	 * 価格を返す
	 * @return
	 */
	public Integer getPrice();

	/**
	 * 商品情報を成形して返す
	 * @return
	 */
	public String getGoodsInfo();
}
