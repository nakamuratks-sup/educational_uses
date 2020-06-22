package main.display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import main.goods.Goods;

public class Display {

	/**
	 * 商品の一覧を表示
	 * @param list
	 */
	public void outputGoods(List<Goods> list) {
		// 商品リストを受け取り出力

		System.out.println("### 商品一覧 ###");
		for(Goods goods: list) {
			System.out.println(goods.getGoodsInfo());
		}
		System.out.println("################");
		System.out.println();
	}

	/**
	 * 商品を選ぶ
	 * @return
	 */
	public Integer inputGoods() {
		System.out.println("### 商品を選んでください ###");
		System.out.print(">");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer reslt=null;
		try {
			String str = br.readLine();
			reslt = Integer.valueOf(str);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return 0;
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return 0;
		}

		System.out.println("################");
		System.out.println();
		return reslt;
	}
}
