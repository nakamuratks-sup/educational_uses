package src.main.machine;

import java.util.ArrayList;
import java.util.List;

import src.main.goods.Goods;

public class VendMachineImpl implements VendMachine {

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

			@Override
			public String open() {
				// TODO 自動生成されたメソッド・スタブ
				return "なかなか美味しい";
			}
		};
	}

}
