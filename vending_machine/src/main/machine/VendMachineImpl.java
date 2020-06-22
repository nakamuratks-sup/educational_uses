package main.machine;

import java.util.ArrayList;
import java.util.List;

import main.goods.Goods;

public class VendMachineImpl implements VendMachine {
	private Integer coin=0;



	@Override
	public void inputCoin(Integer coin) {
		this.coin += coin;

	}

	@Override
	public Integer getTotalCoin() {
		return this.coin;
	}

	@Override
	public void RejectCoin() {
		this.coin = 0;

	}

	@Override
	public List<Goods> getGoodsList() {
		List<Goods> list = new ArrayList<Goods>();
		list.add(createGoods());
		return list;
	}

	@Override
	public Goods getGoods(Integer itemNum) {
		return createGoods();
	}


	/**
	 * 商品無限製造
	 * @return
	 */
	private Goods createGoods() {
		return new Goods() {
			private Integer price = 100;
			private String name = "Hage Coku";

			@Override
			public Integer getPrice() {
				return price;
			}

			@Override
			public String getName() {
				return name;
			}

			@Override
			public String getGoodsInfo() {
				return "| " + 1 + " | " + price + " | " + name + " |";
			}
		};
	}

}
